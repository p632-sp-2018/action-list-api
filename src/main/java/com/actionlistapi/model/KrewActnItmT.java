package com.actionlistapi.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;

import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

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

	@Column(name="ASND_DT", nullable=false)
	private Date creationDate;

	@Column(name="DOC_HDLR_URL", nullable=false, length=255)
	private String documentUrl;

	@Column(name="DOC_HDR_TTL", length=255)
	private String title;

	@Column(name="DOC_TYP_LBL", nullable=false, length=128)
	private String documentTypeLabel;

	@Column(name="DOC_TYP_NM", nullable=false, length=64)
	private String documentTypeName;
	
//	@Column(name="GRP_ID", length=40)
//	private String grpId;	
	
	@ManyToOne
	@JoinColumn(name="GRP_ID")
	private KrimGrpT group;

//	@Column(name="PRNCPL_ID", updatable=false)
//	private String principalId;

	@ManyToOne
	@JoinColumn(name="PRNCPL_ID")
	private KrimPrncplT principal;

//	@Column(name="DOC_HDR_ID", nullable=false, length=40)
//	private String documentId;
	
	@ManyToOne
	@JoinColumn(name="DOC_HDR_ID")
	private KrewDocHdrT document;

	@Column(name="RQST_CD", nullable=false, length=1)
	private String requestCode;

	@Column(name="RQST_LBL", length=255)
	private String requestLabel;
	
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
	
	public Date getCreationDate() {
		return this.creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public String getDocumentUrl() {
		return this.documentUrl;
	}

	public void setDocumentUrl(String documentUrl) {
		this.documentUrl = documentUrl;
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
	
//	public String getGrpId() {
//		return this.grpId;
//	}
//
//	public void setId(String grpId) {
//		this.grpId = grpId;
//	}

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
	
//	public String getDocumentId() {
//		return this.documentId;
//	}
//
//	public void setDocumentId(String documentId) {
//		this.documentId = documentId;
//	}

	public KrewDocHdrT getDocument() {
		return document;
	}

	public void setDocument(KrewDocHdrT document) {
		this.document = document;
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

	public String getRouteLogUrl() {
		return this.routeLogUrl;
	}

	public void setRouteLogUrl(String routeLogUrl) {
		this.routeLogUrl = routeLogUrl;
	}
}