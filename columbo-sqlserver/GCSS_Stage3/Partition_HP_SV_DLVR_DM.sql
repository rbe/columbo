/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- HP_SV_DLVR_DM: HP_SV_DLVR_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'HP_SV_DLVR_DM'
	, @column_name = 'HP_SV_DLVR_ID'
	, @partition_name = 'hp_sv_dlvr_dm_by_hp_sv_dlvr_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX hsdd_pk
ON stage2.hp_sv_dlvr_dm (
	hp_sv_dlvr_id ASC
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
ON hp_sv_dlvr_dm_by_hp_sv_dlvr_id_ps (hp_sv_dlvr_id)
GO

--
-- HP_SV_DLVR_DM: case_id
--
CREATE NONCLUSTERED INDEX case_id_ix
ON stage2.hp_sv_dlvr_dm (case_id)
ON stage2datap3fg
GO
