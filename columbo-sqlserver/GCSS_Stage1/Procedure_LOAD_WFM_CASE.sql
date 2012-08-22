USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_wfm_case', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_wfm_case
GO
CREATE PROCEDURE stage1.p_load_wfm_case
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
	EXEC('EXEC stage1.p_create_wfm_case @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (ACCOUNTABILITY_ID, CASE_ID, CUSTOMER_SITE_ID, DATE_MODIFIED, SELECTED_OFFER_ID)
	SELECT
		gcss.f_unwanted_chars(ACCOUNTABILITY_ID) ACCOUNTABILITY_ID
		, gcss.f_unwanted_chars(CASE_ID) CASE_ID
		, gcss.f_unwanted_chars(CUSTOMER_SITE_ID) CUSTOMER_SITE_ID
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		,  CASE
		    WHEN SELECTED_OFFER_ID = ''""'' THEN 0
		    ELSE CAST(ISNULL(gcss.f_unwanted_chars(SELECTED_OFFER_ID), 0) AS NUMERIC(10, 0))
		  END SELECTED_OFFER_ID
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
