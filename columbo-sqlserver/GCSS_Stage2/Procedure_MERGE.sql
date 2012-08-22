USE GCSS
GO

/*
 * Merge tables, also known as 'upsert'.
 * Within _clause variable use 's.' as reference to source table (stage 1)
 * and 't.' as reference to target table (stage 2).
 */
IF OBJECT_ID('stage2.p_merge', 'P') IS NOT NULL 
    DROP PROCEDURE stage2.p_merge
GO
CREATE PROCEDURE stage2.p_merge(
	@source_table_catalog    NVARCHAR(255)
	, @source_table_schema   NVARCHAR(255)
	, @source_table_name     NVARCHAR(255)
	, @target_table_catalog  NVARCHAR(255)
	, @target_table_schema   NVARCHAR(255)
	, @target_table_name     NVARCHAR(255)
	, @join_clause           NVARCHAR(MAX)
	, @matched_and_clause    NVARCHAR(MAX)
	, @notmatched_and_clause NVARCHAR(MAX)
)
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	-- Transaction isolation
	SET TRANSACTION ISOLATION LEVEL SNAPSHOT
	--
	DECLARE @id INT
			, @table_name NVARCHAR(255)
			, @column_name NVARCHAR(255)
	        , @matched_clause NVARCHAR(MAX)
	        , @notmatched_insert_clause NVARCHAR(MAX)
	        , @notmatched_values_clause NVARCHAR(MAX)
	        , @stmt NVARCHAR(MAX)
	SET @matched_clause = ''
	SET @notmatched_insert_clause = ''
	SET @notmatched_values_clause = ''
	SET @stmt = ''
	-- Lookup columns from source and target tables
	IF OBJECT_ID('tempdb..#p_merge_desc') IS NOT NULL
		DROP TABLE #p_merge_desc
	SELECT
		IDENTITY(int, 1, 1) id
		, t.table_catalog
		, t.table_schema
		, t.table_name
		, c.column_name
	  INTO #p_merge_desc
	  FROM
		information_schema.tables t
		INNER JOIN information_schema.columns c
			ON t.table_name = c.table_name
			AND t.table_catalog = c.table_catalog
			AND t.table_schema = c.table_schema
     WHERE
     	(
			t.table_catalog = @source_table_catalog
			AND t.table_schema = @source_table_schema
			AND t.table_name = @source_table_name
		)
		OR (
			t.table_catalog = @target_table_catalog
			AND t.table_schema = @target_table_schema
			AND t.table_name = @target_table_name
		)
	--
    -- Generate MERGE WHEN MATCHED, UPDATE/WHEN NOT MATCHED, INSERT clauses
    --
    -- Query first row from table metadata
    SELECT TOP 1
		@id = d1.id
		, @table_name = d1.table_name
		, @column_name = d1.column_name
	  FROM
		#p_merge_desc d1
		INNER JOIN #p_merge_desc d2
			ON d1.table_catalog = d2.table_catalog
			AND d1.table_schema = d2.table_schema
			AND d1.table_name = d2.table_name
			AND d1.column_name = d2.column_name
     WHERE
			d1.table_catalog = @target_table_catalog
			AND d1.table_schema = @target_table_schema
			AND d1.table_name = @target_table_name
	 ORDER BY d1.id
	WHILE @@ROWCOUNT = 1
	BEGIN
	    -- Generate WHEN MATCHED/UPDATE clause
	    -- Remove first ',' when adding this to whole statement
	    SET @matched_clause = @matched_clause + ', t.' + @column_name + ' = s.' + @column_name
		-- Generate NOT WHEN MATCHED/INSERT clause
		SET @notmatched_insert_clause = @notmatched_insert_clause + ', ' + @column_name
		SET @notmatched_values_clause = @notmatched_values_clause + ', s.' + @column_name
		-- Query next row from table metadata
		SELECT TOP 1
			@id = d1.id
			, @table_name = d1.table_name
			, @column_name = d1.column_name
		  FROM
			#p_merge_desc d1
			INNER JOIN #p_merge_desc d2
				ON d1.table_catalog = d2.table_catalog
				AND d1.table_schema = d2.table_schema
				AND d1.table_name = d2.table_name
				AND d1.column_name = d2.column_name
		 WHERE
			d1.table_name = @target_table_name
			AND d1.id > @id
		 ORDER BY d1.id
	END
	-- Generate whole statement
	SET @stmt = N'
MERGE INTO ' + @target_table_catalog + '.' + @target_table_schema + '.' + @target_table_name + ' AS t
USING ' + @source_table_catalog + '.' + @source_table_schema + '.' + @source_table_name + ' AS s
   ON ' + @join_clause + '
 WHEN MATCHED ' + ISNULL(@matched_and_clause, '') + '
      THEN UPDATE SET ' + SUBSTRING(@matched_clause, 3, LEN(@matched_clause)) + '
 WHEN NOT MATCHED BY TARGET ' + ISNULL(@notmatched_and_clause, '') + '
      THEN INSERT (' + SUBSTRING(@notmatched_insert_clause, 3, LEN(@notmatched_insert_clause)) + '
      ) VALUES (' + SUBSTRING(@notmatched_values_clause, 3, LEN(@notmatched_values_clause)) + ');'
	-- Execute dynamic SQL statement
	IF @stmt IS NOT NULL
		EXEC sp_executesql @stmt
	ELSE
		RAISERROR(N'Cannot merge, stmt is NULL', 10, 1)
	-- Cleanup 
	DROP TABLE #p_merge_desc
END
GO

/*
EXEC stage2.p_merge
	@source_table_catalog    = 'GCSS'
	, @source_table_schema   = 'stage1'
	, @source_table_name     = 'CASE_END2END'
	, @target_table_catalog  = 'GCSS'
	, @target_table_schema   = 'stage2'
	, @target_table_name     = 'CASE_END2END'
	, @join_clause           = 't.CASE_ID = s.CASE_ID'
	, @matched_and_clause    = 'AND (s.CASE_ID LIKE ''4%'')'
	, @notmatched_and_clause = 'AND (s.CASE_ID LIKE ''4%'')'

MERGE INTO stage2.CASE_END2END AS t
USING stage1.CASE_END2END AS s
   ON t.CASE_ID = s.CASE_ID
 WHEN MATCHED
      AND (s.CASE_ID LIKE '4%') THEN
	  UPDATE SET
            t.ACCOUNTABILITY_ID    = s.ACCOUNTABILITY_ID
          , t.CALL_TYPE            = s.CALL_TYPE
          , t.CASE_TITLE           = s.CASE_TITLE
          , t.CONDITION_CODE_VALUE = s.CONDITION_CODE_VALUE
          , t.CONTRACT_ID          = s.CONTRACT_ID
          , t.NAME                 = s.NAME
          , t.ADDRESS              = s.ADDRESS
          , t.ADDRESS2             = s.ADDRESS2
          , t.ZIP_CODE             = s.ZIP_CODE
          , t.CITY                 = s.CITY
          , t.COUNTRY              = s.COUNTRY
          , t.CONTACT_FIRST_NAME   = s.CONTACT_FIRST_NAME
          , t.CONTACT_LAST_NAME    = s.CONTACT_LAST_NAME
          , t.CALLER_PHONE         = s.CALLER_PHONE
          , t.CONTACT_E_MAIL       = s.CONTACT_E_MAIL
          , t.PRODUCT_FAMILY       = s.PRODUCT_FAMILY
          , t.PRODUCT              = s.PRODUCT
          , t.PRODUCT_DESCRIPTION  = s.PRODUCT_DESCRIPTION
          , t.PRODUCT_LINE         = s.PRODUCT_LINE
          , t.SERIAL_NUMBER        = s.SERIAL_NUMBER
          , t.SERVICE_NOTE_NUMBER  = s.SERVICE_NOTE_NUMBER
          , t.WARR_PROOF_PURCHASE  = s.WARR_PROOF_PURCHASE
          , t.WARR_CODE            = s.WARR_CODE
          , t.WARR_DESC            = s.WARR_DESC
          , t.WARR_RESP            = s.WARR_RESP
          , t.CR_DATE_GMT          = s.CR_DATE_GMT
          , t.CR_DATE_CUST         = s.CR_DATE_CUST
          , t.CR_LOGIN_NAME        = s.CR_LOGIN_NAME
          , t.CR_WORK_GROUP        = s.CR_WORK_GROUP
          , t.CR_RESPONSE_CENTER   = s.CR_RESPONSE_CENTER
          , t.OW_LOGIN_NAME        = s.OW_LOGIN_NAME
          , t.OW_RESPONSE_CENTER   = s.OW_RESPONSE_CENTER
          , t.WARRANTY_STATUS      = s.WARRANTY_STATUS
          , t.DATE_MODIFIED        = s.DATE_MODIFIED
          , t.EMPLOYEE_OWNER       = s.EMPLOYEE_OWNER
          , t.ENTRY_POINT          = s.ENTRY_POINT
          , t.DELIVERY_ALTERNATIVE = s.DELIVERY_ALTERNATIVE
 WHEN NOT MATCHED BY TARGET
      AND (s.CASE_ID LIKE '4%') THEN
      INSERT (  CASE_ID,  ACCOUNTABILITY_ID,    CALL_TYPE,   CASE_TITLE,   CONDITION_CODE_VALUE,   CONTRACT_ID,   NAME,   ADDRESS,   ADDRESS2,   ZIP_CODE,   CITY,   COUNTRY,   CONTACT_FIRST_NAME,   CONTACT_LAST_NAME,   CALLER_PHONE,   CONTACT_E_MAIL,   PRODUCT_FAMILY,   PRODUCT,   PRODUCT_DESCRIPTION,   PRODUCT_LINE,   SERIAL_NUMBER,   SERVICE_NOTE_NUMBER,   WARR_PROOF_PURCHASE,   WARR_CODE,   WARR_DESC,   WARR_RESP,   CR_DATE_GMT,   CR_DATE_CUST,   CR_LOGIN_NAME,   CR_WORK_GROUP,   CR_RESPONSE_CENTER,   OW_LOGIN_NAME,   OW_RESPONSE_CENTER,   WARRANTY_STATUS,   DATE_MODIFIED,   EMPLOYEE_OWNER,   ENTRY_POINT,   DELIVERY_ALTERNATIVE)
      VALUES (s.CASE_ID, s.ACCOUNTABILITY_ID, s.CALL_TYPE, s.CASE_TITLE, s.CONDITION_CODE_VALUE, s.CONTRACT_ID, s.NAME, s.ADDRESS, s.ADDRESS2, s.ZIP_CODE, s.CITY, s.COUNTRY, s.CONTACT_FIRST_NAME, s.CONTACT_LAST_NAME, s.CALLER_PHONE, s.CONTACT_E_MAIL, s.PRODUCT_FAMILY, s.PRODUCT, s.PRODUCT_DESCRIPTION, s.PRODUCT_LINE, s.SERIAL_NUMBER, s.SERVICE_NOTE_NUMBER, s.WARR_PROOF_PURCHASE, s.WARR_CODE, s.WARR_DESC, s.WARR_RESP, s.CR_DATE_GMT, s.CR_DATE_CUST, s.CR_LOGIN_NAME, s.CR_WORK_GROUP, s.CR_RESPONSE_CENTER, s.OW_LOGIN_NAME, s.OW_RESPONSE_CENTER, s.WARRANTY_STATUS, s.DATE_MODIFIED, s.EMPLOYEE_OWNER, s.ENTRY_POINT, s.DELIVERY_ALTERNATIVE)
;
*/