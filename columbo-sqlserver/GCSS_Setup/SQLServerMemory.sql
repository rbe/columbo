-- 24 GB
/*
EXEC sys.sp_configure N'min server memory (MB)', N'24576'
GO
EXEC sys.sp_configure N'max server memory (MB)', N'24576'
GO
RECONFIGURE WITH OVERRIDE
GO
*/

-- 28 GB
/*
EXEC sys.sp_configure N'min server memory (MB)', N'28672'
GO
EXEC sys.sp_configure N'max server memory (MB)', N'28672'
GO
RECONFIGURE WITH OVERRIDE
GO
*/
