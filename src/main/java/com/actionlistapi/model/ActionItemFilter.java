package com.actionlistapi.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ActionItemFilter {
	private String documentTypeLabel;
	private String routeStatusLabel;
	private String requestLabel;
	
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
}
