package com.actionlistapi.model;

import javax.xml.bind.annotation.XmlEnumValue;

/**
 * An enumeration representing valid workflow document statuses.
 * 
 * @author Kuali Rice Team (rice.collab@kuali.org)
 *
 */

public enum DocumentStatus {

	@XmlEnumValue("I") INITIATED("I", "Initiated"),
	@XmlEnumValue("S") SAVED("S", "Saved"),
	@XmlEnumValue("R") ENROUTE("R", "Enroute"),
    @XmlEnumValue("E") EXCEPTION("E", "Exception"),
	@XmlEnumValue("P") PROCESSED("P", "Processed"),
	@XmlEnumValue("F") FINAL("F", "Final"),
	@XmlEnumValue("X") CANCELED("X", "Cancelled"),
	@XmlEnumValue("D") DISAPPROVED("D", "Disapproved"),
    /**
     * When invoked, RECALL & CANCEL action will perform the RECALL and set the route status of the document to the new, terminal status of RECALLED
     * @since 2.1
     */
    @XmlEnumValue("L") RECALLED("L", "Recalled");

	private final String code;
    private final String label;

	private DocumentStatus(String code, String label) {
		this.code = code;
        this.label = label;
	}


    

	public String getLabel() {
		return label;
	}
	
	public String getCode() {
		return code;
	}
	

	public static DocumentStatus fromCode(String code) {
		if (code == null) {
			return null;
		}
		for (DocumentStatus status : values()) {
			if (status.code.equals(code)) {
				return status;
			}
		}
		throw new IllegalArgumentException("Failed to locate the DocumentStatus with the given code: " + code);
	}
	
	
	public static DocumentStatus fromLabel(String label) {
        if (label == null) {
            return null;
        }
        for (DocumentStatus status : values()) {
            if (status.label.equals(label)) {
                return status;
            }
        }
        return null;
    }

   
}