package com.actionlistapi.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * The persistent class for the KRIM_PRNCPL_T database table.
 * 
 */
@Entity
@Table(name = "krim_entity_nm_t")
public class KrimEntityNmT implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "ENTITY_ID", unique=true, nullable = true, length = 40)
    private String id;
    
	@Column(name = "ENTITY_NM_ID", unique=true, nullable = false, length = 40)	
	private String entityNmId;
    
	@Column(name = "NM_TYP_CD", nullable = true, length = 40)
	private String nameTypeCode;
    
	@Column(name = "FIRST_NM", nullable = true, length = 40)
	private String firstName;
    
	@Column(name = "MIDDLE_NM", nullable = true, length = 40)
	private String middleName;
    
	@Column(name = "LAST_NM", nullable = true, length = 80)
	private String lastName;
    
	@Column(name = "SUFFIX_NM", nullable = true, length = 20)
	private String suffixName;
    
	@Column(name = "PREFIX_NM", nullable = true, length = 20)
	private String prefixName;
    
	@Column(name = "DFLT_IND", nullable = true, length = 1)
	private String defaultIndicator;
    
	@Column(name = "ACTV_IND", nullable = true, length = 1)
	private String activeIndicator;
    
	@Column(name = "LAST_UPDT_DT", nullable = true)
	private Date lastUpdateDate;
    
	@Column(name = "TITLE_NM", nullable = true, length = 20)
	private String titleName;
    
	@Column(name = "NOTE_MSG", nullable = true, length = 1024)
	private String noteMessage;
    
	@Column(name = "NM_CHNG_DT", nullable = true)
	private Date nameChangeDate;
    
	@Transient
	private String defaultName;
	
	@Transient
	private String personURL;


	public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEntityNmId() {
        return entityNmId;
    }

    public void setEntityNmId(String entityNmId) {
        this.entityNmId = entityNmId;
    }
    
    public String getNameTypeCode() {
        return nameTypeCode;
    }

    public void setNameTypeCode(String nameTypeCode) {
        this.nameTypeCode = nameTypeCode;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSuffixName() {
        return suffixName;
    }

    public void setSuffixName(String suffixName) {
        this.suffixName = suffixName;
    }

    public String getPrefixName() {
        return prefixName;
    }

    public void setPrefixName(String prefixName) {
        this.prefixName = prefixName;
    }

    public String getDefaultIndicator() {
        return defaultIndicator;
    }

    public void setDefaultIndicator(String defaultIndicator) {
        this.defaultIndicator = defaultIndicator;
    }

    public String getActiveIndicator() {
        return activeIndicator;
    }

    public void setActiveIndicator(String activeIndicator) {
        this.activeIndicator = activeIndicator;
    }

    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public String getTitleName() {
        return titleName;
    }

    public void setTitleName(String titleName) {
        this.titleName = titleName;
    }

    public String getNoteMessage() {
        return noteMessage;
    }

    public void setNoteMessage(String noteMessage) {
        this.noteMessage = noteMessage;
    }

    public Date getNameChangeDate() {
        return nameChangeDate;
    }

    public void setNameChangeDate(Date nameChangeDate) {
        this.nameChangeDate = nameChangeDate;
    }
       
    public String getDefaultName() {
		return defaultName;
	}

	public void setDefaultName(String defaultName) {
		this.defaultName = defaultName;
	}

	public String getPersonURL() {
		return personURL;
	}

	public void setPersonURL(String personURL) {
		this.personURL = personURL;
	}

}
