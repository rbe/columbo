USE GCSS
GO

/*
 * Dynamically create a table, drop it before if it exists.
 */
IF OBJECT_ID ('stage1.p_create_table', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_create_table
GO
CREATE PROCEDURE stage1.p_create_table
	@schema_name  NVARCHAR(255)
	, @table_name NVARCHAR(255)
	, @table_def  NVARCHAR(MAX)
AS
BEGIN
	-- Drop table
	IF OBJECT_ID ('stage1.' + @table_name, 'U') IS NOT NULL
	BEGIN 
		EXEC('TRUNCATE TABLE stage1.' + @table_name)
		EXEC('DROP TABLE stage1.' + @table_name)
	END
	-- Create table
	DECLARE @stmt NVARCHAR(MAX)
	SET @stmt = 'CREATE TABLE ' + @schema_name + '.' + @table_name + ' ' + @table_def + ' ON STAGE1DATAFG'
	EXEC(@stmt)
END
GO
