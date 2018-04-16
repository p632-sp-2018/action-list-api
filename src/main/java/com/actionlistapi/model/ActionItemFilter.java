package com.actionlistapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionItemFilter {

	private String documentTypeLabel;
	private String routeStatusLabel;
	private String routeStatusCode;
	private String requestLabel;
	private String requestCode;
	public String getRequestCode() {
		return requestCode;
	}

	public void setRequestCode(String requestCode) {
		this.requestCode = requestCode;
	}

	private String userId;
	
	@JsonProperty("documentTypeLabel")
	public String getDocumentTypeLabel() {
		return documentTypeLabel;
	}
	
	public void setDocumentTypeLabel(String documentTypeLabel) {
		this.documentTypeLabel = documentTypeLabel;
	}
	
	@JsonProperty("routeStatusLabel")
	public String getRouteStatusLabel() {
		return routeStatusLabel;
	}
	
	public void setRouteStatusLabel(String routeStatusLabel) {
		this.routeStatusLabel = routeStatusLabel;
	}
	
	@JsonProperty("requestLabel")
	public String getRequestLabel() {
		return requestLabel;
	}
	
	public void setRequestLabel(String requestLabel) {
		this.requestLabel = requestLabel;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getRouteStatusCode() {
		return routeStatusCode;
	}

	public void setRouteStatusCode(String routeStatusCode) {
		this.routeStatusCode = routeStatusCode;
	}

	
}
