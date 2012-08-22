USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_hp_parts_info_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_hp_parts_info_dm
GO
CREATE PROCEDURE stage1.p_create_hp_parts_info_dm(
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
		  ACCOUNTABILITY_ID NVARCHAR(90) NOT NULL 
		, SUBCASE_TRACKING_ID NVARCHAR(90) NOT NULL 
		, PARTS_INFO_ID NUMERIC(38) NOT NULL 
		, ORDER_NUMBER NVARCHAR(48) 
		, SELECTED_QUANTITY NUMERIC(38) 
		, PART_NUMBER NVARCHAR(120) 
		, PART_DESC NVARCHAR(480) 
		, CURRENCY NVARCHAR(30) 
		, LIST_PRICE NUMERIC(38, 2) 
		, SOURCE_LOCATION NVARCHAR(120) 
		, DATE_MODIFIED DATETIME2 NOT NULL 
		, X_FAILURE_CD NVARCHAR(12) 
		, X_SERIAL_NUMBER NVARCHAR(90)
		, X_PART_STATUS NVARCHAR(60) 
		, X_PART_USAGE NVARCHAR(54) 
		, X_TRACKING_NUMBER NVARCHAR(120) 
		, X_LOGISTICS_LINE_NUMBER NUMERIC(10, 0) 
		, CASE_ID NVARCHAR(90) 
		, HP_PART_ORDER_ID NUMERIC(10, 0) 
		, X_RETURNABLE_CD NVARCHAR(3) 
	)'
END
GO
