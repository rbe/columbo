/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- HP_PARTS_INFO_DM: PARTS_INFO_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'HP_PARTS_INFO_DM'
	, @column_name = 'PARTS_INFO_ID'
	, @partition_name = 'hp_parts_info_dm_by_hp_parts_info_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX hpid_pk
ON stage2.hp_parts_info_dm (
	accountability_id ASC
	, parts_info_id ASC
	, subcase_tracking_id ASC
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
ON hp_parts_info_dm_by_hp_parts_info_id_ps (parts_info_id)
GO

--
-- HP_PARTS_INFO_DM: subcase_tracking_id
--
CREATE NONCLUSTERED INDEX subcase_tracking_id_ix
ON stage2.hp_parts_info_dm (subcase_tracking_id)
ON stage2datap2fg
GO
