/*
 * Create a user, roles and schema for every stage.
 * Execute as 'sa'.
 */

USE GCSS
GO

-- Roles
CREATE ROLE role_gcss;
GO
CREATE ROLE role_stage1;
GO
CREATE ROLE role_stage2;
GO
CREATE ROLE role_stage3;
GO

-- Schema
CREATE SCHEMA gcss AUTHORIZATION role_gcss;
GO
CREATE SCHEMA stage1 AUTHORIZATION role_stage1;
GO
CREATE SCHEMA stage2 AUTHORIZATION role_stage2;
GO
CREATE SCHEMA stage3 AUTHORIZATION role_stage3;
GO
/*
ALTER AUTHORIZATION ON SCHEMA::[gcss] TO [role_gcss]
GO
ALTER AUTHORIZATION ON SCHEMA::[stage2] TO [role_gcss]
GO
ALTER AUTHORIZATION ON SCHEMA::[stage1] TO [role_gcss]
GO
*/

-- Users
CREATE LOGIN gcss WITH PASSWORD = 'gc$ss#2011';
GO
ALTER LOGIN gcss WITH DEFAULT_DATABASE=GCSS, DEFAULT_LANGUAGE=[Deutsch], CHECK_EXPIRATION=OFF, CHECK_POLICY=OFF
GO
CREATE USER gcss FOR LOGIN gcss WITH DEFAULT_SCHEMA = role_gcss;
GO
ALTER USER gcss WITH DEFAULT_SCHEMA=[gcss]
GO

-- Assign users to roles
EXEC sp_addrolemember N'role_gcss', N'gcss';
EXEC sp_addrolemember N'role_stage1', N'gcss';
EXEC sp_addrolemember N'role_stage2', N'gcss';
EXEC sp_addrolemember N'role_stage3', N'gcss';
GO
