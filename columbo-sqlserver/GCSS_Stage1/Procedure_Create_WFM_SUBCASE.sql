USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_wfm_subcase', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_wfm_subcase
GO
CREATE PROCEDURE stage1.p_create_wfm_subcase(
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
		  SUBCASE_ID NVARCHAR(90) NOT NULL 
		, SUBCASE_TRACKING_ID NVARCHAR(90) NOT NULL 
		, CASE_ACCOUNTABILITY_ID NVARCHAR(90) 
		, ACTION_TYPE NVARCHAR(90) 
		, OPEN_DATE DATETIME2 
		, DATE_MODIFIED DATETIME2 
		, X_REPAIR_CLASS NVARCHAR(6) 
		, X_OTC NVARCHAR(60) 
		, PARTNER_CO_NAME NVARCHAR(240) 
		, DELIVERY_ALTERNATIVE NVARCHAR(120) 
	)'
END
GO
