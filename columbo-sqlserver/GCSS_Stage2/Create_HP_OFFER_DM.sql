USE GCSS
GO

CREATE TABLE stage2.HP_OFFER_DM (
	  OFFER_ID NUMERIC(10, 0) NOT NULL 
	, END_DATE DATETIME2
	, OFFER_REF_ID NUMERIC(10, 0) 
	, START_DATE DATETIME2
	, DATE_MODIFIED DATETIME2
) ON stage2_date_ps (DATE_MODIFIED)
GO

CREATE UNIQUE CLUSTERED INDEX HOD_PK
ON stage2.HP_OFFER_DM (OFFER_ID, DATE_MODIFIED)
ON stage2_date_ps (DATE_MODIFIED)
GO
