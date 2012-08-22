USE GCSS
GO

CREATE TABLE gcss.MERGE_DESC (
	id INT IDENTITY(1,1) NOT NULL
	, target_catalog_name NVARCHAR(255) NOT NULL
	, target_schema_name NVARCHAR(255) NOT NULL
	, target_table_name NVARCHAR(255) NOT NULL
	, join_desc NVARCHAR(4000) NOT NULL
	, matched_and_clause NVARCHAR(4000) NULL
	, notmatched_and_clause NVARCHAR(4000) NULL
);
