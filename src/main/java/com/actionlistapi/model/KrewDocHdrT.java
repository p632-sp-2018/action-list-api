package com.actionlistapi.model;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the KREW_DOC_HDR_T database table.
 * 
 */
@Entity
@Table(name = "krew_doc_hdr_t")
public class KrewDocHdrT implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "DOC_HDR_ID", unique=true, nullable = false, length = 40)
    private String id;

    @Column(name = "DOC_HDR_STAT_CD", nullable = false, length = 1)
    private String routeStatus;
    
    @Column(name = "APRV_DT", nullable = true)    
    private Date lastApprovedDate;

//  @Column(name = "INITR_PRNCPL_ID", nullable = false, length = 40)
//  private String initrPrncplId;

    @ManyToOne
    @JoinColumn(name = "INITR_PRNCPL_ID")
    private KrimPrncplT initiator;


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRouteStatus() {
        return routeStatus;
    }

    public void setRouteStatus(String routeStatus) {
        this.routeStatus = routeStatus;
    }

    public Date getLastApprovedDate() {
        return lastApprovedDate;
    }

    public void setLastApprovedDate(Date lastApprovedDate) {
        this.lastApprovedDate = lastApprovedDate;
    }

//    public String getInitrPrncplId() {
//        return initrPrncplId;
//    }
//
//    public void setInitrPrncplId(String initrPrncplId) {
//        this.initrPrncplId = initrPrncplId;
//    }
    
    public KrimPrncplT getInitiator() {
		return initiator;
	}

	public void setInitiator(KrimPrncplT initiator) {
		this.initiator = initiator;
	}
}
