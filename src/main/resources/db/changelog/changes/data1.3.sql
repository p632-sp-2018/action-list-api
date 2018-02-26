--liquibase formatted sql
--changeset varun:2

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



INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid1', 'pid1', '2018-02-09 15:50:25', 'A', 'arid1', 'dhid1', 'developer', 'dlgnpid1', 'action_list', 'i20_lbl', 'www.google.com', '20', 'rspid1', 'd', 0, 'i20', 'a1', 'grp1', 'rqst1');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid2', 'pid2', '2018-02-13 00:29:40', 'C', 'arid2', 'dhid2', 'analyst', 'dlgnpid2', 'data_api', 'i30_lbl', 'www.facebook.com', '40', 'rspid2', 'e', 0, 'i30', 'a2', 'grp2', 'rqst2');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid3', 'pid3', '2018-02-13 02:13:56', 'F', 'arid3', 'dhid3', 'engineer', 'dlgnpid3', 'wiki', 'i94', 'www.iu.edu', '60', 'rspid3', 'f', 1, 'i94', 'a3', 'grp3', 'rqst3');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid4', 'pid4', '2018-02-13 11:45:13', 'A', 'arid4', 'dhid4', 'developer', 'dlgnpid4', 'google', 'visa', 'www.github.com', '80', 'rspid4', 'g', 0, 'visa', 'a4', 'grp4', 'rqst4');
