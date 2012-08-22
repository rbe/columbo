/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- HP_PART_ORDER_DM: HP_PART_ORDER_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'HP_PART_ORDER_DM'
	, @column_name = 'HP_PART_ORDER_ID'
	, @partition_name = 'hp_part_order_dm_by_hp_part_order_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX hpod_pk
ON stage2.hp_part_order_dm (
	hp_part_order_id ASC
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
ON hp_part_order_dm_by_hp_part_order_id_ps (hp_part_order_id)
GO

--
-- HP_PART_ORDER_DM: subcase_id
--
CREATE NONCLUSTERED INDEX subcase_id_ix
ON stage2.hp_part_order_dm (subcase_id)
ON stage2datap1fg
GO
