USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_hp_part_order_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_hp_part_order_dm
GO
CREATE PROCEDURE stage1.p_create_hp_part_order_dm(
	@schema_name   NVARCHAR(255) = 'stage1'
	, @table_name  NVARCHAR(255)
)
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	-- Create table
	EXEC stage1.p_create_table @schema_name = @schema_name, @table_name = @table_name, @table_def = ' (
		  HP_PART_ORDER_ID NUMERIC(10, 0) NOT NULL 
		, SUBCASE_ID NVARCHAR(90) NOT NULL 
		, CASE_ID NVARCHAR(90) 
		, X_ORDER_ID NVARCHAR(120) 
		, X_ORDER_NUMBER NVARCHAR(120) 
		, X_SHIP_ADDRESS NVARCHAR(600) 
		, X_SHIP_ADDRESS2 NVARCHAR(600) 
		, X_SHIP_CITY NVARCHAR(90) 
		, X_SHIP_COUNTRY NVARCHAR(120) 
		, X_SHIP_STATE NVARCHAR(120) 
		, X_SHIP_ZIPCODE NVARCHAR(60) 
		, X_COMPANY_NAME NVARCHAR(240) 
		, X_LOGISTICS_SYSTEM NVARCHAR(60) 
		, X_CONTACT_ALT_PHONE NVARCHAR(75) 
		, X_CONTACT_FIRST_NAME NVARCHAR(90) 
		, X_CONTACT_LAST_NAME NVARCHAR(90) 
		, X_CONTACT_PHONE NVARCHAR(75) 
		, DATE_MODIFIED DATETIME2
		, X_SHIP_ISO_COUNTRY_CODE NVARCHAR(6) 
		, X_CONTACT_FAX_NUMBER NVARCHAR(60) 
		, HP_PART_ORDER_REASON NVARCHAR(240) 
	)'
END
GO
