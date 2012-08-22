USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_onsite_log_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_onsite_log_dm
GO
CREATE PROCEDURE stage1.p_load_onsite_log_dm
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
	EXEC('EXEC stage1.p_create_onsite_log_dm @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (ACCOUNTABILITY_ID, CASE_ID, DATE_MODIFIED, EMPLOYEE_TABLE_ID, NOTES, ONSITE_LOG_ID, PERF_BY)
	SELECT
		gcss.f_unwanted_chars(ACCOUNTABILITY_ID) ACCOUNTABILITY_ID
		, gcss.f_unwanted_chars(CASE_ID) CASE_ID
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(EMPLOYEE_TABLE_ID) EMPLOYEE_TABLE_ID
		, gcss.f_unwanted_chars(NOTES) NOTES
		, gcss.f_unwanted_chars(ONSITE_LOG_ID) ONSITE_LOG_ID
		, gcss.f_unwanted_chars(PERF_BY) PERF_BY
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
