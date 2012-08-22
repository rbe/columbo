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
 * Top 250 claims per country.
 */
IF OBJECT_ID('stage2.v_claims_2', 'V') IS NOT NULL
BEGIN
    DROP VIEW stage2.v_claims_2
END
GO

CREATE VIEW stage2.v_claims_2
WITH SCHEMABINDING
AS
SELECT /*TOP 250*/
    COUNT_BIG(*) "Claims per Country"
    , ce2e.country country
FROM
    stage2.case_end2end ce2e
GROUP BY
    ce2e.country
GO

CREATE UNIQUE CLUSTERED INDEX vc2_idx1
ON stage2.v_claims_2 (country ASC)
--ON stage3_region_ps ()
GO
