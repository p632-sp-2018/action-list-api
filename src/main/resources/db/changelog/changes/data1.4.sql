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


INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid1', 'pid1', '2018-02-09 15:50:25', 'A', 'arid1', 'dhid1', 'developer', 'dlgnpid1', 'action_list', 'i20_lbl', 'http://localhost:8080/workflow/documents/aid1', '20', 'rspid1', 'd', 0, 'i20', 'a1', 'grp1', 'rqst1');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid2', 'pid2', '2018-02-13 00:29:40', 'C', 'arid2', 'dhid2', 'analyst', 'dlgnpid2', 'data_api', 'i30_lbl', 'http://localhost:8080/workflow/documents/aid2', '40', 'rspid2', 'e', 0, 'i30', 'a2', 'grp2', 'rqst2');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid3', 'pid3', '2018-02-13 02:13:56', 'F', 'arid3', 'dhid3', 'engineer', 'dlgnpid3', 'wiki', 'i94', 'http://localhost:8080/workflow/documents/aid3', '60', 'rspid3', 'f', 1, 'i94', 'a3', 'grp3', 'rqst3');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid4', 'pid4', '2018-02-13 11:45:13', 'A', 'arid4', 'dhid4', 'developer', 'dlgnpid4', 'google', 'visa', 'http://localhost:8080/workflow/documents/aid4', '80', 'rspid4', 'g', 0, 'visa', 'a4', 'grp4', 'rqst4');



INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid5', 'pid5', '2018-01-13 23:54:11', 'C', 'arid5', 'dhid5', 'rider', 'dlgnpid5', 'github', 'passport', 'http://localhost:8080/workflow/documents/aid5', '100', 'rspid5', 'f', 0, 'passport', 'a5', 'grp5', 'rqst5');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid6', 'pid6', '2018-07-23 17:05:11', 'F', 'arid6', 'dhid6', 'driver', 'dlgnpid6', 'orkut', 'pancard', 'http://localhost:8080/workflow/documents/aid6', '120', 'rspid6', 'h', 0, 'pancard', 'a6', 'grp6', 'rqst6');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid7', 'pid7', '2018-03-05 03:14:01', 'A', 'arid7', 'dhid7', 'applier', 'dlgnpid7', 'linkedin', 'license', 'http://localhost:8080/workflow/documents/aid7', '140', 'rspid6', 'i', 0, 'license', 'a7', 'grp7', 'rqst7');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid8', 'pid8', '2017-12-29 13:07:25', 'C', 'arid8', 'dhid8', 'coder', 'dlgnpid8', 'indeed', 'crimson card', 'http://localhost:8080/workflow/documents/aid8', '160', 'rspid8', 'j', 0, 'crimson card', 'a8', 'grp8', 'rqst8');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid9', 'pid9', '2017-10-02 19:23:18', 'F', 'arid9', 'dhid9', 'manager', 'dlgnpid9', 'chegg', 'wallet', 'http://localhost:8080/workflow/documents/aid9', '180', 'rspid9', 'k', 0, 'wallet', 'a9', 'grp9', 'rqst9');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid10', 'pid10', '2017-11-25 20:34:57', 'A', 'arid10', 'dhid10', 'assistant', 'dlgnpid10', 'travis', 'credit card', 'http://localhost:8080/workflow/documents/aid10', '200', 'rspid10', 'l', 0, 'credit card', 'a10', 'grp10', 'rqst10');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid11', 'pid11', '2017-10-15 10:42:43', 'C', 'arid11', 'dhid11', 'professor', 'dlgnpid11', 'code climate', 'aadhar', 'http://localhost:8080/workflow/documents/aid11', '220', 'rspid11', 'p', 0, 'aadhar', 'a11', 'grp11', 'rqst11');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid12', 'pid12', '2017-09-14 22:14:25', 'F', 'arid12', 'dhid12', 'student', 'dlgnpid12', 'slack', 'meal card', 'http://localhost:8080/workflow/documents/aid12', '240', 'rspid12', 's', 0, 'meal card', 'a12', 'grp12', 'rqst12');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid13', 'pid13', '2017-05-27 00:34:55', 'A', 'arid13', 'dhid13', 'dean', 'dlgnpid13', 'jacoco', 'voterID', 'http://localhost:8080/workflow/documents/aid13', '260', 'rspid13', 'u', 0, 'voterID', 'a13', 'grp13', 'rqst13');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid14', 'pid14', '2017-03-25 10:24:32', 'C', 'arid14', 'dhid14', 'principal', 'dlgnpid14', 'postman', 'school card', 'http://localhost:8080/workflow/documents/aid14', '280', 'rspid14', 'z', 0, 'school card', 'a14', 'grp14', 'rqst14');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid15', 'pid15', '2017-07-15 20:34:57', 'F', 'arid15', 'dhid15', 'director', 'dlgnpid15', 'whatsapp', 'chip card', 'http://localhost:8080/workflow/documents/aid15', '300', 'rspid15', 'j', 0, 'chip card', 'a15', 'grp15', 'rqst15');
