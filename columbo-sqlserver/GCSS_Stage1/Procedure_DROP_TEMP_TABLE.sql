USE GCSS
GO

/*
 * Drop a table temporary used for imported CSV data.
 */
IF OBJECT_ID ('stage1.p_drop_temp_table', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_drop_temp_table
GO
CREATE PROCEDURE stage1.p_drop_temp_table
	@temp_table_name NVARCHAR(255)
AS
BEGIN
	-- Drop temporary table
	IF OBJECT_ID ('stage1.' + @temp_table_name, 'U') IS NOT NULL
	BEGIN 
		EXEC('TRUNCATE TABLE stage1.' + @temp_table_name)
		EXEC('DROP TABLE stage1.' + @temp_table_name)
	END
END
GO
