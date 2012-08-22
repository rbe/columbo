USE GCSS
GO

CREATE TABLE stage2.NOTES_LOG_DM (
	  ACCOUNTABILITY_ID NVARCHAR(90) 
	, CREATE_DATE DATETIME2 NOT NULL 
	, ACTION_TYPE NVARCHAR(120) NOT NULL 
	, EMPLOYEE_ID NUMERIC(38) NOT NULL 
	, CASE_ID NVARCHAR(90) NOT NULL 
	, CASE_SUBCASE NVARCHAR(30) 
	, WORK_GROUP NVARCHAR(240) 
	, INTERNAL NVARCHAR(765) 
	, NOTES NVARCHAR(4000) 
	, NOTES_LOG_ID NUMERIC(10, 0) NOT NULL 
) ON stage2_date_ps (CREATE_DATE)
GO

CREATE UNIQUE CLUSTERED INDEX NLD_PK
ON stage2.NOTES_LOG_DM (NOTES_LOG_ID, CASE_ID, CREATE_DATE)
ON stage2_date_ps (CREATE_DATE)
GO