/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- ONSITE_LOG_DM: ONSITE_LOG_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'ONSITE_LOG_DM'
	, @column_name = 'ONSITE_LOG_ID'
	, @partition_name = 'onsite_log_dm_by_onsite_log_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX old_pk
ON stage2.onsite_log_dm (
	onsite_log_id ASC
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
ON onsite_log_dm_by_onsite_log_id_ps (onsite_log_id)
GO

--
-- ONSITE_LOG_DM: case_id
--
CREATE NONCLUSTERED INDEX case_id_ix
ON stage2.onsite_log_dm (case_id) INCLUDE (perf_by)
ON stage2datap4fg
GO
