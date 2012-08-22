IF OBJECT_ID('stage2.v_claims_4', 'V') IS NOT NULL
	DROP VIEW stage2.v_claims_4
GO
CREATE VIEW stage2.v_claims_4
WITH SCHEMABINDING
AS
SELECT
    ce2e.country
    , ce2e.name
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
WHERE
    ce2e.name <> ''
GROUP BY
    ce2e.country
    , ce2e.name
GO
CREATE UNIQUE CLUSTERED INDEX v_claims_4_ix1
ON stage2.v_claims_4 (country ASC, name ASC)
ON stage2datap1fg
GO
/*
select *
from stage2.v_claims_4
where country = 'Germany'
*/

IF OBJECT_ID('stage2.v_claims_5', 'V') IS NOT NULL
	DROP VIEW stage2.v_claims_5
GO
CREATE VIEW stage2.v_claims_5
WITH SCHEMABINDING
AS
SELECT
    ce2e.country
    , ce2e.delivery_alternative
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
WHERE
    ce2e.delivery_alternative <> ''
    AND ce2e.country <> ''
GROUP BY
      ce2e.country
    , ce2e.delivery_alternative
GO
/*
select *
from stage2.v_claims_5
where country = 'Germany'
*/

IF OBJECT_ID('stage2.v_claims_6', 'V') IS NOT NULL
	DROP VIEW stage2.v_claims_6
GO
CREATE VIEW stage2.v_claims_6
WITH SCHEMABINDING
AS
SELECT
    ce2e.serial_number
    , ce2e.country
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
    
WHERE
    ce2e.serial_number <> ''
    AND ce2e.country <> ''
GROUP BY
      ce2e.country
    , ce2e.serial_number
GO
/*
select *
from stage2.v_claims_6
where country = 'Germany'
*/

IF OBJECT_ID('stage2.v_claims_7', 'V') IS NOT NULL
	DROP VIEW stage2.v_claims_7
GO
CREATE VIEW stage2.v_claims_7
WITH SCHEMABINDING
AS
SELECT
    ce2e.serial_number
    , ce2e.name
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
WHERE
    ce2e.serial_number <> ''
    AND ce2e.name <> ''
GROUP BY
      ce2e.serial_number
    , ce2e.name
GO
/*
select *
from stage2.v_claims_7
where name LIKE 'Hewlett%'
*/

IF OBJECT_ID('stage2.v_claims_8', 'V') IS NOT NULL
	DROP VIEW stage2.v_claims_8
GO
CREATE VIEW stage2.v_claims_8
WITH SCHEMABINDING
AS
SELECT
    ce2e.product
    , ce2e.country
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce2e
WHERE
    ce2e.product <> ''
    AND ce2e.country <> ''
GROUP BY
      ce2e.product
    , ce2e.country
GO
/*
select *
from stage2.v_claims_8
where country = 'USA'
order by product
*/

DROP VIEW stage2.v_claims_9
GO
CREATE VIEW stage2.v_claims_9
WITH SCHEMABINDING
AS
SELECT 
	ce1.case_id
    , ce1.product
    , ce1.serial_number
    , ce2.product product2
    , ce2.serial_number serial_number2
    , COUNT_BIG(*) amount
FROM
    stage2.case_end2end ce1
	INNER JOIN stage2.case_end2end ce2 on ce1.serial_number = ce2.serial_number
WHERE
    ce1.product <> ''
    AND ce1.serial_number <> ''
    AND ce1.product <> ce2.product
GROUP BY
	ce1.case_id
    , ce1.product
    , ce1.serial_number
    , ce2.product
    , ce2.serial_number
GO


/*
select case_id,product,serial_number
from stage2.CASE_END2END
where serial_number = 'SGH7184DYF'

select *
from (
		select * from stage2.v_claims_9
		where serial_number LIKE 'SG%'
     ) x
where product='AG637A' or product2='AG637A'
*/
