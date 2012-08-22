USE GCSS
GO

SET ANSI_NULLS ON
SET ANSI_PADDING ON
SET ANSI_WARNINGS ON
SET ARITHABORT ON
SET CONCAT_NULL_YIELDS_NULL ON
SET QUOTED_IDENTIFIER ON
SET NUMERIC_ROUNDABORT OFF
GO

/*
 * Top 250 claims per country, region.
 */
IF OBJECT_ID('stage2.v_claims_3') IS NOT NULL
BEGIN
    DROP VIEW stage2.v_claims_3
END
GO

CREATE VIEW stage2.v_claims_3
WITH SCHEMABINDING
AS
SELECT /*TOP 250*/
    COUNT_BIG(*) "Claims per Country"
    , ce2e.country country
    , country.x_super_region region
    , country.name
FROM
    stage2.case_end2end ce2e
    INNER JOIN stage2.hp_country_dm country ON ce2e.country = country.name
GROUP BY
    ce2e.country
    , country.name
    , country.x_super_region
GO

CREATE UNIQUE CLUSTERED INDEX vc3_idx1
ON stage2.v_claims_3 (country ASC, region ASC, name ASC)
ON stage3_region_ps (region)
GO
