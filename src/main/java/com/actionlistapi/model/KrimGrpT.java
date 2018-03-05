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
@Table(name = "krim_grp_t", schema = "p565f17_spanchal")
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
    private Timestamp lastUpdtDt;

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
    @Column(name = "OBJ_ID", nullable = false, length = 36)
    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    @Basic
    @Column(name = "VER_NBR", nullable = false, precision = 0)
    public BigDecimal getVerNbr() {
        return verNbr;
    }

    public void setVerNbr(BigDecimal verNbr) {
        this.verNbr = verNbr;
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

//    @Temporal(TemporalType.TIMESTAMP)
    @Basic
    @Column(name = "LAST_UPDT_DT", nullable = true)
    public Timestamp getLastUpdtDt() {
        return lastUpdtDt;
    }

    public void setLastUpdtDt(Timestamp lastUpdtDt) {
        this.lastUpdtDt = lastUpdtDt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KrimGrpT krimGrpT = (KrimGrpT) o;
        return Objects.equals(id, krimGrpT.id) &&
                Objects.equals(objId, krimGrpT.objId) &&
                Objects.equals(verNbr, krimGrpT.verNbr) &&
                Objects.equals(name, krimGrpT.name) &&
                Objects.equals(nameSpace, krimGrpT.nameSpace) &&
                Objects.equals(description, krimGrpT.description) &&
                Objects.equals(kimTypId, krimGrpT.kimTypId) &&
                Objects.equals(active, krimGrpT.active) &&
                Objects.equals(lastUpdtDt, krimGrpT.lastUpdtDt);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, objId, verNbr, name, nameSpace, description, kimTypId, active, lastUpdtDt);
    }
}