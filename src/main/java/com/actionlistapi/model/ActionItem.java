package com.actionlistapi.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;

/**
 * The persistent class for the KREW_ACTN_ITM_T database table.
 * 
 */
@Entity
@Table(name="KREW_ACTN_ITM_T")
public class ActionItem implements Serializable, Comparable<ActionItem> {
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
	private Group group;

	@Column(name="PRNCPL_ID", updatable=false, insertable=false)
	private String principalId;

	@ManyToOne
	@JoinColumn(name="PRNCPL_ID")
	private Principal requestedOf;

//	@Column(name="DOC_HDR_ID", nullable=false, length=40)
//	private String documentId;
	
	@ManyToOne
	@JoinColumn(name="DOC_HDR_ID")
	private Document document;

	@Column(name="RQST_CD", nullable=false, length=1)
	private String requestCode;

	@Column(name="RQST_LBL", length=255)
	private String requestLabel;
	
	@Transient
	private String routeLogUrl;

	public ActionItem() {
	}

	@Override
	public int compareTo(@NotNull ActionItem o) {
		return o.getCreationDate().compareTo(getCreationDate());
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

	public Group getGroup() {
		return group;
	}

	public void setGroup(Group group) {
		this.group = group;
	}

	public String getPrincipalId() {
		return this.principalId;
	}

	public void setPrincipalId(String principalId) {
		this.principalId = principalId;
	}

	public Principal getRequestedOf() {
		return requestedOf;
	}

	public void setRequestedOf(Principal initiator) {
		this.requestedOf = initiator;
	}
	
//	public String getDocumentId() {
//		return this.documentId;
//	}
//
//	public void setDocumentId(String documentId) {
//		this.documentId = documentId;
//	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
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