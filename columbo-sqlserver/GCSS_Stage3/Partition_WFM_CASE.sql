/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- WFM_CASE: CASE_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'WFM_CASE'
	, @column_name = 'ACCOUNTABILITY_ID'
	, @partition_name = 'wfm_case_by_accountability_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX wc_pk
ON stage2.wfm_case (
	accountability_id ASC
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
ON wfm_case_by_accountability_id_ps (accountability_id)
GO

--
-- WFM_CASE: case_id
--
CREATE NONCLUSTERED INDEX big_case_id_ix
ON stage2.wfm_case (case_id) INCLUDE (customer_site_id, selected_offer_id)
ON stage2indexp3fg
GO

--
-- WFM_CASE: selected_offer_id
--
CREATE NONCLUSTERED INDEX selected_offer_id_ix
ON stage2.wfm_case (selected_offer_id)
ON stage2indexp4fg
GO
