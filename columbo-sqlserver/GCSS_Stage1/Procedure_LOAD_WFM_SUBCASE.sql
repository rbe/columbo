USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_wfm_subcase', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_wfm_subcase
GO
CREATE PROCEDURE stage1.p_load_wfm_subcase
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
	EXEC('EXEC stage1.p_create_wfm_subcase @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (ACTION_TYPE, CASE_ACCOUNTABILITY_ID, DATE_MODIFIED, DELIVERY_ALTERNATIVE, OPEN_DATE, PARTNER_CO_NAME, SUBCASE_ID, SUBCASE_TRACKING_ID, X_OTC, X_REPAIR_CLASS)
	SELECT
		gcss.f_unwanted_chars(ACTION_TYPE) ACTION_TYPE
		, gcss.f_unwanted_chars(CASE_ACCOUNTABILITY_ID) CASE_ACCOUNTABILITY_ID
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(DELIVERY_ALTERNATIVE) DELIVERY_ALTERNATIVE
		, CAST(gcss.f_unwanted_chars(OPEN_DATE) AS DATETIME2) OPEN_DATE
		, gcss.f_unwanted_chars(PARTNER_CO_NAME) PARTNER_CO_NAME
		, gcss.f_unwanted_chars(SUBCASE_ID) SUBCASE_ID
		, gcss.f_unwanted_chars(SUBCASE_TRACKING_ID) SUBCASE_TRACKING_ID
		, gcss.f_unwanted_chars(X_OTC) X_OTC
		, gcss.f_unwanted_chars(X_REPAIR_CLASS) X_REPAIR_CLASS
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
