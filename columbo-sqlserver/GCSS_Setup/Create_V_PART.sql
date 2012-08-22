DROP VIEW stage2.v_part
GO

CREATE VIEW stage2.v_part AS
SELECT
	OBJECT_SCHEMA_NAME(p.object_id) obj_schema
	, OBJECT_NAME(p.object_id) obj_name
	, p.index_id
	, p.partition_number
	, p.rows
	, a.type
	, a.filegroup_id
	, fg.name
FROM
	sys.system_internals_allocation_units a
		JOIN sys.partitions p
		ON p.partition_id = a.container_id
		JOIN sys.filegroups fg
		ON a.filegroup_id = fg.data_space_id
GO

select *
from stage2.v_part p
ORDER BY
	p.obj_name
	, p.index_id
	, p.partition_number
go
