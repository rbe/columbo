USE GCSS
GO

/*
 * Create a table.
 */
IF OBJECT_ID('stage1.p_create_hp_country_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_hp_country_dm
GO
CREATE PROCEDURE stage1.p_create_hp_country_dm(
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
		  COUNTRY_ID NUMERIC(10, 0) NOT NULL 
		, COUNTRY_CODE NUMERIC(10, 0) 
		, X_ISO_CODE NVARCHAR(6) 
		, X_SUPER_REGION NVARCHAR(12) 
		, NAME NVARCHAR(120) 
	)'
END
GO
