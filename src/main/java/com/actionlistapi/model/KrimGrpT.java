package com.actionlistapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the KRIM_GRP_T database table.
 * 
 */
@Entity
@Table(name = "krim_grp_t")
public class KrimGrpT implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "GRP_ID", nullable = false, length = 40)
    private String id;
    
    @Column(name = "GRP_NM", nullable = false, length = 80)
    private String name;
    
    @Column(name = "NMSPC_CD", nullable = false, length = 40)
    private String nameSpace;
    
    @Column(name = "GRP_DESC", nullable = true, length = 4000)
    private String description;
    
    @Column(name = "ACTV_IND", nullable = true, length = 1)
    private String active;
    
    @Column(name = "LAST_UPDT_DT", nullable = true)
    private Date lastUpdateDate;
    

    public KrimGrpT() {
    }
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNameSpace() {
        return nameSpace;
    }

    public void setNameSpace(String nameSpace) {
        this.nameSpace = nameSpace;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }
}