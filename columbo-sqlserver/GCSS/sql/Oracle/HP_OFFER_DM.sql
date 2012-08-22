--------------------------------------------------------
--  Datei erstellt -Dienstag-Juli-19-2011   
--------------------------------------------------------
-- Wiedergabe von TABLE DDL f�r Objekt DBO.HP_OFFER_DM nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE INDEX DBO.HOD_IDX1_DATE_ADDED ON DBO.HP_OFFER_DM (DATE_ADDED ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
CREATE INDEX DBO.HOD_IDX2_DATE_MODIFIED ON DBO.HP_OFFER_DM (DATE_MODIFIED ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
CREATE INDEX DBO.HOD_IDX3_OFFER_REF_ID ON DBO.HP_OFFER_DM (OFFER_REF_ID ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
CREATE INDEX DBO.HOD_IDX4_PKG_REF_ID ON DBO.HP_OFFER_DM (PKG_REF_ID ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)CREATE TABLE DBO.HP_OFFER_DM 
(
  OFFER_ID NUMBER(10, 0) NOT NULL 
, END_DATE DATE 
, OFFER_REF_ID NUMBER(10, 0) 
, PKG_REF_ID NUMBER(10, 0) 
, PROFIT_CENTER VARCHAR2(30 BYTE) 
, SVC_PRODUCT_LINE VARCHAR2(18 BYTE) 
, SALES_ORDER_NUMBER VARCHAR2(75 BYTE) 
, SOURCE_OBLIGATION_ID VARCHAR2(54 BYTE) 
, STAND_ALONE_FLAG NUMBER(10, 0) 
, ENTITLEMENT_TYPE_CD VARCHAR2(3 BYTE) 
, LINE_ITEM VARCHAR2(18 BYTE) 
, QTY_AVAILABLE NUMBER(10, 0) 
, QTY_PURCHASED NUMBER(10, 0) 
, START_DATE DATE 
, STATUS_CD VARCHAR2(3 BYTE) 
, TERM_CD VARCHAR2(54 BYTE) 
, WARRANTY_COMMENT VARCHAR2(765 BYTE) 
, DATE_ADDED DATE 
, DATE_MODIFIED DATE 
, X_INCIDENT_BASED_FLAG NUMBER(1, 0) 
, CONSTRAINT HOD_PK PRIMARY KEY 
  (
    OFFER_ID 
  )
  ENABLE 
) 
NOLOGGING 
TABLESPACE "WFMTABLAR" 
PCTFREE 10 
INITRANS 1 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
-- Wiedergabe von INDEX DDL f�r Objekt DBO.HOD_IDX4_PKG_REF_ID nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE INDEX DBO.HOD_IDX4_PKG_REF_ID ON DBO.HP_OFFER_DM (PKG_REF_ID ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
-- Wiedergabe von INDEX DDL f�r Objekt DBO.HOD_PK nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE UNIQUE INDEX DBO.HOD_PK ON DBO.HP_OFFER_DM (OFFER_ID) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
-- Wiedergabe von INDEX DDL f�r Objekt DBO.HOD_IDX1_DATE_ADDED nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE INDEX DBO.HOD_IDX1_DATE_ADDED ON DBO.HP_OFFER_DM (DATE_ADDED ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
-- Wiedergabe von INDEX DDL f�r Objekt DBO.HOD_IDX2_DATE_MODIFIED nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE INDEX DBO.HOD_IDX2_DATE_MODIFIED ON DBO.HP_OFFER_DM (DATE_MODIFIED ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
-- Wiedergabe von INDEX DDL f�r Objekt DBO.HOD_IDX3_OFFER_REF_ID nicht m�glich, da DBMS_METADATA internen Generator versucht.
CREATE INDEX DBO.HOD_IDX3_OFFER_REF_ID ON DBO.HP_OFFER_DM (OFFER_REF_ID ASC) 
NOLOGGING 
TABLESPACE "WFMIDXLAR" 
PCTFREE 10 
INITRANS 2 
STORAGE 
( 
  INITIAL 33554432 
  NEXT 33554432 
  MINEXTENTS 1 
  MAXEXTENTS 2147483645 
  PCTINCREASE 0 
  BUFFER_POOL DEFAULT 
)
