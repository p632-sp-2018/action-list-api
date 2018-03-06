package com.actionlistapi.model;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;


/**
 * The persistent class for the krim_prncpl_t database table.
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

	@Column(name="ENTITY_ID", length=40)
	private String entityId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="LAST_UPDT_DT")
	private Date lastUpdateDate;

	@Column(name="OBJ_ID", nullable=false, length=36)
	private String objId;

	@Column(name="PRNCPL_NM", nullable=false, length=100)
	private String username;

	@Column(name="PRNCPL_PSWD", length=400)
	private String prncplPswd;

	@Column(name="VER_NBR", nullable=false, precision=10)
	private BigDecimal verNbr;

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

	public String getEntityId() {
		return this.entityId;
	}

	public void setEntityId(String entityId) {
		this.entityId = entityId;
	}

	public Date getLastUpdateDate() {
		return this.lastUpdateDate;
	}

	public void setLastUpdateDate(Date lastUpdtDt) {
		this.lastUpdateDate = lastUpdtDt;
	}

	public String getObjId() {
		return this.objId;
	}

	public void setObjId(String objId) {
		this.objId = objId;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String prncplNm) {
		this.username = prncplNm;
	}

	public String getPrncplPswd() {
		return this.prncplPswd;
	}

	public void setPrncplPswd(String prncplPswd) {
		this.prncplPswd = prncplPswd;
	}

	public BigDecimal getVerNbr() {
		return this.verNbr;
	}

	public void setVerNbr(BigDecimal verNbr) {
		this.verNbr = verNbr;
	}

}