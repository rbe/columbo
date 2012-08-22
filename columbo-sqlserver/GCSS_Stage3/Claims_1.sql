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
 * Top 10 claims per country, delivery alternative, region.
 * V_CLAIMS_1_TOP10
 */
IF OBJECT_ID('stage2.v_claims_1') IS NOT NULL
BEGIN
    DROP VIEW stage2.v_claims_1
END
GO

CREATE VIEW stage2.v_claims_1
WITH SCHEMABINDING
AS
SELECT
    ce2e.country
    , ce2e.delivery_alternative
    , country.x_super_region
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
    INNER JOIN stage2.hp_country_dm country ON ce2e.country = country.name
WHERE
    ce2e.delivery_alternative <> ''
    AND country.x_super_region <> ''
GROUP BY
    country.x_super_region
    , ce2e.country
    , ce2e.delivery_alternative
GO

CREATE UNIQUE CLUSTERED INDEX vc1_idx1
ON stage2.v_claims_1 (country ASC, x_super_region ASC, delivery_alternative ASC)
ON stage3_region_ps (x_super_region)
GO
