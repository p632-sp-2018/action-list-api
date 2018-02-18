package com.actionlistapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the KREW_ACTN_ITM_T database table.
 * 
 */
@Entity
@Table(name="KREW_ACTN_ITM_T")

public class KrewActnItmT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="ACTN_ITM_ID", unique=true, nullable=false, length=40)
	private String actnItmId;

	@Column(name="ACTN_RQST_ID", nullable=false, length=40)
	private String actnRqstId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="ASND_DT", nullable=false)
	private Date asndDt;

	@Column(name="DLGN_GRP_ID", length=40)
	private String dlgnGrpId;

	@Column(name="DLGN_PRNCPL_ID", length=40)
	private String dlgnPrncplId;

	@Column(name="DLGN_TYP", length=1)
	private String dlgnTyp;

	@Column(name="DOC_HDLR_URL", nullable=false, length=255)
	private String docHdlrUrl;

	@Column(name="DOC_HDR_ID", nullable=false, length=40)
	private String docHdrId;

	@Column(name="DOC_HDR_TTL", length=255)
	private String docHdrTtl;

	@Column(name="DOC_TYP_LBL", nullable=false, length=128)
	private String docTypLbl;

	@Column(name="DOC_TYP_NM", nullable=false, length=64)
	private String docTypNm;

	@Column(length=50)
	private String dtype;

	@Column(name="GRP_ID", length=40)
	private String grpId;

	@Column(name="PRNCPL_ID", nullable=false, length=40)
	private String prncplId;

	@Column(name="ROLE_NM", length=2000)
	private String roleNm;

	@Column(name="RQST_CD", nullable=false, length=1)
	private String rqstCd;

	@Column(name="RQST_LBL", length=255)
	private String rqstLbl;

	@Column(name="RSP_ID", nullable=false, length=40)
	private String rspId;

	@Column(name="VER_NBR", precision=10)
	private BigDecimal verNbr;

	public KrewActnItmT() {
	}

	public String getActnItmId() {
		return this.actnItmId;
	}

	public void setActnItmId(String actnItmId) {
		this.actnItmId = actnItmId;
	}

	public String getActnRqstId() {
		return this.actnRqstId;
	}

	public void setActnRqstId(String actnRqstId) {
		this.actnRqstId = actnRqstId;
	}

	public Date getAsndDt() {
		return this.asndDt;
	}

	public void setAsndDt(Date asndDt) {
		this.asndDt = asndDt;
	}

	public String getDlgnGrpId() {
		return this.dlgnGrpId;
	}

	public void setDlgnGrpId(String dlgnGrpId) {
		this.dlgnGrpId = dlgnGrpId;
	}

	public String getDlgnPrncplId() {
		return this.dlgnPrncplId;
	}

	public void setDlgnPrncplId(String dlgnPrncplId) {
		this.dlgnPrncplId = dlgnPrncplId;
	}

	public String getDlgnTyp() {
		return this.dlgnTyp;
	}

	public void setDlgnTyp(String dlgnTyp) {
		this.dlgnTyp = dlgnTyp;
	}

	public String getDocHdlrUrl() {
		return this.docHdlrUrl;
	}

	public void setDocHdlrUrl(String docHdlrUrl) {
		this.docHdlrUrl = docHdlrUrl;
	}

	public String getDocHdrId() {
		return this.docHdrId;
	}

	public void setDocHdrId(String docHdrId) {
		this.docHdrId = docHdrId;
	}

	public String getDocHdrTtl() {
		return this.docHdrTtl;
	}

	public void setDocHdrTtl(String docHdrTtl) {
		this.docHdrTtl = docHdrTtl;
	}

	public String getDocTypLbl() {
		return this.docTypLbl;
	}

	public void setDocTypLbl(String docTypLbl) {
		this.docTypLbl = docTypLbl;
	}

	public String getDocTypNm() {
		return this.docTypNm;
	}

	public void setDocTypNm(String docTypNm) {
		this.docTypNm = docTypNm;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public String getGrpId() {
		return this.grpId;
	}

	public void setGrpId(String grpId) {
		this.grpId = grpId;
	}

	public String getPrncplId() {
		return this.prncplId;
	}

	public void setPrncplId(String prncplId) {
		this.prncplId = prncplId;
	}

	public String getRoleNm() {
		return this.roleNm;
	}

	public void setRoleNm(String roleNm) {
		this.roleNm = roleNm;
	}

	public String getRqstCd() {
		return this.rqstCd;
	}

	public void setRqstCd(String rqstCd) {
		this.rqstCd = rqstCd;
	}

	public String getRqstLbl() {
		return this.rqstLbl;
	}

	public void setRqstLbl(String rqstLbl) {
		this.rqstLbl = rqstLbl;
	}

	public String getRspId() {
		return this.rspId;
	}

	public void setRspId(String rspId) {
		this.rspId = rspId;
	}

	public BigDecimal getVerNbr() {
		return this.verNbr;
	}

	public void setVerNbr(BigDecimal verNbr) {
		this.verNbr = verNbr;
	}

}