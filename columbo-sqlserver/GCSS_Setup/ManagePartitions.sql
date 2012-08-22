USE GCSS
GO

/*
 * Easily create and alter partitions.
 *
 * ATENTION: Exeute as sa.
 */

/* DO THIS ONCE
EXEC master.dbo.sp_configure 'show advanced options', 1
RECONFIGURE
EXEC master.dbo.sp_configure 'xp_cmdshell', 1
RECONFIGURE
*/

/*
 * Show partition distribution per object
 */
IF OBJECT_ID('v_part_distrib_per_object', 'V') IS NOT NULL
	DROP VIEW v_part_distrib_per_object
GO
CREATE VIEW v_part_distrib_per_object
AS
SELECT
	p.object_id 
	, OBJECT_NAME(p.object_id) object_name
	, g.name partition
	, p.rows rows
FROM
	sys.partitions p
	INNER JOIN sys.allocation_units au ON au.container_id = p.hobt_id
	INNER JOIN sys.filegroups g ON g.data_space_id = au.data_space_id
WHERE
	p.object_id > 100
GO

/*
 * Add partition to existing partition scheme/function.
 */
IF OBJECT_ID('p_add_partition', 'P') IS NOT NULL
	DROP PROCEDURE p_add_partition
GO
CREATE PROCEDURE p_add_partition(
	@database          NVARCHAR(255)
	, @partition_name  NVARCHAR(255)
	, @partition_path  NVARCHAR(MAX)
	, @range           NVARCHAR(255)
	, @initial_mb      INT
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	--
	-- Get usable CPUs for SQL Server
	DECLARE @cpu_count INT
	--SELECT @cpu_count = cpu_count FROM sys.dm_os_sys_info
	SELECT @cpu_count = COUNT(*) --, scheduler_id, cpu_id, status, is_online
	  FROM sys.dm_os_schedulers
	 WHERE status = 'VISIBLE ONLINE'
	--
	-- Calculate size for file in filegroup depending on CPUs
	DECLARE @file_size INT
	SET @file_size = gcss.file_size_per_core(@cpu_count, 8, @initial_mb) --ROUND(@initial_mb / @cpu_count, 0)
	--
	DECLARE @stmt NVARCHAR(MAX)
	--
	-- Create new filegroup
	DECLARE @fg_name NVARCHAR(MAX), @fg_num INT, @fg_exists INT
	-- Count existing filegroups for partition
	SELECT @fg_num = COUNT(*)
	  FROM sys.filegroups
	 WHERE UPPER(name) LIKE UPPER(@partition_name) + '%'
	-- Construct name for filegroup
	SET @fg_name = UPPER(@partition_name) + N'_P' + gcss.lpad_str(@fg_num, 2, '0')
	-- Check if filegroup exists
	SELECT @fg_exists = COUNT(*)
	  FROM sys.filegroups
	 WHERE name = @fg_name
	IF @fg_exists = 0
	BEGIN
		SET @stmt = N'ALTER DATABASE ' + @database + N' ADD FILEGROUP ' + @fg_name
		PRINT N'p_add_partition: ' + @stmt
		EXEC(@stmt)
	END
	--
	-- Create directory
	DECLARE @fg_dir NVARCHAR(4000), @fg_dir_cmd NVARCHAR(4000)
	SET @fg_dir = @partition_path + N'\' + @fg_name
	SET @fg_dir_cmd = 'mkdir ' + @fg_dir
	PRINT N'p_add_partition: Creating directory ' + @fg_dir + ' for partition ' + @partition_name
	EXEC master..xp_cmdshell @fg_dir_cmd
	--
	-- Create files for filegroup
	DECLARE @i INT, @fg_filename NVARCHAR(MAX)
	SET @i = 0
	PRINT N'p_add_partition: Creating ' + CAST(@cpu_count AS NVARCHAR) + ' files with ' + CAST(@file_size AS NVARCHAR) + N' MB for partition ' + @partition_name
	WHILE @i < @cpu_count
	BEGIN
		SET @fg_filename = @fg_name + N'_F' + gcss.lpad_str(@i, 2, '0')
		SET @stmt = N'ALTER DATABASE ' + @database + N' ADD FILE (
			NAME = ' + @fg_filename + '
			, FILENAME = N''' + @fg_dir + N'\' + @fg_filename + CASE @i
			                                                      WHEN 0 THEN N'.mdf'
			                                                      ELSE N'.ndf'
			                                                    END + N'''
			, SIZE = ' + CAST(@file_size AS NVARCHAR) + N'MB' + N'
			, FILEGROWTH = ' + CAST(@file_size AS NVARCHAR) + N'MB' + '
		) TO FILEGROUP ' + @fg_name
		PRINT N'p_add_partition: ' + @stmt
		EXEC(@stmt)
		SET @i = @i + 1
	END
	--
	-- Alter partition scheme: add new filegroup
	DECLARE @part_scheme NVARCHAR(MAX)
	SET @part_scheme = LOWER(@partition_name) + '_ps'
	SET @stmt = N'ALTER PARTITION SCHEME ' + @part_scheme + ' NEXT USED ' + @fg_name
	PRINT @stmt
	EXEC(@stmt)
	--
	DECLARE @part_fn NVARCHAR(MAX)
	SET @part_fn = LOWER(@partition_name) + '_pf'
	-- Get type of partition function
	DECLARE @range_type_name NVARCHAR(20)
	SELECT @range_type_name = t.name -- f.name, f.type, f.type_desc, 
	  FROM sys.partition_functions f
	       INNER JOIN sys.partition_parameters p ON p.function_id = f.function_id
	       INNER JOIN sys.types t ON t.system_type_id = p.system_type_id
	 WHERE f.name = @part_fn
	--
	-- Alter partition function: split range
	-- Use single quotes around @range with certain datatypes
	SET @range = CASE LOWER(@range_type_name)
	               WHEN 'nvarchar'  THEN '''' + @range + ''''
	               WHEN 'datetime2' THEN '''' + @range + ''''
	               ELSE @range
	             END
	SET @stmt = 'ALTER PARTITION FUNCTION ' + @part_fn + '() SPLIT RANGE (' + @range +  ')'
	PRINT N'p_add_partition: ' + @stmt
	EXEC(@stmt)
END
GO
GRANT EXECUTE ON p_add_partition TO gcss
GO

/*
 * Create partition filegroups/files and partition scheme/function.
 */
IF OBJECT_ID('p_create_partition', 'P') IS NOT NULL
	DROP PROCEDURE p_create_partition
GO
CREATE PROCEDURE p_create_partition(
	@database            NVARCHAR(255)
	, @partition_name    NVARCHAR(255)
	, @partition_path    NVARCHAR(MAX) -- Base path for data files
	, @datatype          NVARCHAR(50)
	, @range_type        NVARCHAR(10)  -- LEFT, RIGHT
	, @range_values      NVARCHAR(MAX) -- 'Virtual array': comma separated list of values for each partition
	, @num_filegroups    INT = 2       -- Number of filegroups
	, @initial_mb        INT = 128     -- Summarized size of all partitions
	, @default_filegroup NVARCHAR(255) = 'PRIMARY'
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	--
	DECLARE @stmt NVARCHAR(MAX), @part_fn NVARCHAR(255), @part_scheme NVARCHAR(255)
	SET @part_fn = @partition_name + '_pf'
	SET @part_scheme = @partition_name + '_ps'
	--
	-- Create empty partition function
	SET @stmt = N'CREATE PARTITION FUNCTION ' + @part_fn + ' (' + @datatype + ') AS RANGE ' + @range_type + ' FOR VALUES ()'
	PRINT N'p_create_partition: ' + @stmt
	EXEC(@stmt)
	--
	-- Create partition scheme
	SET @stmt = N'CREATE PARTITION SCHEME ' + @part_scheme + ' AS PARTITION ' + @part_fn + ' ALL TO ([' + @default_filegroup + N'])'
	PRINT N'p_create_partition: ' + @stmt
	EXEC(@stmt)
	-- Create partitions
	PRINT N'p_create_partition: Creating ' + CAST(@num_filegroups AS NVARCHAR) + ' filegroups with ' + CAST(@initial_mb AS NVARCHAR) + ' MB each'
	DECLARE @i INT = 0, @part_count INT = 0, @part_range NVARCHAR(MAX)
	SET @part_count = gcss.count_char_in_str(@range_values, ',') + 1
	WHILE @i < @part_count
	BEGIN
		SET @part_range = gcss.get_str_by_index(@range_values, @i, ',')
		PRINT N'p_create_partition: Creating partition ' + @range_type + ', ' + @part_range
		EXEC p_add_partition
				@database = @database
				, @partition_name = @partition_name
				, @partition_path = @partition_path
				, @range = @part_range
				, @initial_mb = @initial_mb
		SET @i = @i + 1
	END
END
GO
GRANT EXECUTE ON p_create_partition TO gcss
GO

/*
 * Merge partition.
 */
IF OBJECT_ID('p_merge_partition', 'P') IS NOT NULL
	DROP PROCEDURE p_merge_partition
GO
CREATE PROCEDURE p_merge_partition(
	@database          NVARCHAR(255)
	, @partition_name  NVARCHAR(255)
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	PRINT ''
END
GO
GRANT EXECUTE ON p_merge_partition TO gcss
GO

/*
 * Merge partition.
 */
IF OBJECT_ID('p_drop_partition', 'P') IS NOT NULL
	DROP PROCEDURE p_drop_partition
GO
CREATE PROCEDURE p_drop_partition(
	@database          NVARCHAR(255)
	, @partition_name  NVARCHAR(255)
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	PRINT ''
END
GO
GRANT EXECUTE ON p_drop_partition TO gcss
GO

/*
 * Create partitions by month.
 */
IF OBJECT_ID('p_create_partition_by_month', 'P') IS NOT NULL
	DROP PROCEDURE p_create_partition_by_month
GO
CREATE PROCEDURE p_create_partition_by_month(
	@database          NVARCHAR(255)
	, @partition_name  NVARCHAR(255)
	, @partition_path  NVARCHAR(MAX)                -- Base path for partition filegroups
	, @years           NVARCHAR(MAX)                -- Comma separated list 
	, @datatype        NVARCHAR(100) = 'datetime'   -- Default
	, @range_type      NVARCHAR(5) = 'RIGHT'        -- Default
	, @initial_mb      INT = 1024                   -- Summarized size of all partitions
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	DECLARE @delim CHAR(1) = ','
	-- Count commas
	DECLARE @count INT = 0
	SET @count = gcss.count_char_in_str(@years, @delim)
	--
	DECLARE @i INT = 0, @years_and_months NVARCHAR(MAX) = '', @act_year INT, @act_mon INT = 1, @ym NVARCHAR(10)
	WHILE @i <= @count
	BEGIN
		SET @act_year = CAST(gcss.get_str_by_index(@years, @i, @delim) AS INT)
		IF @act_year IS NOT NULL
		BEGIN
			SET @act_mon = 1
			WHILE @act_mon <= 12
			BEGIN
				SET @ym = CAST(@act_year AS NVARCHAR) + '-' + gcss.lpad_str(CAST(@act_mon AS NVARCHAR), 2, '0')
				SET @years_and_months = @years_and_months + ',' + @ym + '-01'
				SET @act_mon = @act_mon + 1
			END
		END
		SET @i = @i + 1
	END
	-- Skip first comma in string...
	SET @years_and_months = SUBSTRING(@years_and_months, 2, LEN(@years_and_months) - 1)
	-- Compute partition count and size of each partition
	DECLARE @part_count INT = 0, @part_size INT
	SET @part_count = gcss.count_char_in_str(@years_and_months, ',') + 1
	SET @part_size = gcss.file_size_per_core(@part_count, 8, @initial_mb)
	PRINT N'p_create_partition_by_month: part_size = ' + cast(@initial_mb as nvarchar) + '/' + cast(@part_count as nvarchar)+' = ' + cast(@part_size as nvarchar)
	PRINT N'p_create_partition_by_month: ' + @years_and_months
	-- Create partitions
	EXEC p_create_partition
			@database = @database
			, @partition_name = @partition_name
			, @partition_path = @partition_path
			, @datatype = @datatype
			, @range_type = @range_type
			, @range_values = @years_and_months
			, @num_filegroups = @part_count
			, @initial_mb = @part_size
			, @default_filegroup = 'PRIMARY'
END
GO
GRANT EXECUTE ON p_create_partition_by_month TO gcss
GO

/*
 * Create partitions by a column definition.
 */
IF OBJECT_ID('p_create_partition_by_numeric', 'P') IS NOT NULL
	DROP PROCEDURE p_create_partition_by_numeric
GO
IF OBJECT_ID('p_create_partition_by_column', 'P') IS NOT NULL
	DROP PROCEDURE p_create_partition_by_column
GO
CREATE PROCEDURE p_create_partition_by_column(
	@database              NVARCHAR(255)
	, @table_schema        NVARCHAR(255)
	, @table_name          NVARCHAR(255)
	, @column_name         NVARCHAR(255)
	, @partition_name      NVARCHAR(255)
	, @partition_path      NVARCHAR(MAX)                -- Base path for partition filegroups
	, @range_type          NVARCHAR(5) = 'LEFT'         -- Default
	, @part_count          INT = NULL                   -- Number of partitions for range
	, @max_part_row_count  INT = NULL                   -- Maximum number of rows per partition
	, @initial_mb          NUMERIC = NULL               -- Summarized size of all partitions
)
--WITH EXECUTE AS OWNER
AS
BEGIN
	IF @part_count IS NULL AND @max_part_row_count IS NULL
		BEGIN
			RAISERROR(N'p_create_partition_by_column: Please give a parition count (@part_count) or maximum number of rows per partition (@max_part_row_count)', 18, 256)
		END
	PRINT N'p_create_partition_by_column: Creating partitions for table ' + @table_schema + '.' + @table_name
	--
	-- TODO: Create function
	-- Get datatype of column
	DECLARE @datatype_name NVARCHAR(100), @datatype_prec INTEGER
	SELECT
		@datatype_name = t.name
		, @datatype_prec = CASE
								WHEN t.name = 'datetime2' THEN c.scale
								ELSE c.prec
						   END
	FROM
		syscolumns c
		LEFT JOIN sys.types t ON c.xusertype = t.user_type_id
	WHERE
		id = OBJECT_ID(@table_schema + '.' + @table_name)
		AND c.name = @column_name
	--
	-- Get MIN() and MAX() for NUMERIC column
	PRINT N'p_create_partition_by_column: Gathering statistics about table...'
	DECLARE @stmt NVARCHAR(MAX), @min_value NUMERIC, @max_value NUMERIC, @value_delta NUMERIC, @actual_row_count NUMERIC
	SET @stmt = N'SELECT @min_valueOUT = MIN(' + @column_name + '), @max_valueOUT = MAX(' + @column_name + '), @countOUT = COUNT(*) FROM ' + @table_schema + '.' + @table_name
	EXEC sp_executesql @statement = @stmt
		, @params = N'@min_valueOUT NUMERIC OUTPUT, @max_valueOUT NUMERIC OUTPUT, @countOUT NUMERIC OUTPUT'
		, @min_valueOUT = @min_value OUTPUT
		, @max_valueOUT = @max_value OUTPUT
		, @countOUT = @actual_row_count OUTPUT
	SET @value_delta = ISNULL(@max_value - @min_value, 100000)
	PRINT N'p_create_partition_by_column: Actual row count = ' + CAST(@actual_row_count AS NVARCHAR)
	PRINT N'p_create_partition_by_column: MIN(' + @column_name + ') = ' + CAST(ISNULL(@min_value, 0) AS NVARCHAR) + ', MAX(' + @column_name + ') = ' + CAST(ISNULL(@max_value, 0) AS NVARCHAR)
	PRINT N'p_create_partition_by_column: Difference between MAX(' + @column_name + ') and MIN(' + @column_name + ') = ' + CAST(@value_delta AS NVARCHAR)
	--
	PRINT N'p_create_partition_by_column: Calculating values...'
	-- Calculate total size of partition, if none was given
	IF @initial_mb IS NULL
		BEGIN
			-- Get table size in MB
			DECLARE @actual_mb NUMERIC
			SET @actual_mb = dbo.f_table_size(@table_name)
			-- Maximum length of a row in bytes
			DECLARE @max_row_length NUMERIC
			SELECT
				@max_row_length = SUM(length)
			FROM
				syscolumns
			WHERE
				id = OBJECT_ID(@table_schema + '.' + @table_name)
			-- Check if the table has data hence we know the total size
			IF @actual_mb > 0
				BEGIN
					SET @initial_mb = @actual_mb
					PRINT N'p_create_partition_by_column: Total size of partitions derived from actual table size = ' + CAST(@actual_mb AS NVARCHAR) + ' MB'
				END
			ELSE -- Caculate size on column definitions, take 10% as a first guess
				BEGIN
					-- Minimum row count = 100,000
					IF @actual_row_count = 0
						BEGIN
							SET @actual_row_count = 100000
							SET @max_part_row_count = @actual_row_count
						END
					SET @initial_mb = (@max_row_length * 0.10 * 100000) / 1024 / 1024
					IF @initial_mb < 4
						SET @initial_mb = 4
					PRINT N'p_create_partition_by_column: Estimating total size of all partitions (10% of maximum row length = ' + CAST(@max_row_length AS NVARCHAR)
							+ ' * row count = ' + CAST(@actual_row_count AS NVARCHAR)
							+ ') = ' + CAST(@initial_mb AS NVARCHAR) + ' MB'
				END
		END
	--
	-- Calculate number of partitions or maximum row count per partition
	DECLARE @value_count_per_part NUMERIC
	-- We have maximum number of rows per partion, so
	-- partition count = total row count / maximum rows per partition
	IF @part_count IS NULL AND @max_part_row_count IS NOT NULL
		BEGIN
			SET @part_count = ROUND(@actual_row_count / @max_part_row_count, 0)
		END
	-- Calculate row count per partition depending on existing value range
	SET @value_count_per_part = ROUND(@value_delta / @part_count, 0)
	--
	-- Calculate values for partitions
	DECLARE @approx_rows_per_part NUMERIC
	SET @approx_rows_per_part = ROUND(@actual_row_count / @part_count, 0)
	--
	-- Show values
	PRINT N'p_create_partition_by_column: Total row count = ' + CAST(ISNULL(@actual_row_count, -1) AS NVARCHAR)
			+ ', approx. rows per partition = ' + CAST(ISNULL(@approx_rows_per_part, -1) AS NVARCHAR)
	PRINT N'p_create_partition_by_column: Desired partitions = ' + CAST(@part_count AS NVARCHAR)
			+ ' with total size = ' + CAST(@initial_mb AS NVARCHAR) + ' MB'
	PRINT N'p_create_partition_by_column: Maximum value count per partition = ' + CAST(@value_count_per_part AS NVARCHAR)
	--
	-- Create range values
	DECLARE @n NUMERIC = 0, @i NUMERIC = 1, @range NUMERIC = 0, @range_values NVARCHAR(MAX) = ''
	WHILE @i < @part_count + 1
		BEGIN
			SET @range = ISNULL(@min_value, 1) + @i * @value_count_per_part
			SET @range_values = @range_values + ',' + CAST(@range AS NVARCHAR)
			--PRINT CAST(@i AS NVARCHAR) + N'...... = ' + CAST(ISNULL(@range, -1) AS NVARCHAR)
			SET @i = @i + 1
		END
	SET @range_values = SUBSTRING(@range_values, 2, LEN(@range_values))
	PRINT N'p_create_partition_by_column: Partition range values = ' + @range_values
	--
	-- Create partitions
	PRINT N''
	DECLARE @datatype NVARCHAR(MAX)
	SET @datatype = @datatype_name + '(' + CAST(@datatype_prec AS NVARCHAR) + ')'
	EXEC p_create_partition
			@database = @database
			, @partition_name = @partition_name
			, @partition_path = @partition_path
			, @datatype = @datatype
			, @range_type = @range_type
			, @range_values = @range_values
			, @num_filegroups = @part_count
	--
	-- TODO Move table: clustered index, non-clustered index
END
GO
GRANT EXECUTE ON p_create_partition_by_column TO gcss
GO

/*
EXEC p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'CASE_END2END'
	, @column_name = 'CASE_ID'
	, @partition_name = 'case_end2end_by_case_id'
	, @partition_path = 'E:\AOC1\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 100000
GO

USE GCSS
GO
CREATE UNIQUE CLUSTERED INDEX ce2e_pk
ON stage2.CASE_END2END (
	CASE_ID ASC
)
WITH (
	PAD_INDEX  = OFF
	, STATISTICS_NORECOMPUTE  = OFF
	, SORT_IN_TEMPDB = OFF
	, IGNORE_DUP_KEY = OFF
	, DROP_EXISTING = ON
	, ONLINE = OFF
	, ALLOW_ROW_LOCKS  = ON
	, ALLOW_PAGE_LOCKS  = ON
)
ON case_end2end_by_case_id_ps (case_id)
GO

USE GCSS
GO
CREATE UNIQUE CLUSTERED INDEX ce2e_pk
ON stage2.CASE_END2END (
	CASE_ID ASC
)
WITH (
	PAD_INDEX  = OFF
	, STATISTICS_NORECOMPUTE  = OFF
	, SORT_IN_TEMPDB = OFF
	, IGNORE_DUP_KEY = OFF
	, DROP_EXISTING = ON
	, ONLINE = OFF
	, ALLOW_ROW_LOCKS  = ON
	, ALLOW_PAGE_LOCKS  = ON
)
ON [primary]
GO
*/