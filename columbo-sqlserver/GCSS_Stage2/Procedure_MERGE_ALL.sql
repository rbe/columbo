USE GCSS
GO

/*
 * Merge all tables in a schema A with schema B depending on information in MERGE_DESC.
 */
IF OBJECT_ID('stage2.p_merge_all', 'P') IS NOT NULL 
    DROP PROCEDURE stage2.p_merge_all
GO
CREATE PROCEDURE stage2.p_merge_all(
	@target_table   NVARCHAR(255)
	, @source_table NVARCHAR(255)
)
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	-- Transaction isolation
	SET TRANSACTION ISOLATION LEVEL SNAPSHOT
	-- Lookup merge description for tables from MERGE_DESC
	DECLARE @d_id INT, @m_id INT
	        , @target_catalog_name NVARCHAR(255)
	        , @target_schema_name NVARCHAR(255)
		    , @target_table_name NVARCHAR(255)
		    , @join_clause NVARCHAR(255)
		    , @matched_and_clause NVARCHAR(255)
		    , @notmatched_and_clause NVARCHAR(255)
	SELECT TOP 1
		@m_id = m.id
		, @target_catalog_name   = m.target_catalog_name
		, @target_schema_name    = m.target_schema_name
		, @target_table_name     = m.target_table_name
		, @join_clause           = m.join_desc
		, @matched_and_clause    = m.matched_and_clause
		, @notmatched_and_clause = m.notmatched_and_clause
	  FROM
		gcss.merge_desc m
	 WHERE
		m.target_table_name = @target_table
	 ORDER BY
		m.id
	WHILE @@ROWCOUNT = 1
	BEGIN
		EXEC stage2.p_merge
			  @source_table_catalog  = 'GCSS'
			, @source_table_schema   = 'stage1'
			, @source_table_name     = @source_table
			, @target_table_catalog  = @target_catalog_name
			, @target_table_schema   = @target_schema_name
			, @target_table_name     = @target_table_name
			, @join_clause           = @join_clause
			, @matched_and_clause    = @matched_and_clause
			, @notmatched_and_clause = @notmatched_and_clause
		-- Lookup next row
		SELECT TOP 1
			@m_id = m.id
			, @target_catalog_name   = m.target_catalog_name
			, @target_schema_name    = m.target_schema_name
			, @target_table_name     = m.target_table_name
			, @join_clause           = m.join_desc
			, @matched_and_clause    = m.matched_and_clause
			, @notmatched_and_clause = m.notmatched_and_clause
		  FROM
			gcss.merge_desc m
		 WHERE
			m.id > @m_id
			AND m.target_table_name = @target_table
		 ORDER BY
			m.id
	END
END
GO
