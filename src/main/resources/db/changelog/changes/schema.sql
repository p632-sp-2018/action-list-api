--liquibase formatted sql
--changeset varun:1

DROP TABLE IF EXISTS krew_actn_itm_t;

CREATE TABLE  krew_actn_itm_t (
  ACTN_ITM_ID varchar(40)  NOT NULL DEFAULT '',
  PRNCPL_ID varchar(40)  NOT NULL,
  ASND_DT datetime NOT NULL,
  RQST_CD char(1)  NOT NULL,
  ACTN_RQST_ID varchar(40)  NOT NULL,
  DOC_HDR_ID varchar(40)  NOT NULL,
  ROLE_NM varchar(2000)  DEFAULT NULL,
  DLGN_PRNCPL_ID varchar(40)  DEFAULT NULL,
  DOC_HDR_TTL varchar(255)  DEFAULT NULL,
  DOC_TYP_LBL varchar(128)  NOT NULL,
  DOC_HDLR_URL varchar(255)  NOT NULL,
  DOC_TYP_NM varchar(64)  NOT NULL,
  RSP_ID varchar(40)  NOT NULL,
  DLGN_TYP varchar(1)  DEFAULT NULL,
  VER_NBR decimal(8,0) DEFAULT '0',
  DTYPE varchar(50)  DEFAULT NULL,
  GRP_ID varchar(40)  DEFAULT NULL,
  DLGN_GRP_ID varchar(40)  DEFAULT NULL,
  RQST_LBL varchar(255)  DEFAULT NULL
);