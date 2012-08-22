-- Maximum length of a row
SELECT
	SUM(length)
FROM
	syscolumns
WHERE
	id = OBJECT_ID('stage2.CASE_END2END')
GO

-- syscolumns
SELECT
	*
FROM
	syscolumns
WHERE
	id = OBJECT_ID('stage2.CASE_END2END')
GO

-- Actual length of data
SELECT
	SUM(DATALENGTH(name)) / 1024 / 1024
	, SUM(DATALENGTH(ADDRESS)) / 1024 / 1024
	, SUM(DATALENGTH(ADDRESS2)) / 1024 / 1024
FROM
	stage2.CASE_END2END
GO
