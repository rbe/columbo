/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- WFM_SUBCASE: SUBCASE_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'WFM_SUBCASE'
	, @column_name = 'SUBCASE_ID'
	, @partition_name = 'wfm_subcase_by_subcase_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX ws_pk
ON stage2.wfm_subcase (
	subcase_id ASC
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
ON wfm_subcase_by_subcase_id_ps (subcase_id)
GO

--
-- WFM_SUBCASE: subcase_id
--
CREATE NONCLUSTERED INDEX subcase_id_ix
ON stage2.wfm_subcase (subcase_id)
ON stage2indexp1fg
GO

--
-- WFM_SUBCASE: subcase_id
--
CREATE NONCLUSTERED INDEX big_subcase_id_ix
ON stage2.wfm_subcase (subcase_id) INCLUDE (subcase_tracking_id, case_accountability_id, delivery_alternative)
ON stage2indexp2fg
GO

--
-- WFM_SUBCASE: subcase_tracking_id
--
CREATE NONCLUSTERED INDEX subcase_tracking_id_ix
ON stage2.wfm_subcase (subcase_tracking_id)
ON stage2indexp3fg
GO

--
-- WFM_SUBCASE: case_accountability_id
--
CREATE NONCLUSTERED INDEX case_accountability_id_ix
ON stage2.wfm_subcase (case_accountability_id)
ON stage2indexp4fg
GO
