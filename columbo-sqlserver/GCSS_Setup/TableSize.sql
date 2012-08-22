USE GCSS
GO

/*
 * Show size of tables.
 */
IF OBJECT_ID('dbo.v_space_used', 'V') IS NOT NULL
	DROP VIEW dbo.v_space_used
GO
CREATE VIEW dbo.v_space_used
AS
SELECT
	SUM(used_page_count) * 8 size_kb
	, SUM(used_page_count) * 8 / 1024 size_mb
	, SUM(row_count) row_count
	, OBJECT_NAME(object_id) table_name
FROM
	sys.dm_db_partition_stats
WHERE
	index_id = 0 OR index_id = 1
GROUP BY
	object_id
GO

/*
 * Get size of a table in megabytes.
 */
IF OBJECT_ID('dbo.f_table_size', 'FN') IS NOT NULL
	DROP FUNCTION dbo.f_table_size
GO
CREATE FUNCTION dbo.f_table_size(
	@table_name NVARCHAR(255)
)
RETURNS INTEGER
AS
BEGIN
	DECLARE @size_mb INTEGER
	SELECT @size_mb = size_mb FROM v_space_used WHERE table_name = @table_name
	RETURN @size_mb
END
GO

/*
declare @s integer
set @s = dbo.f_table_size('CASE_END2END')
print cast(@s as nvarchar)
*/
