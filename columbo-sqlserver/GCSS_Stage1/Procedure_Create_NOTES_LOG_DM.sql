USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_notes_log_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_notes_log_dm
GO
CREATE PROCEDURE stage1.p_create_notes_log_dm(
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
		  ACCOUNTABILITY_ID NVARCHAR(90) 
		, CREATE_DATE DATETIME2 NOT NULL 
		, ACTION_TYPE NVARCHAR(120) NOT NULL 
		, EMPLOYEE_ID NUMERIC(38) NOT NULL 
		, CASE_ID NVARCHAR(90) NOT NULL 
		, CASE_SUBCASE NVARCHAR(30) 
		, WORK_GROUP NVARCHAR(240) 
		, INTERNAL NVARCHAR(765) 
		, NOTES NVARCHAR(4000) 
		, NOTES_LOG_ID NUMERIC(10, 0) NOT NULL 
	)'
END
GO
