USE [GCSS]
GO

ALTER DATABASE GCSS ADD FILEGROUP stage2datap1fg;
ALTER DATABASE GCSS ADD FILE (NAME = 'stage2datap1fgf1', FILENAME = 'E:\AOC1\stage2datap1fgf1.ndf') TO FILEGROUP stage2datap1fg;
GO
ALTER DATABASE GCSS ADD FILEGROUP stage2datap2fg;
ALTER DATABASE GCSS ADD FILE (NAME = 'stage2datap2fgf1', FILENAME = 'E:\AOC1\stage2datap2fgf1.ndf') TO FILEGROUP stage2datap2fg;
GO
ALTER DATABASE GCSS ADD FILEGROUP stage2datap3fg;
ALTER DATABASE GCSS ADD FILE (NAME = 'stage2datap3fgf1', FILENAME = 'E:\AOC1\stage2datap31fgf1.ndf') TO FILEGROUP stage2datap3fg;
GO
ALTER DATABASE GCSS ADD FILEGROUP stage2datap4fg;
ALTER DATABASE GCSS ADD FILE (NAME = 'stage2datap4fgf1', FILENAME = 'E:\AOC1\stage2datap4fgf1.ndf') TO FILEGROUP stage2datap4fg;
GO

CREATE PARTITION FUNCTION date_modified_pf (datetime2(7))
AS RANGE LEFT
FOR VALUES (
	/*N'2010-03-01T00:00:00.000', */N'2010-06-01T00:00:00.000', N'2010-09-01T00:00:00.000', N'2010-12-01T00:00:00.000',
	N'2011-03-01T00:00:00.000', N'2011-06-01T00:00:00.000', N'2011-09-01T00:00:00.000', N'2011-12-01T00:00:00.000'
)
GO

CREATE PARTITION SCHEME date_modified_ps
AS PARTITION date_modified_pf
TO (
	stage2datap1fg, stage2datap2fg, stage2datap3fg, stage2datap4fg,
	stage2datap1fg, stage2datap2fg, stage2datap3fg, stage2datap4fg
)
GO

IF OBJECT_ID('parttest', 'U') IS NOT NULL
	DROP TABLE parttest
CREATE TABLE parttest (
	id INTEGER
	, name NVARCHAR(50)
	, birthday DATETIME2
) ON date_modified_ps (birthday)
GO
INSERT INTO parttest VALUES (1, 'Ralf', '2011-09-20');
INSERT INTO parttest VALUES (2, 'Jenny', '2011-10-20');
INSERT INTO parttest VALUES (3, 'Andy', '2011-02-04');
GO

SELECT OBJECT_NAME ([object_id]),partition_number,row_count
FROM sys.dm_db_partition_stats
WHERE object_id = OBJECT_ID('parttest')
GO
