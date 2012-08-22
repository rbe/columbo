/*
 * Add one temp file per CPU/core.
 *   HOLMES has got 2 Intel Xeon 5680 with 6 cores * 2 threads = 24 virtual CPUs.
 *
 * Execute as 'sa'.
 */

USE tempdb
GO

--ALTER DATABASE tempdb MODIFY FILE ();
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev02', FILENAME = N'E:\tempdb\tempdev02.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev04', FILENAME = N'E:\tempdb\tempdev04.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev06', FILENAME = N'E:\tempdb\tempdev06.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev08', FILENAME = N'E:\tempdb\tempdev08.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev10', FILENAME = N'E:\tempdb\tempdev10.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev12', FILENAME = N'E:\tempdb\tempdev12.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev14', FILENAME = N'E:\tempdb\tempdev14.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev16', FILENAME = N'E:\tempdb\tempdev16.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev18', FILENAME = N'E:\tempdb\tempdev18.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev20', FILENAME = N'E:\tempdb\tempdev20.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev22', FILENAME = N'E:\tempdb\tempdev22.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev24', FILENAME = N'E:\tempdb\tempdev24.ndf', SIZE = 1GB);

ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev03', FILENAME = N'F:\tempdb\tempdev03.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev05', FILENAME = N'F:\tempdb\tempdev05.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev07', FILENAME = N'F:\tempdb\tempdev07.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev09', FILENAME = N'F:\tempdb\tempdev09.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev11', FILENAME = N'F:\tempdb\tempdev11.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev13', FILENAME = N'F:\tempdb\tempdev13.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev15', FILENAME = N'F:\tempdb\tempdev15.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev17', FILENAME = N'F:\tempdb\tempdev17.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev19', FILENAME = N'F:\tempdb\tempdev19.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev21', FILENAME = N'F:\tempdb\tempdev21.ndf', SIZE = 1GB);
ALTER DATABASE tempdb ADD FILE (NAME = N'tempdev23', FILENAME = N'F:\tempdb\tempdev23.ndf', SIZE = 1GB);
