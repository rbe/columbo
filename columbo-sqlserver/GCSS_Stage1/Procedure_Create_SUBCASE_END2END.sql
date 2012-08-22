USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_subcase_end2end', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_subcase_end2end
GO
CREATE PROCEDURE stage1.p_create_subcase_end2end(
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
		, ACCOUNTABILITY_ID NVARCHAR(90) 
		, CONDITION_CODE_VALUE NVARCHAR(240) 
		, CR_DATE_GMT DATETIME2 
		, CR_LOGIN_NAME NVARCHAR(120) 
		, CR_WORK_GROUP NVARCHAR(240) 
		, OW_WORK_GROUP NVARCHAR(240) 
		, OW_RESPONSE_CENTER NVARCHAR(120) 
		, CL_LOGIN_NAME NVARCHAR(120) 
		, DATE_MODIFIED DATETIME2 
		, DELIVERY_ALTERNATIVE NVARCHAR(120) 
	)'
END
GO
