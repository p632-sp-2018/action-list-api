--liquibase formatted sql
--changeset varun:1

DROP TABLE IF EXISTS krew_actn_itm_t;
DROP TABLE IF EXISTS krim_grp_t;
DROP TABLE IF EXISTS krim_prncpl_t;
DROP TABLE IF EXISTS krew_doc_hdr_t;
DROP TABLE IF EXISTS krim_entity_nm_t;

CREATE TABLE krew_actn_itm_t
(
      ACTN_ITM_ID VARCHAR(40)
        , PRNCPL_ID VARCHAR(40) NOT NULL
        , ASND_DT DATETIME NOT NULL
        , RQST_CD CHAR(1) NOT NULL
        , ACTN_RQST_ID VARCHAR(40) NOT NULL
        , DOC_HDR_ID VARCHAR(40) NOT NULL
        , ROLE_NM VARCHAR(2000)
        , DLGN_PRNCPL_ID VARCHAR(40)
        , DOC_HDR_TTL VARCHAR(255)
        , DOC_TYP_LBL VARCHAR(128) NOT NULL
        , DOC_HDLR_URL VARCHAR(255) NOT NULL
        , DOC_TYP_NM VARCHAR(64) NOT NULL
        , RSP_ID VARCHAR(40) NOT NULL
        , DLGN_TYP VARCHAR(1)
        , VER_NBR DECIMAL(8) default 0
        , DTYPE VARCHAR(50)
        , GRP_ID VARCHAR(40)
        , DLGN_GRP_ID VARCHAR(40)
        , RQST_LBL VARCHAR(255)
    
    , CONSTRAINT krew_actn_itm_tp1 PRIMARY KEY(ACTN_ITM_ID)  
	, INDEX KREW_ACTN_ITM_T1 (PRNCPL_ID )                                    
	, INDEX KREW_ACTN_ITM_TI2 (DOC_HDR_ID )                                    
	, INDEX KREW_ACTN_ITM_TI3 (ACTN_RQST_ID )
	, INDEX KREW_ACTN_ITM_TI5 (PRNCPL_ID , DLGN_TYP , DOC_HDR_ID )
	, INDEX KREW_ACTN_ITM_TI6 (DLGN_TYP , DLGN_PRNCPL_ID , DLGN_GRP_ID )
);

/*
CREATE INDEX krew_actn_itm_t1 ON krew_actn_itm_t(PRNCPL_ID);
CREATE INDEX krew_actn_itm_ti2 ON krew_actn_itm_t(DOC_HDR_ID);
CREATE INDEX krew_actn_itm_ti3 ON krew_actn_itm_t(ACTN_RQST_ID);
CREATE INDEX krew_actn_itm_ti5 ON krew_actn_itm_t(PRNCPL_ID , DLGN_TYP , DOC_HDR_ID);
CREATE INDEX krew_actn_itm_ti6 ON krew_actn_itm_t(DLGN_TYP , DLGN_PRNCPL_ID , DLGN_GRP_ID);
*/


CREATE TABLE krim_grp_t
(
      GRP_ID VARCHAR(40)
        , OBJ_ID VARCHAR(36) NOT NULL
        , VER_NBR DECIMAL(8) default 1 NOT NULL
        , GRP_NM VARCHAR(80) NOT NULL
        , NMSPC_CD VARCHAR(40) NOT NULL
        , GRP_DESC VARCHAR(4000)
        , KIM_TYP_ID VARCHAR(40) NOT NULL
        , ACTV_IND VARCHAR(1) default 'Y'
        , LAST_UPDT_DT DATETIME
    
    , CONSTRAINT KRIM_GRP_TP1 PRIMARY KEY(GRP_ID)
    , CONSTRAINT KRIM_GRP_TC0 UNIQUE (OBJ_ID)
    , CONSTRAINT KRIM_GRP_TC1 UNIQUE (GRP_NM, NMSPC_CD)
);

CREATE TABLE krim_prncpl_t
(
      PRNCPL_ID VARCHAR(40)
        , OBJ_ID VARCHAR(36) NOT NULL
        , VER_NBR DECIMAL(8) default 1 NOT NULL
        , PRNCPL_NM VARCHAR(100) NOT NULL
        , ENTITY_ID VARCHAR(40)
        , PRNCPL_PSWD VARCHAR(400)
        , ACTV_IND VARCHAR(1) default 'Y'
        , LAST_UPDT_DT DATETIME
    , CONSTRAINT KRIM_PRNCPL_TP1 PRIMARY KEY(PRNCPL_ID)
    , CONSTRAINT KRIM_PRNCPL_TC0 UNIQUE (OBJ_ID)
    , CONSTRAINT KRIM_PRNCPL_TC1 UNIQUE (PRNCPL_NM)
);


CREATE TABLE krew_doc_hdr_t
(
      DOC_HDR_ID VARCHAR(40)
        , DOC_TYP_ID VARCHAR(40)
        , DOC_HDR_STAT_CD CHAR(1) NOT NULL
        , RTE_LVL DECIMAL(8) NOT NULL
        , STAT_MDFN_DT DATE NOT NULL
        , CRTE_DT DATE NOT NULL
        , APRV_DT DATE
        , FNL_DT DATE
        , RTE_STAT_MDFN_DT DATE
        , RTE_LVL_MDFN_DT DATE
        , TTL VARCHAR(255)
        , APP_DOC_ID VARCHAR(255)
        , DOC_VER_NBR DECIMAL(8) NOT NULL
        , INITR_PRNCPL_ID VARCHAR(40) NOT NULL
        , VER_NBR DECIMAL(8) default 0
        , RTE_PRNCPL_ID VARCHAR(40)
        , DTYPE VARCHAR(50)
        , OBJ_ID VARCHAR(36) NOT NULL
        , APP_DOC_STAT VARCHAR(64)
        , APP_DOC_STAT_MDFN_DT DATE
	, CONSTRAINT KREW_DOC_HDR_TP1 PRIMARY KEY (DOC_HDR_ID)
    , CONSTRAINT KREW_DOC_HDR_TC0 UNIQUE (OBJ_ID)
    , INDEX KREW_DOC_HDR_T10 (APP_DOC_STAT)
    , INDEX KREW_DOC_HDR_T12 (APP_DOC_STAT_MDFN_DT)
    , INDEX KREW_DOC_HDR_TI1 (DOC_TYP_ID)
    , INDEX KREW_DOC_HDR_TI2 (INITR_PRNCPL_ID)
    , INDEX KREW_DOC_HDR_TI3 (DOC_HDR_STAT_CD)
    , INDEX KREW_DOC_HDR_TI4 (TTL)
    , INDEX KREW_DOC_HDR_TI5 (CRTE_DT)
    , INDEX KREW_DOC_HDR_TI6 (RTE_STAT_MDFN_DT)
    , INDEX KREW_DOC_HDR_TI7 (APRV_DT)
    , INDEX KREW_DOC_HDR_TI8 (FNL_DT)
    , INDEX KREW_DOC_HDR_TI9 (APP_DOC_ID)
);


CREATE TABLE krim_entity_nm_t
(
      ENTITY_NM_ID VARCHAR(40)
        , OBJ_ID VARCHAR(36) NOT NULL
        , VER_NBR DECIMAL(8) default 1 NOT NULL
        , ENTITY_ID VARCHAR(40)
        , NM_TYP_CD VARCHAR(40)
        , FIRST_NM VARCHAR(40)
        , MIDDLE_NM VARCHAR(40)
        , LAST_NM VARCHAR(80)
        , SUFFIX_NM VARCHAR(20)
        , PREFIX_NM VARCHAR(20)
        , DFLT_IND VARCHAR(1) default 'N'
        , ACTV_IND VARCHAR(1) default 'Y'
        , LAST_UPDT_DT DATETIME
        , TITLE_NM VARCHAR(20)
        , NOTE_MSG VARCHAR(1024)
        , NM_CHNG_DT DATETIME
    
    , CONSTRAINT KRIM_ENTITY_NM_TP1 PRIMARY KEY(ENTITY_NM_ID)
    , CONSTRAINT KRIM_ENTITY_NM_TC0 UNIQUE (OBJ_ID)																																																																																																
	, INDEX KRIM_ENTITY_NM_TI1 (ENTITY_ID )
);

-- Insert statements for krew_actn_itm_t
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid1', 'pid1', '2018-02-09 15:50:25', 'A', 'arid1', 'dhid1', 'developer', 'dlgnpid1', 'action_list', 'i20_lbl', 'http://localhost:8080/workflow/documents/aid1', '20', 'rspid1', 'd', 0, 'i20', 'a1', 'grp1', 'rqst1');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid2', 'pid2', '2018-02-13 00:29:40', 'C', 'arid2', 'dhid2', 'analyst', 'dlgnpid2', 'data_api', 'i30_lbl', 'http://localhost:8080/workflow/documents/aid2', '40', 'rspid2', 'e', 0, 'i30', NULL, 'grp2', 'rqst2');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid3', 'pid3', '2018-02-13 02:13:56', 'F', 'arid3', 'dhid3', 'engineer', 'dlgnpid3', 'wiki', 'i94', 'http://localhost:8080/workflow/documents/aid3', '60', 'rspid3', 'f', 1, 'i94', NULL, 'grp3', 'rqst3');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid4', 'pid4', '2018-02-13 11:45:13', 'A', 'arid4', 'dhid4', 'developer', 'dlgnpid4', 'google', 'visa', 'http://localhost:8080/workflow/documents/aid4', '80', 'rspid4', 'g', 0, 'visa', 'a1', 'grp4', 'rqst4');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid5', 'pid1', '2018-01-13 23:54:11', 'C', 'arid5', 'dhid1', 'rider', 'dlgnpid5', 'github', 'passport', 'http://localhost:8080/workflow/documents/aid5', '100', 'rspid5', 'f', 0, 'passport', 'a2', 'grp5', 'rqst5');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid6', 'pid2', '2018-07-23 17:05:11', 'F', 'arid6', 'dhid2', 'driver', 'dlgnpid6', 'orkut', 'pancard', 'http://localhost:8080/workflow/documents/aid6', '120', 'rspid6', 'h', 0, 'pancard', 'a3', 'grp6', 'rqst6');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid7', 'pid3', '2018-03-05 03:14:01', 'A', 'arid7', 'dhid3', 'applier', 'dlgnpid7', 'linkedin', 'license', 'http://localhost:8080/workflow/documents/aid7', '140', 'rspid6', 'i', 0, 'license', 'a1', 'grp7', 'rqst7');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid8', 'pid4', '2017-12-29 13:07:25', 'C', 'arid8', 'dhid4', 'coder', 'dlgnpid8', 'indeed', 'crimson card', 'http://localhost:8080/workflow/documents/aid8', '160', 'rspid8', 'j', 0, 'crimson card', 'a2', 'grp8', 'rqst8');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid9', 'pid1', '2017-10-02 19:23:18', 'F', 'arid9', 'dhid1', 'manager', 'dlgnpid9', 'chegg', 'wallet', 'http://localhost:8080/workflow/documents/aid9', '180', 'rspid9', 'k', 0, 'wallet', 'a3', 'grp9', 'rqst9');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid10', 'pid1', '2017-11-25 20:34:57', 'A', 'arid10', 'dhid2', 'assistant', 'dlgnpid10', 'travis', 'credit card', 'http://localhost:8080/workflow/documents/aid10', '200', 'rspid10', 'l', 0, 'credit card', 'a1', 'grp10', 'rqst10');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid11', 'pid2', '2017-10-15 10:42:43', 'C', 'arid11', 'dhid3', 'professor', 'dlgnpid11', 'code climate', 'aadhar', 'http://localhost:8080/workflow/documents/aid11', '220', 'rspid11', 'p', 0, 'aadhar', 'a2', 'grp11', 'rqst11');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid12', 'pid3', '2017-09-14 22:14:25', 'F', 'arid12', 'dhid4', 'student', 'dlgnpid12', 'slack', 'meal card', 'http://localhost:8080/workflow/documents/aid12', '240', 'rspid12', 's', 0, 'meal card', NULL, 'grp12', 'rqst12');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid13', 'pid4', '2017-05-27 00:34:55', 'A', 'arid13', 'dhid1', 'dean', 'dlgnpid13', 'jacoco', 'voterID', 'http://localhost:8080/workflow/documents/aid13', '260', 'rspid13', 'u', 0, 'voterID', 'a1', 'grp13', 'rqst13');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid14', 'pid1', '2017-03-25 10:24:32', 'C', 'arid14', 'dhid2', 'principal', 'dlgnpid14', 'postman', 'school card', 'http://localhost:8080/workflow/documents/aid14', '280', 'rspid14', 'z', 0, 'school card', 'a2', 'grp14', 'rqst14');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid15', 'pid2', '2017-07-15 20:34:57', 'F', 'arid15', 'dhid3', 'director', 'dlgnpid15', 'whatsapp', 'chip card', 'http://localhost:8080/workflow/documents/aid15', '300', 'rspid15', 'j', 0, 'chip card', 'a3', 'grp15', 'rqst15');

-- Insert statements for krim_grp_t
INSERT INTO krim_grp_t (GRP_ID, OBJ_ID, VER_NBR, GRP_NM, NMSPC_CD, GRP_DESC, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT) VALUES('a1', 'obj1', 1, 'nightwatchers', 'nmspc_grp1', 'Group working for UITS in OOSM course', 'Kim_type_id_1', 'Y', '2018-02-13 17:45:13');
INSERT INTO krim_grp_t (GRP_ID, OBJ_ID, VER_NBR, GRP_NM, NMSPC_CD, GRP_DESC, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT) VALUES('a2', 'obj2', 1, 'aim', 'nmspc_grp2', 'Group working for Ambition In Motion in OOSM course', 'Kim_type_id_2', 'N', '2018-03-01 12:34:32');
INSERT INTO krim_grp_t (GRP_ID, OBJ_ID, VER_NBR, GRP_NM, NMSPC_CD, GRP_DESC, KIM_TYP_ID, ACTV_IND, LAST_UPDT_DT) VALUES('a3', 'obj3', 1, 'iStart', 'nmspc_grp3', 'Group working for OIS in OOSM course', 'Kim_type_id_3', 'Y', '2018-02-28 15:02:45');

-- Insert statements for krim_prncpl_t
INSERT INTO krim_prncpl_t (PRNCPL_ID, OBJ_ID, VER_NBR, PRNCPL_NM, ENTITY_ID, PRNCPL_PSWD, ACTV_IND, LAST_UPDT_DT) VALUES('pid1', 'obj1', 1, 'prncpl1', 'e1', '12345', 'y', '2018-02-13 17:45:13');
INSERT INTO krim_prncpl_t (PRNCPL_ID, OBJ_ID, VER_NBR, PRNCPL_NM, ENTITY_ID, PRNCPL_PSWD, ACTV_IND, LAST_UPDT_DT) VALUES('pid2', 'obj2', 1, 'prncpl2', 'e2', '67890', 'n', '2018-01-24 16:05:32');
INSERT INTO krim_prncpl_t (PRNCPL_ID, OBJ_ID, VER_NBR, PRNCPL_NM, ENTITY_ID, PRNCPL_PSWD, ACTV_IND, LAST_UPDT_DT) VALUES('pid3', 'obj3', 1, 'prncpl3', 'e3', '62342', 'y', '2018-02-13 17:45:13');
INSERT INTO krim_prncpl_t (PRNCPL_ID, OBJ_ID, VER_NBR, PRNCPL_NM, ENTITY_ID, PRNCPL_PSWD, ACTV_IND, LAST_UPDT_DT) VALUES('pid4', 'obj4', 1, 'prncpl4', 'e4', '23222', 'n', '2017-12-31 21:37:01');

-- Insert statements for krew_doc_hdr_t
INSERT INTO krew_doc_hdr_t (DOC_HDR_ID, DOC_TYP_ID, DOC_HDR_STAT_CD, RTE_LVL, STAT_MDFN_DT, CRTE_DT, APRV_DT, FNL_DT, RTE_STAT_MDFN_DT, RTE_LVL_MDFN_DT, TTL, APP_DOC_ID, DOC_VER_NBR, INITR_PRNCPL_ID, VER_NBR, RTE_PRNCPL_ID, DTYPE, OBJ_ID, APP_DOC_STAT, APP_DOC_STAT_MDFN_DT) VALUES('dhid1', NULL, 'I', 1, '2018-02-03', '2017-01-01', '2017-06-01', NULL, NULL, NULL, NULL, NULL, 1, 'pid1', 0, NULL, NULL, 'obj1', NULL, NULL);
INSERT INTO krew_doc_hdr_t (DOC_HDR_ID, DOC_TYP_ID, DOC_HDR_STAT_CD, RTE_LVL, STAT_MDFN_DT, CRTE_DT, APRV_DT, FNL_DT, RTE_STAT_MDFN_DT, RTE_LVL_MDFN_DT, TTL, APP_DOC_ID, DOC_VER_NBR, INITR_PRNCPL_ID, VER_NBR, RTE_PRNCPL_ID, DTYPE, OBJ_ID, APP_DOC_STAT, APP_DOC_STAT_MDFN_DT) VALUES('dhid2', NULL, 'S', 2, '2018-03-02', '2017-02-01', '2017-07-01', NULL, NULL, NULL, NULL, NULL, 1, 'pid2', 0, NULL, NULL, 'obj2', NULL, NULL);
INSERT INTO krew_doc_hdr_t (DOC_HDR_ID, DOC_TYP_ID, DOC_HDR_STAT_CD, RTE_LVL, STAT_MDFN_DT, CRTE_DT, APRV_DT, FNL_DT, RTE_STAT_MDFN_DT, RTE_LVL_MDFN_DT, TTL, APP_DOC_ID, DOC_VER_NBR, INITR_PRNCPL_ID, VER_NBR, RTE_PRNCPL_ID, DTYPE, OBJ_ID, APP_DOC_STAT, APP_DOC_STAT_MDFN_DT) VALUES('dhid3', NULL, 'R', 3, '2018-03-10', '2017-12-31', '2018-02-01', NULL, NULL, NULL, NULL, NULL, 1, 'pid3', 0, NULL, NULL, 'obj3', NULL, NULL);
INSERT INTO krew_doc_hdr_t (DOC_HDR_ID, DOC_TYP_ID, DOC_HDR_STAT_CD, RTE_LVL, STAT_MDFN_DT, CRTE_DT, APRV_DT, FNL_DT, RTE_STAT_MDFN_DT, RTE_LVL_MDFN_DT, TTL, APP_DOC_ID, DOC_VER_NBR, INITR_PRNCPL_ID, VER_NBR, RTE_PRNCPL_ID, DTYPE, OBJ_ID, APP_DOC_STAT, APP_DOC_STAT_MDFN_DT) VALUES('dhid4', NULL, 'P', 4, '2018-03-07', '2017-07-08', '2017-09-06', NULL, NULL, NULL, NULL, NULL, 1, 'pid4', 0, NULL, NULL, 'obj4', NULL, NULL);

-- Insert statements for krim_entity_nm_t
INSERT INTO krim_entity_nm_t (ENTITY_NM_ID, OBJ_ID, VER_NBR, ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, PREFIX_NM, DFLT_IND, ACTV_IND, LAST_UPDT_DT, TITLE_NM, NOTE_MSG, NM_CHNG_DT) VALUES('enmId1', 'obj1', 1, 'e1', NULL, 'Sagar', 'Suresh', 'Panchal', NULL, NULL, 'Y', 'Y', '2017-01-01 00:00:00', NULL, NULL, NULL);
INSERT INTO krim_entity_nm_t (ENTITY_NM_ID, OBJ_ID, VER_NBR, ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, PREFIX_NM, DFLT_IND, ACTV_IND, LAST_UPDT_DT, TITLE_NM, NOTE_MSG, NM_CHNG_DT) VALUES('enmId2', 'obj2', 1, 'e2', NULL, 'Shantanu', NULL, 'Kotambkar', NULL, NULL, 'N', 'N', '2018-03-04 07:56:45', NULL, NULL, NULL);
INSERT INTO krim_entity_nm_t (ENTITY_NM_ID, OBJ_ID, VER_NBR, ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, PREFIX_NM, DFLT_IND, ACTV_IND, LAST_UPDT_DT, TITLE_NM, NOTE_MSG, NM_CHNG_DT) VALUES('enmId3', 'obj3', 1, 'e3', NULL, 'Varun', NULL, 'Machingal', NULL, NULL, 'N', 'Y', '2017-12-31 23:59:59', NULL, NULL, NULL);
INSERT INTO krim_entity_nm_t (ENTITY_NM_ID, OBJ_ID, VER_NBR, ENTITY_ID, NM_TYP_CD, FIRST_NM, MIDDLE_NM, LAST_NM, SUFFIX_NM, PREFIX_NM, DFLT_IND, ACTV_IND, LAST_UPDT_DT, TITLE_NM, NOTE_MSG, NM_CHNG_DT) VALUES('enmId4', 'obj4', 1, 'e4', NULL, 'Nikhilesh', NULL, 'Chilkuru', NULL, NULL, 'Y', 'Y', '2018-02-22 14:43:15', NULL, NULL, NULL);