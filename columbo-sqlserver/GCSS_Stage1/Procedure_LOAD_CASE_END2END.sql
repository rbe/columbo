USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID ('stage1.p_load_case_end2end', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_case_end2end
GO
CREATE PROCEDURE stage1.p_load_case_end2end
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
	EXEC('EXEC stage1.p_create_case_end2end @table_name = ' + @temp_table_name)
	-- Load data
	-- Ignored columns: CL_LOGIN_NAME, WARR_PROOF_PURCHASE, WARR_CODE, WARR_DESC, WARRANTY_STATUS
	SET @sql = 'INSERT INTO stage1.' + @temp_table_name + ' (ACCOUNTABILITY_ID, ADDRESS, ADDRESS2, CALLER_PHONE, CALL_TYPE, CASE_ID, CASE_TITLE, CITY, CONDITION_CODE_VALUE, CONTACT_E_MAIL, CONTACT_FIRST_NAME, CONTACT_LAST_NAME, COUNTRY, CR_DATE_CUST, CR_LOGIN_NAME, CR_RESPONSE_CENTER, CR_WORK_GROUP, DATE_MODIFIED, DELIVERY_ALTERNATIVE, EMPLOYEE_OWNER, ENTRY_POINT, NAME, OW_LOGIN_NAME, OW_RESPONSE_CENTER, PRODUCT, PRODUCT_DESCRIPTION, PRODUCT_FAMILY, PRODUCT_LINE, SERIAL_NUMBER, SERVICE_NOTE_NUMBER, ZIP_CODE)
	SELECT
		gcss.f_unwanted_chars(t1.ACCOUNTABILITY_ID) ACCOUNTABILITY_ID
		, gcss.f_unwanted_chars(t1.ADDRESS) ADDRESS
		, gcss.f_unwanted_chars(t1.ADDRESS2) ADDRESS2
		, gcss.f_unwanted_chars(t1.CALLER_PHONE) CALLER_PHONE
		, gcss.f_unwanted_chars(t1.CALL_TYPE) CALL_TYPE
		, gcss.f_unwanted_chars(t1.CASE_ID) CASE_ID
		, gcss.f_unwanted_chars(t1.CASE_TITLE) CASE_TITLE
		, gcss.f_unwanted_chars(t1.CITY) CITY
		, gcss.f_unwanted_chars(t1.CONDITION_CODE_VALUE) CONDITION_CODE_VALUE
		, gcss.f_unwanted_chars(t1.CONTACT_E_MAIL) CONTACT_E_MAIL
		, gcss.f_unwanted_chars(t1.CONTACT_FIRST_NAME) CONTACT_FIRST_NAME
		, gcss.f_unwanted_chars(t1.CONTACT_LAST_NAME) CONTACT_LAST_NAME
		, gcss.f_unwanted_chars(t1.COUNTRY) COUNTRY
		, CAST(gcss.f_unwanted_chars(t1.CR_DATE_CUST) AS DATETIME2) CR_DATE_CUST
		, gcss.f_unwanted_chars(t1.CR_LOGIN_NAME) CR_LOGIN_NAME
		, gcss.f_unwanted_chars(t1.CR_RESPONSE_CENTER) CR_RESPONSE_CENTER
		, gcss.f_unwanted_chars(t1.CR_WORK_GROUP) CR_WORK_GROUP
		, CAST(gcss.f_unwanted_chars(t1.DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, gcss.f_unwanted_chars(t1.DELIVERY_ALTERNATIVE) DELIVERY_ALTERNATIVE
		, CAST(gcss.f_unwanted_chars(t1.EMPLOYEE_OWNER) AS NUMERIC(38)) EMPLOYEE_OWNER
		, gcss.f_unwanted_chars(t1.ENTRY_POINT) ENTRY_POINT
		, gcss.f_unwanted_chars(t1.NAME) NAME
		, gcss.f_unwanted_chars(t1.OW_LOGIN_NAME) OW_LOGIN_NAME
		, gcss.f_unwanted_chars(t1.OW_RESPONSE_CENTER) OW_RESPONSE_CENTER
		, gcss.f_unwanted_chars(t1.PRODUCT) PRODUCT
		, gcss.f_unwanted_chars(t1.PRODUCT_DESCRIPTION) PRODUCT_DESCRIPTION
		, gcss.f_unwanted_chars(t1.PRODUCT_FAMILY) PRODUCT_FAMILY
		, gcss.f_unwanted_chars(t1.PRODUCT_LINE) PRODUCT_LINE
		, gcss.f_unwanted_chars(t1.SERIAL_NUMBER) SERIAL_NUMBER
		, gcss.f_unwanted_chars(t1.SERVICE_NOTE_NUMBER) SERVICE_NOTE_NUMBER
		, gcss.f_unwanted_chars(t1.ZIP_CODE) ZIP_CODE
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
