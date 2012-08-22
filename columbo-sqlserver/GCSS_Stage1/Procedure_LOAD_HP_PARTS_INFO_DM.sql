USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_hp_parts_info_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_hp_parts_info_dm
GO
CREATE PROCEDURE stage1.p_load_hp_parts_info_dm
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
	EXEC('EXEC stage1.p_create_hp_parts_info_dm @table_name = ' + @temp_table_name)
	-- Load data
	--, X_SERIAL_NUMBER, X_TRACKING_NUMBER
	--, gcss.f_unwanted_chars(X_SERIAL_NUMBER) X_SERIAL_NUMBER
	--, gcss.f_unwanted_chars(X_TRACKING_NUMBER) X_TRACKING_NUMBER
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (ACCOUNTABILITY_ID, CASE_ID, CURRENCY, DATE_MODIFIED, HP_PART_ORDER_ID, LIST_PRICE, ORDER_NUMBER, PARTS_INFO_ID, PART_DESC, PART_NUMBER, SELECTED_QUANTITY, SOURCE_LOCATION, SUBCASE_TRACKING_ID, X_FAILURE_CD, X_LOGISTICS_LINE_NUMBER, X_PART_STATUS, X_PART_USAGE, X_RETURNABLE_CD)
	SELECT
		gcss.f_unwanted_chars(ACCOUNTABILITY_ID) ACCOUNTABILITY_ID
		, gcss.f_unwanted_chars(CASE_ID) CASE_ID
		, gcss.f_unwanted_chars(CURRENCY) CURRENCY
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, CAST(gcss.f_unwanted_chars(HP_PART_ORDER_ID) AS NUMERIC(10)) HP_PART_ORDER_ID
		, CAST(gcss.f_unwanted_chars(LIST_PRICE) AS NUMERIC(38, 2)) LIST_PRICE
		, gcss.f_unwanted_chars(ORDER_NUMBER) ORDER_NUMBER
		, gcss.f_unwanted_chars(PARTS_INFO_ID) PARTS_INFO_ID
		, gcss.f_unwanted_chars(PART_DESC) PART_DESC
		, gcss.f_unwanted_chars(PART_NUMBER) PART_NUMBER
		, CAST(gcss.f_unwanted_chars(SELECTED_QUANTITY) AS NUMERIC(38)) SELECTED_QUANTITY
		, gcss.f_unwanted_chars(SOURCE_LOCATION) SOURCE_LOCATION
		, gcss.f_unwanted_chars(SUBCASE_TRACKING_ID) SUBCASE_TRACKING_ID
		, gcss.f_unwanted_chars(X_FAILURE_CD) X_FAILURE_CD
		, CAST(gcss.f_unwanted_chars(X_LOGISTICS_LINE_NUMBER) AS NUMERIC(10)) X_LOGISTICS_LINE_NUMBER
		, gcss.f_unwanted_chars(X_PART_STATUS) X_PART_STATUS
		, gcss.f_unwanted_chars(X_PART_USAGE) X_PART_USAGE
		, gcss.f_unwanted_chars(X_RETURNABLE_CD) X_RETURNABLE_CD
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
