/*
 * Load all data into stage 1.
 */

USE GCSS
GO

/*
 * HOLMES:
 *  CSV files: F:\Projekt Columbo\
 *  Format files: X:\Columbo\fmt1
 */

/*
 * Order of loading tables.
 * See https://team.art-of-coding.eu/confluence/display/CDD/Stage+1+und+2+Datenimport+in+das+DWH.
 */

/*
EXEC stage1.p_load_hp_country_dm 'E:\Columbo\GCSS\csv\HP_Country_DM_20110829-1220.csv', 'E:\Columbo\GCSS\fmt1\HP_COUNTRY_DM.fmt', 'my_hp_country_dm'
EXEC stage1.p_load_wfm_case 'E:\Columbo\GCSS\csv\WFM_CASE_20101013-142942.csv', 'E:\Columbo\GCSS\fmt1\WFM_CASE.fmt', 'my_wfm_case'
EXEC stage1.p_load_case_end2end 'E:\Columbo\GCSS\csv\Case_End2End_20101019-095209.csv', 'E:\Columbo\GCSS\fmt1\CASE_END2END.fmt', 'my_case_end2end'
EXEC stage1.p_load_wfm_subcase 'E:\Columbo\GCSS\csv\WFM_Subcase_20101019-095209.csv', 'E:\Columbo\GCSS\fmt1\WFM_SUBCASE.fmt', 'my_wfm_subcase'
EXEC stage1.p_load_subcase_end2end 'E:\Columbo\GCSS\csv\Subcase_End2End_20101201-093001.csv', 'E:\Columbo\GCSS\fmt1\SUBCASE_END2END.fmt', 'my_subcase_end2end'
EXEC stage1.p_load_hp_part_order_dm 'E:\Columbo\GCSS\csv\HP_PART_ORDER_DM_20110426-140530.csv', 'E:\Columbo\GCSS\fmt1\HP_PART_ORDER_DM.fmt', 'my_hp_part_order_dm'
EXEC stage1.p_load_hp_parts_info_dm 'E:\Columbo\GCSS\csv\HP_Parts_Info_DM_20101012-085317.csv', 'E:\Columbo\GCSS\fmt1\HP_PARTS_INFO_DM.fmt', 'my_hp_parts_info_dm'
EXEC stage1.p_load_hp_sv_dlvr_dm 'E:\Columbo\GCSS\csv\HP_SV_DLVR_DM_20101012-085317.csv', 'E:\Columbo\GCSS\fmt1\HP_SV_DLVR_DM.fmt', 'my_hp_sv_dlvr_dm'
EXEC stage1.p_load_onsite_log_dm 'E:\Columbo\GCSS\csv\Onsite_Log_Dm_20101221-113001.csv', 'E:\Columbo\GCSS\fmt1\ONSITE_LOG_DM.fmt', 'my_onsite_log_dm'
--EXEC stage1.p_load_notes_log 'E:\Columbo\GCSS\csv\Onsite_Log_Dm_20101221-113001.csv', 'E:\Columbo\GCSS\fmt1\ONSITE_LOG_DM.fmt', 'my_notes_log_dm'
--EXEC stage1.p_load_phone_log 'E:\Columbo\GCSS\csv\Onsite_Log_Dm_20101221-113001.csv', 'E:\Columbo\GCSS\fmt1\ONSITE_LOG_DM.fmt', 'my_phone_log_dm'

EXEC stage1.p_load_employee_table_dm 'E:\Columbo\GCSS\csv\Employee_Table_DM_20100817-190623.csv', 'E:\Columbo\GCSS\fmt1\EMPLOYEE_TABLE_DM.fmt', 'my_employee_table_dm'
EXEC stage1.p_load_hp_offer_dm 'E:\Columbo\GCSS\csv\HP_Offer_Dm_20100818-093002.csv', 'E:\Columbo\GCSS\fmt1\HP_OFFER_DM.fmt', 'my_hp_offer_dm'
*/