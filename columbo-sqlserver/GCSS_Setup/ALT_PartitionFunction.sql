USE GCSS
GO

/*
 * Create partition function for data in stage 2.
 */
SET DATEFORMAT ymd;

CREATE PARTITION FUNCTION stage2_date_pf (datetime2)
AS RANGE LEFT
FOR VALUES (
	/*'2009-03-01',*/ '2009-06-01', '2009-09-01', '2009-12-01',
      '2010-03-01',   '2010-06-01', '2010-09-01', '2010-12-01', 
      '2011-03-01',   '2011-06-01', '2011-09-01', '2011-12-01'
);
GO

/*
 * Create partition scheme for data in stage 2.
 */
CREATE PARTITION SCHEME stage2_date_ps
AS PARTITION stage2_date_pf
TO (
	stage2datap1fg, stage2datap2fg, stage2datap3fg, stage2datap4fg,
	stage2datap1fg, stage2datap2fg, stage2datap3fg, stage2datap4fg,
	stage2datap1fg, stage2datap2fg, stage2datap3fg, stage2datap4fg
);
GO


/*
 * Create partition function for data in stage 3 by region.
 */
CREATE PARTITION FUNCTION stage3_region_pf (nvarchar(12))
AS RANGE LEFT
FOR VALUES (
	/*'AM',*/ 'AP', 'EMEA'
);
GO

/*
 * Create partition scheme for data in stage 3 by region.
 */
CREATE PARTITION SCHEME stage3_region_ps
AS PARTITION stage3_region_pf
TO (
	stage3reg1fg, stage3reg2fg, stage3reg3fg
);
GO


/*
 * Create partition function for data in stage 3 by month.
 */
SET DATEFORMAT ymd;

CREATE PARTITION FUNCTION stage3_date_pf (datetime2)
AS RANGE LEFT
FOR VALUES (
	/*'2009-03-01',*/ '2009-02-01', '2009-03-01', '2009-04-01', '2009-05-01', '2009-06-01', '2009-07-01', '2009-08-01', '2009-09-01', '2009-10-01', '2009-11-01', '2009-12-01',
	  '2010-01-01',   '2010-02-01', '2010-03-01', '2010-04-01', '2010-05-01', '2010-06-01', '2010-07-01', '2010-08-01', '2010-09-01', '2010-10-01', '2010-11-01', '2010-12-01',
	  '2011-01-01',   '2011-02-01', '2011-03-01', '2011-04-01', '2011-05-01', '2011-06-01', '2011-07-01', '2011-08-01', '2011-09-01', '2011-10-01', '2011-11-01', '2011-12-01'
);
GO

/*
 * Create partition scheme for data in stage 3 by month.
 */
CREATE PARTITION SCHEME stage3_date_ps
AS PARTITION stage3_date_pf
TO (
	stage3mon1fg, stage3mon2fg, stage3mon3fg, stage3mon4fg, stage3mon5fg, stage3mon6fg, stage3mon7fg, stage3mon8fg, stage3mon9fg, stage3mon10fg, stage3mon11fg, stage3mon12fg,
	stage3mon1fg, stage3mon2fg, stage3mon3fg, stage3mon4fg, stage3mon5fg, stage3mon6fg, stage3mon7fg, stage3mon8fg, stage3mon9fg, stage3mon10fg, stage3mon11fg, stage3mon12fg,
	stage3mon1fg, stage3mon2fg, stage3mon3fg, stage3mon4fg, stage3mon5fg, stage3mon6fg, stage3mon7fg, stage3mon8fg, stage3mon9fg, stage3mon10fg, stage3mon11fg, stage3mon12fg
);
GO
