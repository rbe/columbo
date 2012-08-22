USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_onsite_log_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_onsite_log_dm
GO
CREATE PROCEDURE stage1.p_create_onsite_log_dm(
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
		  ONSITE_LOG_ID NUMERIC(10, 0) NOT NULL 
		, ACCOUNTABILITY_ID NVARCHAR(90) 
		, CASE_ID NVARCHAR(90) 
		, CASE_SUBCASE NVARCHAR(30) 
		, EMPLOYEE_TABLE_ID NUMERIC(10, 0) NOT NULL 
		, DATE_MODIFIED DATETIME2
		, NOTES NVARCHAR(4000) 
		, PERF_BY NVARCHAR(90) 
	)'
END
GO
