/*
 * Define rights.
 * Execute as 'sa'.
 */

--
-- Database-specific rights
--

USE GCSS
GO

-- Objects
GRANT create table TO gcss
GO
GRANT create function TO gcss
GO
GRANT create procedure TO gcss
GO
GRANT create synonym TO gcss
GO
GRANT alter any dataspace TO gcss
GO

--
-- Server rights
--

USE master
GO

-- BULK operations
GRANT administer bulk operations TO gcss
GO
