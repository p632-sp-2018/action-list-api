package com.actionlistapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import java.math.BigDecimal;

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
	private String id;

	@Column(name="ACTN_RQST_ID", nullable=false, length=40)
	private String actionRequestId;

	@Column(name="ASND_DT", nullable=false)
	private Date creationDate;

	@Column(name="DLGN_GRP_ID", length=40)
	private String dlgnGrpId;

	@Column(name="DLGN_PRNCPL_ID", length=40)
	private String dlgnPrncplId;

	@Column(name="DLGN_TYP", length=1)
	private String delegationType;

	@Column(name="DOC_HDLR_URL", nullable=false, length=255)
	private String documentUrl;

	@Column(name="DOC_HDR_ID", nullable=false, length=40)
	private String documentId;

	@Column(name="DOC_HDR_TTL", length=255)
	private String title;

	@Column(name="DOC_TYP_LBL", nullable=false, length=128)
	private String documentTypeLabel;

	@Column(name="DOC_TYP_NM", nullable=false, length=64)
	private String documentTypeName;

	@Column(length=50)
	private String dtype;
	
	@ManyToOne
	@JoinColumn(name="GRP_ID")
	private KrimGrpT group;

	@ManyToOne
	@JoinColumn(name="PRNCPL_ID")
	private KrimPrncplT principal;

//	@Column(name="PRNCPL_ID", updatable=false)
//	private String principalId;

	@Column(name="ROLE_NM", length=2000)
	private String roleName;

	@Column(name="RQST_CD", nullable=false, length=1)
	private String requestCode;

	@Column(name="RQST_LBL", length=255)
	private String requestLabel;

	@Column(name="RSP_ID", nullable=false, length=40)
	private String responsibilityId;

	@Column(name="VER_NBR", precision=10)
	private BigDecimal verNbr;
	
	@Transient
	private String routeLogUrl;

	public KrewActnItmT() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getActionRequestId() {
		return this.actionRequestId;
	}

	public void setActionRequestId(String actionRequestId) {
		this.actionRequestId = actionRequestId;
	}

	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
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

	public String getDelegationType() {
		return this.delegationType;
	}

	public void setDelegationType(String delegationType) {
		this.delegationType = delegationType;
	}

	public String getDocumentUrl() {
		return this.documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
	}

	public String getDocumentId() {
		return this.documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDocumentTypeLabel() {
		return this.documentTypeLabel;
	}

	public void setDocumentTypeLabel(String documentTypeLabel) {
		this.documentTypeLabel = documentTypeLabel;
	}

	public String getDocumentTypeName() {
		return this.documentTypeName;
	}

	public void setDocumentTypeName(String documentTypeName) {
		this.documentTypeName = documentTypeName;
	}

	public String getDtype() {
		return this.dtype;
	}

	public void setDtype(String dtype) {
		this.dtype = dtype;
	}

	public KrimGrpT getGroup() {
		return group;
	}

	public void setGroup(KrimGrpT group) {
		this.group = group;
	}

//	public String getPrncplId() {
//		return this.principalId;
//	}

//	public void setPrncplId(String principalId) {
//		this.principalId = principalId;
//	}

	public KrimPrncplT getPrincipal() {
		return principal;
	}

	public void setPrincipal(KrimPrncplT principal) {
		this.principal = principal;
	}

	public String getRoleName() {
		return this.roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getRequestCode() {
		return this.requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	public String getRequestLabel() {
		return this.requestLabel;
	}

	public void setRequestLabel(String rqstLbl) {
		this.requestLabel = rqstLbl;
	}

	public String getResponsibilityId() {
		return this.responsibilityId;
	}

	public void setResponsibilityId(String responsibilityId) {
		this.responsibilityId = responsibilityId;
	}

	public BigDecimal getVerNbr() {
		return this.verNbr;
	}

	public void setVerNbr(BigDecimal verNbr) {
		this.verNbr = verNbr;
	}

	public String getRouteLogUrl() {
		return routeLogUrl;
	}

	public void setRouteLogUrl(String routeLogUrl) {
		this.routeLogUrl = routeLogUrl;
	}

	
}