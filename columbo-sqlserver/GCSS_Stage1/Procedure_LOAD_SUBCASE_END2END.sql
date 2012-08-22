USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_subcase_end2end', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_subcase_end2end
GO
CREATE PROCEDURE stage1.p_load_subcase_end2end
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
	EXEC('EXEC stage1.p_create_subcase_end2end @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (ACCOUNTABILITY_ID, CL_LOGIN_NAME, CONDITION_CODE_VALUE, CR_DATE_GMT, CR_LOGIN_NAME, CR_WORK_GROUP, DATE_MODIFIED, OW_RESPONSE_CENTER, OW_WORK_GROUP, SUBCASE_ID)
	SELECT
		gcss.f_unwanted_chars(ACCOUNTABILITY_ID) ACCOUNTABILITY_ID
		, gcss.f_unwanted_chars(CL_LOGIN_NAME) CL_LOGIN_NAME
		, gcss.f_unwanted_chars(CONDITION_CODE_VALUE) CONDITION_CODE_VALUE
		, CAST(gcss.f_unwanted_chars(CR_DATE_GMT) AS DATETIME2) CR_DATE_GMT
		, gcss.f_unwanted_chars(CR_LOGIN_NAME) CR_LOGIN_NAME
		, gcss.f_unwanted_chars(CR_WORK_GROUP) CR_WORK_GROUP
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(OW_RESPONSE_CENTER) OW_RESPONSE_CENTER
		, gcss.f_unwanted_chars(OW_WORK_GROUP) OW_WORK_GROUP
		, gcss.f_unwanted_chars(SUBCASE_ID) SUBCASE_ID
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
