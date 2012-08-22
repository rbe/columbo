USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID ('stage1.p_load_hp_country_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_hp_country_dm
GO
CREATE PROCEDURE stage1.p_load_hp_country_dm
	@file              NVARCHAR(255)
	, @formatfile      NVARCHAR(255)
	, @temp_table_name NVARCHAR(255)
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	-- Transaction isolation
	SET TRANSACTION ISOLATION LEVEL SNAPSHOT
	--
	DECLARE @sql AS NVARCHAR(MAX)
	-- Create temporary table
	EXEC('EXEC stage1.p_create_hp_country_dm @table_name = ' + @temp_table_name)
	-- Load data
	-- , X_ISO_CODE
	--	, gcss.f_unwanted_chars(X_ISO_CODE) X_ISO_CODE
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (COUNTRY_ID, COUNTRY_CODE, X_SUPER_REGION, NAME)
	SELECT
		CAST(gcss.f_unwanted_chars(COUNTRY_ID) AS NUMERIC(10, 0)) COUNTRY_ID
		, CAST(gcss.f_unwanted_chars(COUNTRY_CODE) AS NUMERIC(10, 0)) COUNTRY_CODE
		, gcss.f_unwanted_chars(X_SUPER_REGION) X_SUPER_REGION
		, gcss.f_unwanted_chars(NAME) NAME
	FROM
		OPENROWSET(
			BULK ''' + @file + '''
			, FIRSTROW = 2
			, FORMATFILE = ''' + @formatfile + '''
		) t1'
	EXEC(@sql)
	-- Delete temporary table
	EXEC stage1.p_drop_temp_table @temp_table_name = @temp_table_name
END
GO
