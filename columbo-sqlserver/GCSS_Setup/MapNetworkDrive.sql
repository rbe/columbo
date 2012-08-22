/*
 * Allow mapping a network drive.
 * Execute as 'sa'
 */
EXEC sp_configure 'advanced options', 1
GO
RECONFIGURE
GO
EXEC sp_configure 'xp_cmdshell', 1
GO
RECONFIGURE
GO
EXEC xp_cmdshell 'net use G: \\psf\Home'
GO
