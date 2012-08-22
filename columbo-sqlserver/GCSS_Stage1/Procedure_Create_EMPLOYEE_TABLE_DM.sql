USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_employee_table_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_employee_table_dm
GO
CREATE PROCEDURE stage1.p_create_employee_table_dm(
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
		  EMPLOYEE_TABLE_ID NUMERIC(38) NOT NULL 
		, EMPLOYEE_ID NVARCHAR(30) 
		, LOCATION NVARCHAR(240) 
		, LOGIN_NAME NVARCHAR(120) 
		, REGION NVARCHAR(90) 
		, RESPONSE_CENTER NVARCHAR(120) 
		, DATE_ADDED DATETIME2
		, DATE_MODIFIED DATETIME2
		, EMPLOYEE_PHONE NVARCHAR(75)
		, EMPLOYEE_EMAIL NVARCHAR(240)
	)'
END
GO
