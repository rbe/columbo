USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_wfm_case', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_wfm_case
GO
CREATE PROCEDURE stage1.p_create_wfm_case(
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
		  ACCOUNTABILITY_ID   NVARCHAR(90) NOT NULL
		, CASE_ID             NVARCHAR(90) NOT NULL
		, CUSTOMER_SITE_ID    NVARCHAR(240)
		, DATE_MODIFIED       DATETIME2
		, SELECTED_OFFER_ID   NUMERIC(10, 0)
	)'
END
GO
