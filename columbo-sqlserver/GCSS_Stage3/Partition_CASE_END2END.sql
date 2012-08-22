/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- CASE_END2END: CASE_ID
--

EXEC dbo.p_create_partition_by_column
	@database = 'GCSS'
	, @table_schema = 'stage2'
	, @table_name = 'CASE_END2END'
	, @column_name = 'CASE_ID'
	, @partition_name = 'case_end2end_by_case_id'
	, @partition_path = 'F:\Data\GCSS'
	, @range_type = 'LEFT'
	, @max_part_row_count = 1000000
GO

CREATE UNIQUE CLUSTERED INDEX ce2e_pk
ON stage2.case_end2end (
	case_id ASC
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
ON case_end2end_by_case_id_ps (case_id)
GO

/*
SELECT COUNT(DISTINCT case_id)
FROM stage2.CASE_END2END
GO
*/

--
-- CR_DATE_CUST
--
-- 11,645,211 rows = 10 sec, with index = 4 sec
--

EXEC dbo.p_create_partition_by_month
	@database = 'GCSS'
	, @partition_name = 'case_end2end_by_cr_date_cust'
	, @partition_path = 'F:\Data\GCSS'
	, @years = '2009,2010,2011,2012'
	, @datatype = 'datetime2'
	, @range_type = 'RIGHT'
	, @initial_mb = 16384
GO

CREATE NONCLUSTERED INDEX cr_date_cust_ix
ON stage2.case_end2end (cr_date_cust) INCLUDE (case_id, country)
ON case_end2end_by_cr_date_cust_ps (cr_date_cust)
GO
/*
SELECT COUNT(DISTINCT case_id)
FROM stage2.CASE_END2END
WHERE cr_date_cust BETWEEN '2009-01-01' AND '2011-01-01'
GO
*/

--
-- V_CLAIMS_9
--
CREATE NONCLUSTERED INDEX caseid_prd_sn_ix
ON stage2.case_end2end (serial_number) include (case_id, product)
ON stage2indexp1fg
GO

--
-- ACCOUNTABILITY_ID
--
-- 20,254,179 rows = 22 sec, with index = 5 sec
--
CREATE NONCLUSTERED INDEX acct_id_ix
ON stage2.case_end2end (accountability_id)
ON stage2indexp2fg
GO
/*
SELECT COUNT(DISTINCT accountability_id)
FROM stage2.CASE_END2END
GO
*/

--
-- NAME
--
-- 3,560,097 rows = 12 sec, with index = 5 sec
--
CREATE NONCLUSTERED INDEX name_ix
ON stage2.case_end2end (name)
ON stage2indexp3fg
GO
/*
SELECT COUNT(DISTINCT name)
FROM stage2.CASE_END2END
GO
*/

--
-- ADDRESS
--
-- Index 1200 Bytes, 900 allowed
/*
CREATE NONCLUSTERED INDEX address_ix
ON stage2.case_end2end (address)
ON stage2indexp1fg
GO
*/
/*
SELECT COUNT(DISTINCT address)
FROM stage2.CASE_END2END
GO
*/

--
-- ZIP_CODE
--
-- 493,030 rows = 3 sec, with index = 0 sec
--
CREATE NONCLUSTERED INDEX zip_code_ix
ON stage2.case_end2end (zip_code)
ON stage2indexp4fg
GO
/*
SELECT COUNT(DISTINCT zip_code)
FROM stage2.CASE_END2END
GO
*/

--
-- CALLER_PHONE
--
-- 8,009,628 rows = 19 sec, with index = 5 sec
--
CREATE NONCLUSTERED INDEX caller_phone_ix
ON stage2.case_end2end (caller_phone)
ON stage2indexp1fg
GO
/*
SELECT COUNT(DISTINCT caller_phone)
FROM stage2.CASE_END2END
GO
*/

--
-- CONTACT_E_MAIL
--
-- 4,532,140 rows = 17 sec, with index = 5 sec
--
CREATE NONCLUSTERED INDEX contact_e_mail_ix
ON stage2.case_end2end (contact_e_mail)
ON stage2indexp2fg
GO
/*
SELECT COUNT(DISTINCT contact_e_mail)
FROM stage2.CASE_END2END
GO
*/

--
-- CONTACT_LASTNAME
--
-- 2,034,640 rows = 5 sec, with index = 0 sec
--
CREATE NONCLUSTERED INDEX contact_last_name_ix
ON stage2.case_end2end (contact_last_name)
ON stage2indexp3fg
GO
/*
SELECT COUNT(DISTINCT contact_last_name)
FROM stage2.CASE_END2END
GO
*/

--
-- SERIAL_NUMBER
--
-- 10,821,197 rows = 18 sec, with index = 5 sec
--
CREATE NONCLUSTERED INDEX serial_number_ix
ON stage2.case_end2end (serial_number)
ON stage2indexp4fg
GO
/*
SELECT COUNT(DISTINCT serial_number)
FROM stage2.CASE_END2END
GO
*/

--
-- PRODUCT
--
-- 141,582 rows = 2 sec, with index = 0 sec
--
CREATE NONCLUSTERED INDEX product_ix
ON stage2.case_end2end (product)
ON stage2indexp1fg
GO
/*
SELECT COUNT(DISTINCT product)
FROM stage2.case_end2end
GO
*/

