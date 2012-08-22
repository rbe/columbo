SELECT 
    ce2e.case_id [Case Id],
    ce2e.call_type [Call Type],
    ce2e.name [Customer Company],
    ce2e.address [Address],
    ce2e.address2 [Address2],
    ce2e.city [City],
    ce2e.country [Country],
    ce2e.caller_phone [Customer Phone Number],
    ce2e.contact_e_mail [Contact E Mail],
    ce2e.product_family [Product Family],
    ce2e.product [Product],
    ce2e.product_description [Product Description],
    ce2e.product_line [Product Line],
    ce2e.serial_number [Serial Number],
    ce2e.cr_date_cust [Cr Date Cust],
    ce2e.cr_login_name [Main Case Cr Login Name],
    ce2e.cr_work_group [Main Case Cr Work Group],
    ce2e.delivery_alternative [Case Delivery Alternative],
    ce2e.contact_first_name [Contact First Name],
    ce2e.contact_last_name [Contact Last Name],
    ce2e.cr_response_center [Main Case Cr Response Center],
    ce2e.ow_login_name [Main Case Owner Login Name],
    ce2e.ow_response_center [Main Case Owner Response Center],
    ce2e.service_note_number [Service Note Number],
    ce2e.case_title [Case Title],
    ce2e.condition_code_value [Condition Code Value],
    ce2e.entry_point [ENTRY_POINT],
    ce2e.zip_code [Zip Code],
    partorder.x_ship_address [X Ship Address],
    partorder.x_ship_address2 [X Ship Address2],
    partorder.x_ship_city [X Ship City],
    partorder.x_ship_country [X Ship Country],
    partorder.x_ship_zipcode [X Ship Zipcode],
    partorder.x_company_name [X Company Name],
    partorder.x_logistics_system [X Logistics System],
    partorder.x_contact_alt_phone [X Contact Alt Phone],
    partorder.x_contact_first_name [X Contact First Name],
    partorder.x_contact_last_name [X Contact Last Name],
    partorder.x_contact_phone [X Contact Phone],
    partorder.x_ship_iso_country_code [X Iso Country Code],
    partorder.x_contact_fax_number [X Contact Fax Number],
    partorder.hp_part_order_reason [HP_PART_ORDER_REASON],
    partsinfo.order_number [Logistics Order Number],
    partsinfo.selected_quantity [Selected Quantity],
    partsinfo.part_number [Part Number],
    partsinfo.part_desc [Part Desc],
    partsinfo.currency [Currency],
    partsinfo.list_price [Listprice],
    partsinfo.source_location [Source Location],
    partsinfo.x_failure_cd [X Failure Cd],
    partsinfo.x_part_status [X Part Status],
    partsinfo.x_part_usage [X Part Usage],
    partsinfo.x_logistics_line_number [X Logistics Line Number],
    partsinfo.x_returnable_cd [Returnable Code],
    svdlvr.x_service_location [Service Company],
    svdlvr.x_address [X Address],
    svdlvr.x_address_2 [X Address 2],
    svdlvr.x_city [X City],
    svdlvr.x_zipcode [X Zipcode],
    onsite.perf_by [Technician Name],
    sce2e.condition_code_value [Subcase Condition Code Value],
    sce2e.cr_login_name [Subcase CR_LOGIN_NAME],
    sce2e.cr_work_group [Subcase CR Workgroup],
    sce2e.ow_work_group [Subcase Owner Workgroup],
    sce2e.ow_response_center [Subcase OW_RESPONSE_CENTER],
    sce2e.cl_login_name [Subcase CL Login Name],
    wc.customer_site_id [CUSTOMER_SITE_ID],
    wsc.delivery_alternative [Subcase Delivery Alternative]
FROM
	stage2.case_end2end ce2e
	LEFT JOIN stage2.hp_country_dm country       ON country.name = ce2e.country
	LEFT JOIN stage2.wfm_case wc                 ON ce2e.case_id = wc.case_id
	LEFT JOIN stage2.subcase_end2end sce2e       ON ce2e.accountability_id = sce2e.accountability_id
	LEFT JOIN stage2.wfm_subcase wsc             ON sce2e.subcase_id = wsc.subcase_id
    LEFT JOIN stage2.hp_parts_info_dm partsinfo  ON wsc.subcase_tracking_id = partsinfo.subcase_tracking_id
    LEFT JOIN stage2.onsite_log_dm onsite        ON sce2e.subcase_id = onsite.case_id
	LEFT JOIN stage2.hp_sv_dlvr_dm svdlvr        ON ce2e.case_id = svdlvr.case_id
    LEFT JOIN stage2.hp_offer_dm offer           ON wc.selected_offer_id = offer.offer_id
    LEFT JOIN stage2.hp_part_order_dm partorder  ON partsinfo.hp_part_order_id = partorder.hp_part_order_id
WHERE
	ce2e.CASE_ID >= '4600000002' AND ce2e.CASE_ID <= '4618000002'
--	x_super_region = 'AM'
--	AND CR_DATE_CUST between '2010-01-01' AND '2010-02-01'
GO
