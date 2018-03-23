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
@NamedQuery(name="Principal.findAll", query="SELECT k FROM Principal k")
public class Principal implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="PRNCPL_ID", unique=true, nullable=false, length=40)
	private String universityId;

	@Column(name="ACTV_IND", length=1)
	private String active;
	
	@ManyToOne
	@JoinColumn(name="ENTITY_ID")
	private EntityName entity;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDT_DT")
	private Date lastUpdateDate;

	@Column(name="PRNCPL_NM", nullable=false, length=100)
	private String networkId;

	@Transient
	private String defaultDisplayName;
	
	@Transient
	private String personUrl;

	public Principal() {
	}

	public String getUniversityId() {
		return this.universityId;
	}

	public void setUniversityId(String universityId) {
		this.universityId = universityId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String actvInd) {
		this.active = actvInd;
	}

	public EntityName getEntity() {
		return entity;
	}

	public void setEntity(EntityName entity) {
		this.entity = entity;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdtDt) {
		this.lastUpdateDate = lastUpdtDt;
	}

	public String getNetworkId() {
		return this.networkId;
	}

	public void setNetworkId(String networkId) {
		this.networkId = networkId;
	}
	
	public String getDefaultDisplayName() {
		return defaultDisplayName;
	}

	public void setDefaultDisplayName(String defaultDisplayName) {
		this.defaultDisplayName = defaultDisplayName;
	}

	public String getPersonUrl() {
		return personUrl;
	}

	public void setPersonUrl(String personUrl) {
		this.personUrl = personUrl;
	}

}