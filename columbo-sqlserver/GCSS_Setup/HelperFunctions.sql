/*
 * Create helper functions.
 * Execute as 'gcss'.
 */

USE GCSS
GO

/*
 * Remove 'unwanted characters' from strings.
 */
IF OBJECT_ID('gcss.f_unwanted_chars', 'FN') IS NOT NULL
	DROP FUNCTION gcss.f_unwanted_chars
GO
CREATE FUNCTION gcss.f_unwanted_chars(
	@str NVARCHAR(4000)
)
RETURNS NVARCHAR(4000)
AS
BEGIN
	SET @str = REPLACE(@str, '"', '')
	RETURN @str
END
GO
/*
-- Create synonym
IF OBJECT_ID('gcss.f_unwanted_chars', 'SN') IS NULL
	CREATE SYNONYM [f_unwanted_chars] FOR [gcss].[f_unwanted_chars]
GO
*/
-- Set rights
GRANT EXECUTE ON gcss.f_unwanted_chars TO public;

/*
 * Count character in a string.
 */
IF OBJECT_ID('gcss.count_char_in_str', 'FN') IS NOT NULL
	DROP FUNCTION gcss.count_char_in_str
GO
CREATE FUNCTION gcss.count_char_in_str(
	@str    NVARCHAR(MAX)
	, @c    CHAR(1)
)
RETURNS INT
BEGIN
	DECLARE @i INT = 0, @count BIGINT = 0
	WHILE @i < LEN(@str)
	BEGIN
		IF SUBSTRING(@str, @i, 1) = @c
			SET @count = @count + 1
		SET @i = @i + 1
	END
	RETURN @count
END
GO
-- Set rights
GRANT EXECUTE ON gcss.count_char_in_str TO public;

/*
declare @str nvarchar(10) = 'a,b,c,d'
declare @n int
set @n = gcss.count_char_in_str(@str, ',')
print @n
*/

/*
 * Split a string by a delimiter and return it by index.
 */
IF OBJECT_ID('gcss.get_str_by_index', 'FN') IS NOT NULL
	DROP FUNCTION gcss.get_str_by_index
GO
CREATE FUNCTION gcss.get_str_by_index(
	@str      NVARCHAR(MAX)
	, @index  INT = 0
	, @delim  CHAR(1) = ','
)
RETURNS NVARCHAR(MAX)
BEGIN
	DECLARE @i INT = 0, @delim_count BIGINT = 0, @ci BIGINT = 0, @nci BIGINT = 0, @bla NVARCHAR(MAX) = NULL
	SET @delim_count = gcss.count_char_in_str(@str, @delim)
	WHILE @i <= @delim_count
	BEGIN
		-- Find next char index of @delim
		SET @nci = CHARINDEX(@delim, @str, @ci)
		-- If index is the one user asked for
		IF @i = @index
		BEGIN
			-- Extract string at index
			SET @bla = CASE
						 WHEN @nci > 0 THEN SUBSTRING(@str, @ci, @nci - @ci)
						 ELSE SUBSTRING(@str, @ci, LEN(@str) - @ci + 1)
					   END
			-- Leave while loop
			BREAK
		END
		SET @ci = @nci + 1
		SET @i = @i + 1
	END
	RETURN @bla
END
GO
-- Set rights
GRANT EXECUTE ON gcss.get_str_by_index TO public;

/*
declare @str nvarchar(100) = '2009,2010,2011,2012'
declare @n nvarchar(100)
set @n = gcss.get_str_by_index(@str, 3, ',')
if @n is not null
	print @n
else
	print 'n is null; no result'
*/

/*
 * Split a string by a delimiter and return it by index.
 */
IF OBJECT_ID('gcss.lpad_str', 'FN') IS NOT NULL
	DROP FUNCTION gcss.lpad_str
GO
CREATE FUNCTION gcss.lpad_str(
	@str      NVARCHAR(MAX)
	, @count  INT = 2
	, @char   CHAR(1) = '0'
)
RETURNS NVARCHAR(MAX)
BEGIN
	--
	DECLARE @i INT = 0, @pad NVARCHAR(MAX) = ''
	WHILE @i <= @count
	BEGIN
		SET @pad = @pad + @char
		SET @i = @i + 1
	END
	--
	DECLARE @r NVARCHAR(MAX)
	SET @r = RIGHT(@pad + LTRIM(STR(CASE @str
	                                  WHEN 0 THEN 0
	                                  ELSE @str
	                                END)), @count)
	RETURN @r
END
GO
-- Set rights
GRANT EXECUTE ON gcss.lpad_str TO public;
/*
declare @s nvarchar(100)
set @s = gcss.lpad_str(N'1', 2, '0')
print @s
GO
*/

/*
 * Compute size of files needed for a certain size of a filegroup:
 * there should be one file per core.
 */
IF OBJECT_ID('gcss.file_size_per_core', 'FN') IS NOT NULL
	DROP FUNCTION gcss.file_size_per_core
GO
CREATE FUNCTION gcss.file_size_per_core(
	@cpu_count INT
	, @step_mb INT
	, @goal_mb INT
)
RETURNS INT
BEGIN
	DECLARE @i INT = 0, @mb INT = -1
	WHILE @mb < @goal_mb
	BEGIN
		SET @i = @i + 1
		SET @mb = @cpu_count * @step_mb * @i
	END
	RETURN @step_mb * @i
END
GO
-- Set rights
GRANT EXECUTE ON gcss.file_size_per_core TO public;

/*
declare @n int = 172
print cast(dbo.file_size_per_core(24, 8, @n) as nvarchar)
go

declare @c int = 24
declare @s int = 341
declare @n int = dbo.file_size_per_core(@c, 8, @s)
declare @m int = @n * @c
print cast(@s as nvarchar) + '/' + cast(@c as nvarchar) + ': ' + cast(@n as nvarchar) + ' => ' + cast(@m as nvarchar)
go

declare @needed_mb int, @cores int = 24, @step_mb int = 8, @n int
set @n = dbo.file_size_per_core(@cores, @step_mb, 1024)
print '1024 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
set @n = dbo.file_size_per_core(@cores, @step_mb, 2048)
print '2048 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
GO

declare @needed_mb int, @cores int = 24, @step_mb int = 16, @n int
set @n = dbo.file_size_per_core(@cores, @step_mb, 1024)
print '1024 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
set @n = dbo.file_size_per_core(@cores, @step_mb, 2048)
print '2048 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
GO

declare @needed_mb int, @cores int = 24, @step_mb int = 32, @n int
set @n = dbo.file_size_per_core(@cores, @step_mb, 1024)
print '1024 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
set @n = dbo.file_size_per_core(@cores, @step_mb, 2048)
print '2048 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
GO

declare @needed_mb int, @cores int = 24, @step_mb int = 64, @n int
set @n = dbo.file_size_per_core(@cores, @step_mb, 1024)
print '1024 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
set @n = dbo.file_size_per_core(@cores, @step_mb, 2048)
print '2048 MB / ' + cast(@cores as nvarchar) + ' cores = ' + cast(@n as varchar) + ' MB = ' + cast(@n * 24 as nvarchar) + ' MB'
GO
*/