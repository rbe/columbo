/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- SUBCASE_END2END: SUBCASE_ID
--
EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'SUBCASE_END2END'
	, @column_name = 'SUBCASE_ID'
	, @partition_name = 'subcase_end2end_by_subcase_id'
	, @partition_path = 'E:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX se2e_pk
ON stage2.subcase_end2end (
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
ON subcase_end2end_by_subcase_id_ps (subcase_id)
GO

--
-- SUBCASE_END2END: accountability_id
--
CREATE NONCLUSTERED INDEX accountability_id_ix
ON stage2.subcase_end2end (accountability_id)
ON stage2datap1fg
GO

--
-- SUBCASE_END2END: subcase_id
--
CREATE NONCLUSTERED INDEX big_subcase_id_ix
ON stage2.subcase_end2end (subcase_id) INCLUDE (accountability_id, condition_code_value, cr_login_name, cr_work_group, ow_work_group, ow_response_center, cl_login_name)
ON stage2datap2fg
GO
