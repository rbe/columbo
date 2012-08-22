USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_hp_offer_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_hp_offer_dm
GO
CREATE PROCEDURE stage1.p_create_hp_offer_dm(
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
		  OFFER_ID NUMERIC(10, 0) NOT NULL 
		, END_DATE DATETIME2
		, OFFER_REF_ID NUMERIC(10, 0) 
		, START_DATE DATETIME2
		, DATE_MODIFIED DATETIME2
	)'
END
GO
