SET IDENTITY_INSERT GROWNSTATE ON
GO
SET DATEFORMAT ymd
GO
--TRUNCATE TABLE GROWNSTATE
--GO
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (1,'table1','2012-02-01 00:00:00',168);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (2,'table2','2012-02-01 00:00:00',168);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (3,'case_end2end','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (4,'employee_table_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (5,'hp_country_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (6,'hp_offer_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (7,'hp_part_order_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (8,'hp_parts_info_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (9,'hp_sv_dlvr_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (10,'onsite_log_dm','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (11,'subcase_end2end','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (12,'wfm_case','2010-01-01 00:00:00',48);
INSERT INTO grownstate (id, table_name, last_download, download_hours) VALUES (13,'wfm_subcase','2010-01-01 00:00:00',48);
