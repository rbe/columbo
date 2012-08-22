USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID ('stage1.p_load_employee_table_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_employee_table_dm
GO
CREATE PROCEDURE stage1.p_load_employee_table_dm
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
	EXEC('EXEC stage1.p_create_employee_table_dm @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT INTO stage1.' + @temp_table_name + ' (DATE_ADDED, DATE_MODIFIED, EMPLOYEE_EMAIL, EMPLOYEE_ID, EMPLOYEE_PHONE, EMPLOYEE_TABLE_ID, LOCATION, LOGIN_NAME, RESPONSE_CENTER)
	SELECT
		CAST(gcss.f_unwanted_chars(t1.DATE_ADDED) AS DATETIME2) DATE_ADDED
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(EMPLOYEE_EMAIL) EMPLOYEE_EMAIL
		, gcss.f_unwanted_chars(EMPLOYEE_ID) EMPLOYEE_ID
		, gcss.f_unwanted_chars(EMPLOYEE_PHONE) EMPLOYEE_PHONE
		, CAST(gcss.f_unwanted_chars(EMPLOYEE_TABLE_ID) AS NUMERIC(38)) EMPLOYEE_TABLE_ID
		, gcss.f_unwanted_chars(LOCATION) LOCATION
		, gcss.f_unwanted_chars(LOGIN_NAME) LOGIN_NAME
		, gcss.f_unwanted_chars(RESPONSE_CENTER) RESPONSE_CENTER
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
