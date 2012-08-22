USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_hp_sv_dlvr_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_hp_sv_dlvr_dm
GO
CREATE PROCEDURE stage1.p_load_hp_sv_dlvr_dm
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
	EXEC('EXEC stage1.p_create_hp_sv_dlvr_dm @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (CASE_ID, DATE_MODIFIED, ENGINEER_FIRST_NAME, ENGINEER_LAST_NAME, HP_SV_DLVR_ID, SUBCASE_ID, X_ADDRESS, X_ADDRESS_2, X_CITY, X_CONTACT_EMAIL, X_CONTACT_FIRST_NAME, X_CONTACT_LAST_NAME, X_CONTACT_PHONE, X_ISO_COUNTRY_CODE, X_SERVICE_LOCATION, X_STATE, X_ZIPCODE)
	SELECT
		gcss.f_unwanted_chars(CASE_ID) CASE_ID
		, CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(ENGINEER_FIRST_NAME) ENGINEER_FIRST_NAME
		, gcss.f_unwanted_chars(ENGINEER_LAST_NAME) ENGINEER_LAST_NAME
		, gcss.f_unwanted_chars(HP_SV_DLVR_ID) HP_SV_DLVR_ID
		, gcss.f_unwanted_chars(SUBCASE_ID) SUBCASE_ID
		, gcss.f_unwanted_chars(X_ADDRESS) X_ADDRESS
		, gcss.f_unwanted_chars(X_ADDRESS_2) X_ADDRESS_2
		, gcss.f_unwanted_chars(X_CITY) X_CITY
		, gcss.f_unwanted_chars(X_CONTACT_EMAIL) X_CONTACT_EMAIL
		, gcss.f_unwanted_chars(X_CONTACT_FIRST_NAME) X_CONTACT_FIRST_NAME
		, gcss.f_unwanted_chars(X_CONTACT_LAST_NAME) X_CONTACT_LAST_NAME
		, gcss.f_unwanted_chars(X_CONTACT_PHONE) X_CONTACT_PHONE
		, gcss.f_unwanted_chars(X_ISO_COUNTRY_CODE) X_ISO_COUNTRY_CODE
		, gcss.f_unwanted_chars(X_SERVICE_LOCATION) X_SERVICE_LOCATION
		, gcss.f_unwanted_chars(X_STATE) X_STATE
		, gcss.f_unwanted_chars(X_ZIPCODE) X_ZIPCODE
	FROM
		OPENROWSET(
			BULK ''' + @file + '''
			, FIRSTROW = 2
			, FORMATFILE = ''' + @formatfile + '''
		) t1'
	EXEC(@sql)
END
GO
