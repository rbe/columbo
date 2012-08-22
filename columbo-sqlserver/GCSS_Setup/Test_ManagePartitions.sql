USE GCSS
GO

EXEC p_create_partition_by_month 'GCSS', 'perdate', 'E:\AOC1\Data', '2009,2010,2011,2012', 'datetime2', 'RIGHT', 16384
GO

-- Create 2 partitions, total size 128 MB, RANGE LEFT
EXEC p_create_partition 'GCSS', 'perdate', 'E:\AOC1\Data', 'datetime2', 'LEFT', '2010-01-01,2011-01-01', 2, 128
GO
IF OBJECT_ID('part_test', 'U') IS NOT NULL
	DROP TABLE part_test
GO
CREATE TABLE part_test (id int identity, birthdate datetime2)
ON perdate_ps (birthdate)
GO
INSERT INTO part_test (birthdate) VALUES ('2009-12-20') -- Part 1 => LEFT 2010-01-01
INSERT INTO part_test (birthdate) VALUES ('2010-02-20') -- Part 2 => LEFT 2011-01-01
INSERT INTO part_test (birthdate) VALUES ('2011-03-20') -- Part 3 => PRIMARY
INSERT INTO part_test (birthdate) VALUES ('2011-06-20') -- Part 3 => PRIMARY
GO

--CREATE PARTITION SCHEME [perdate_ps]
--AS PARTITION [perdate_pf]
--TO ([PERDATE_P00], [PERDATE_P01], [PRIMARY])
--GO
--CREATE PARTITION FUNCTION [perdate_pf](datetime2(7))
--AS RANGE LEFT
--FOR VALUES (N'2010-01-01T00:00:00.000', N'2011-01-01T00:00:00.000')
--GO

--
-- Create 2 partitions, total size 128 MB, RANGE LEFT
EXEC p_create_partition 'GCSS', 'perdate', 'E:\AOC1\Data', 'datetime2', 'RIGHT', '2010-01-01,2011-01-01', 2, 128
GO
IF OBJECT_ID('part_test', 'U') IS NOT NULL
	DROP TABLE part_test
GO
CREATE TABLE part_test (id int identity, birthdate datetime2)
ON perdate_ps (birthdate)
GO
INSERT INTO part_test (birthdate) VALUES ('2009-12-20') -- Part 1 => PRIMARY
INSERT INTO part_test (birthdate) VALUES ('2010-02-20') -- Part 2 => RIGHT 2010-01-01, PERDATE_P00
INSERT INTO part_test (birthdate) VALUES ('2011-03-20') -- Part 3 => RIGHT 2011-01-01, PERDATE_P01
INSERT INTO part_test (birthdate) VALUES ('2011-06-20') -- Part 3 => RIGHT 2011-01-01, PERDATE_P01
GO

-- CREATE PARTITION FUNCTION [perdate_pf](datetime2(7))
-- AS RANGE RIGHT
-- FOR VALUES (N'2010-01-01T00:00:00.000', N'2011-01-01T00:00:00.000')
-- GO
-- CREATE PARTITION SCHEME [perdate_ps]
-- AS PARTITION [perdate_pf]
-- TO ([PRIMARY], [PERDATE_P00], [PERDATE_P01])
-- GO

--
-- Example: add a partition
EXEC p_add_partition 'GCSS', 'perdate', 'E:\AOC1\Data', '2012-01-01'
GO
INSERT INTO part_test (birthdate) VALUES ('2012-06-20') -- Part 4 => RIGHT 2012-01-01, PERDATE_P02
GO

--
-- Show size of existing filegroups
SELECT
	g.groupname
	, SUM(f.size * 8 / 1024) size_in_mb
FROM
	sys.sysfilegroups g
	LEFT OUTER JOIN sys.sysfiles f ON g.groupid = f.groupid
GROUP BY
	g.groupname
GO
