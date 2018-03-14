package com.actionlistapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

/**
 * The persistent class for the KRIM_PRNCPL_T database table.
 * 
 */
@Entity
@Table(name="krim_prncpl_t")
@NamedQuery(name="KrimPrncplT.findAll", query="SELECT k FROM KrimPrncplT k")
public class KrimPrncplT implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRNCPL_ID", unique=true, nullable=false, length=40)
	private String id;

	@Column(name="ACTV_IND", length=1)
	private String active;

//	@Column(name="ENTITY_ID", length=40)
//	private String entityId;
	
	@ManyToOne
	@JoinColumn(name="ENTITY_ID")
	private KrimEntityNmT person;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDT_DT")
	private Date lastUpdateDate;

	@Column(name="PRNCPL_NM", nullable=false, length=100)
	private String username;

	public KrimPrncplT() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String prncplId) {
		this.id = prncplId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String actvInd) {
		this.active = actvInd;
	}

//	public String getEntityId() {
//		return this.entityId;
//	}
//
//	public void setEntityId(String entityId) {
//		this.entityId = entityId;
//	}
	
	public KrimEntityNmT getPerson() {
		return person;
	}

	public void setPerson(KrimEntityNmT person) {
		this.person = person;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdtDt) {
		this.lastUpdateDate = lastUpdtDt;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String prncplNm) {
		this.username = prncplNm;
	}
}