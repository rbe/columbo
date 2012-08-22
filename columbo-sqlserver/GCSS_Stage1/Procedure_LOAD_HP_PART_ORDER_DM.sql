USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_hp_part_order_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_hp_part_order_dm
GO
CREATE PROCEDURE stage1.p_load_hp_part_order_dm
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
	EXEC('EXEC stage1.p_create_hp_part_order_dm @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (CASE_ID, DATE_MODIFIED, HP_PART_ORDER_ID, HP_PART_ORDER_REASON, SUBCASE_ID, X_COMPANY_NAME, X_CONTACT_ALT_PHONE, X_CONTACT_FAX_NUMBER, X_CONTACT_FIRST_NAME, X_CONTACT_LAST_NAME, X_CONTACT_PHONE, X_LOGISTICS_SYSTEM, X_ORDER_ID, X_ORDER_NUMBER, X_SHIP_ADDRESS, X_SHIP_ADDRESS2, X_SHIP_CITY, X_SHIP_COUNTRY, X_SHIP_ISO_COUNTRY_CODE, X_SHIP_STATE, X_SHIP_ZIPCODE)
	SELECT
		gcss.f_unwanted_chars(CASE_ID) CASE_ID
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, CAST(gcss.f_unwanted_chars(HP_PART_ORDER_ID) AS NUMERIC(10, 0)) HP_PART_ORDER_ID
		, gcss.f_unwanted_chars(HP_PART_ORDER_REASON) HP_PART_ORDER_REASON
		, gcss.f_unwanted_chars(SUBCASE_ID) SUBCASE_ID
		, gcss.f_unwanted_chars(X_COMPANY_NAME) X_COMPANY_NAME
		, gcss.f_unwanted_chars(X_CONTACT_ALT_PHONE) X_CONTACT_ALT_PHONE
		, gcss.f_unwanted_chars(X_CONTACT_FAX_NUMBER) X_CONTACT_FAX_NUMBER
		, gcss.f_unwanted_chars(X_CONTACT_FIRST_NAME) X_CONTACT_FIRST_NAME
		, gcss.f_unwanted_chars(X_CONTACT_LAST_NAME) X_CONTACT_LAST_NAME
		, gcss.f_unwanted_chars(X_CONTACT_PHONE) X_CONTACT_PHONE
		, gcss.f_unwanted_chars(X_LOGISTICS_SYSTEM) X_LOGISTICS_SYSTEM
		, gcss.f_unwanted_chars(X_ORDER_ID) X_ORDER_ID
		, gcss.f_unwanted_chars(X_ORDER_NUMBER) X_ORDER_NUMBER
		, gcss.f_unwanted_chars(X_SHIP_ADDRESS) X_SHIP_ADDRESS
		, gcss.f_unwanted_chars(X_SHIP_ADDRESS2) X_SHIP_ADDRESS2
		, gcss.f_unwanted_chars(X_SHIP_CITY) X_SHIP_CITY
		, gcss.f_unwanted_chars(X_SHIP_COUNTRY) X_SHIP_COUNTRY
		, gcss.f_unwanted_chars(X_SHIP_ISO_COUNTRY_CODE) X_SHIP_ISO_COUNTRY_CODE
		, gcss.f_unwanted_chars(X_SHIP_STATE) X_SHIP_STATE
		, gcss.f_unwanted_chars(X_SHIP_ZIPCODE) X_SHIP_ZIPCODE
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
