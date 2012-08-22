USE GCSS
GO

/*
 * Load data from CSV-file into table.
 */
IF OBJECT_ID('stage1.p_load_hp_offer_dm', 'P') IS NOT NULL 
    DROP PROCEDURE stage1.p_load_hp_offer_dm
GO
CREATE PROCEDURE stage1.p_load_hp_offer_dm
	@file              NVARCHAR(255)
	, @formatfile      NVARCHAR(255)
	, @temp_table_name NVARCHAR(255)
AS
BEGIN
	-- No row count
	SET NOCOUNT ON
	-- Rollback running transactions automatically in case of failure
	SET XACT_ABORT ON
	-- Transaction isolation
	SET TRANSACTION ISOLATION LEVEL SNAPSHOT
	--
	DECLARE @sql AS NVARCHAR(MAX)
	-- Create temporary table
	EXEC('EXEC stage1.p_create_hp_offer_dm @table_name = ' + @temp_table_name)
	-- Load data
	SET @sql = 'INSERT stage1.' + @temp_table_name + ' (DATE_MODIFIED, END_DATE, OFFER_ID, OFFER_REF_ID, START_DATE)
	SELECT
		CAST(gcss.f_unwanted_chars(DATE_MODIFIED) AS DATETIME2) DATE_MODIFIED
		, CAST(gcss.f_unwanted_chars(END_DATE) AS DATETIME2) END_DATE
		, gcss.f_unwanted_chars(OFFER_ID) OFFER_ID
		, gcss.f_unwanted_chars(OFFER_REF_ID) OFFER_REF_ID
		, CAST(gcss.f_unwanted_chars(START_DATE) AS DATETIME2) START_DATE
	FROM
		OPENROWSET(
			BULK ''' + @file + '''
			, FIRSTROW = 2
			, FORMATFILE = ''' + @formatfile + '''
		) t1'
	EXEC(@sql)
	-- Delete temporary table
	EXEC stage1.p_drop_temp_table @temp_table_name = @temp_table_name
END
GO
