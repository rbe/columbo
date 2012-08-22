SELECT
	t.name
	, c.name
	, CASE
		WHEN t.name = 'datetime2' THEN c.scale
		ELSE c.prec
	  END prec
	, c.length
FROM
	syscolumns c
	LEFT JOIN sys.types t ON c.xusertype = t.user_type_id
WHERE
	id = OBJECT_ID('stage2.CASE_END2END')
GO

select *
from sys.types
order by 
	system_type_id
