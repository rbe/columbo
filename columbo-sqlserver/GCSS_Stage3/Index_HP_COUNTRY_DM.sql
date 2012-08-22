/*
 * Create partitions for data and indexes.
 *
 */

USE GCSS
GO

--
-- V_BIG
--

CREATE NONCLUSTERED INDEX name_ix
ON stage2.hp_country_dm (name)
ON stage2datap3fg
GO

CREATE NONCLUSTERED INDEX x_super_region_ix
ON stage2.hp_country_dm (x_super_region) INCLUDE (name)
ON stage2datap4fg
GO
