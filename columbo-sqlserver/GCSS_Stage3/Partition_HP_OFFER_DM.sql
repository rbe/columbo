/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- HP_OFFER_DM: OFFER_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'HP_OFFER_DM'
	, @column_name = 'OFFER_ID'
	, @partition_name = 'hp_offer_dm_by_offer_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX hod_pk
ON stage2.hp_offer_dm (
	offer_id ASC
	, date_modified ASC
)
WITH (
	PAD_INDEX  = OFF
	, STATISTICS_NORECOMPUTE  = OFF
	, SORT_IN_TEMPDB = ON
	, IGNORE_DUP_KEY = OFF
	, DROP_EXISTING = ON
	, ONLINE = OFF
	, ALLOW_ROW_LOCKS  = ON
	, ALLOW_PAGE_LOCKS  = ON
)
ON hp_offer_dm_by_offer_id_ps (offer_id)
GO
