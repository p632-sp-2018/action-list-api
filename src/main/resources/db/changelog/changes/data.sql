--liquibase formatted sql
--changeset varun:2

INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid1', 'pid1', '2018-02-09 15:50:25', 'y', 'arid1', 'dhid1', 'developer', 'dlgnpid1', 'action_list', 'i20_lbl', 'www.google.com', '20', 'rspid1', 'd', 0, 'i20', 'a1', 'grp1', 'rqst1');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid2', 'pid2', '2018-02-13 00:29:40', 'n', 'arid2', 'dhid2', 'analyst', 'dlgnpid2', 'data_api', 'i30_lbl', 'www.facebook.com', '40', 'rspid2', 'e', 0, 'i30', 'a2', 'grp2', 'rqst2');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid3', 'pid3', '2018-02-13 02:13:56', 'y', 'arid3', 'dhid3', 'engineer', 'dlgnpid3', 'wiki', 'i94', 'www.iu.edu', '60', 'rspid3', 'f', 1, 'i94', 'a3', 'grp3', 'rqst3');
INSERT INTO krew_actn_itm_t (ACTN_ITM_ID, PRNCPL_ID, ASND_DT, RQST_CD, ACTN_RQST_ID, DOC_HDR_ID, ROLE_NM, DLGN_PRNCPL_ID, DOC_HDR_TTL, DOC_TYP_LBL, DOC_HDLR_URL, DOC_TYP_NM, RSP_ID, DLGN_TYP, VER_NBR, DTYPE, GRP_ID, DLGN_GRP_ID, RQST_LBL) VALUES('aid4', 'pid4', '2018-02-13 11:45:13', 'n', 'arid4', 'dhid4', 'developer', 'dlgnpid4', 'google', 'visa', 'www.github.com', '80', 'rspid4', 'g', 0, 'visa', 'a4', 'grp4', 'rqst4');