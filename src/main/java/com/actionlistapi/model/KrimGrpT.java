package com.actionlistapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * The persistent class for the KRIM_GRP_T database table.
 * 
 */
@Entity
@Table(name = "krim_grp_t")
public class KrimGrpT implements Serializable{
    private static final long serialVersionUID = 1L;

    private String id;
    private String objId;
    private BigDecimal verNbr;
    private String name;
    private String nameSpace;
    private String description;
    private String kimTypId;
    private String active;
    private Timestamp lastUpdateDate;

    public KrimGrpT() {
    }
    
    @Id
    @Column(name = "GRP_ID", nullable = false, length = 40)
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "GRP_NM", nullable = false, length = 80)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "NMSPC_CD", nullable = false, length = 40)
    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    @Basic
    @Column(name = "GRP_DESC", nullable = true, length = 4000)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "KIM_TYP_ID", nullable = false, length = 40)
    public String getKimTypId() {
        return kimTypId;
    }

    public void setKimTypId(String kimTypId) {
        this.kimTypId = kimTypId;
    }

    @Basic
    @Column(name = "ACTV_IND", nullable = true, length = 1)
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    @Basic
    @Column(name = "LAST_UPDT_DT", nullable = true)
    public Timestamp getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Timestamp lastUpdtDt) {
        this.lastUpdateDate = lastUpdtDt;
    }
}