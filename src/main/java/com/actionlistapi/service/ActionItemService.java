package com.actionlistapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.actionlistapi.model.ActionItem;
import com.actionlistapi.model.EntityName;
import com.actionlistapi.model.Principal;
import com.actionlistapi.repository.ActionItemRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

@Service
public class ActionItemService {

	@Autowired
	private ActionItemRepository actionItemRepository;

	public List<ActionItem> findAllActionItems() {
		List<ActionItem> list = (List<ActionItem>) actionItemRepository.findAllByPrincipalId(getAuthenticateUser());
		for(ActionItem k : list ) {
			setActionItem(k);
		}
		return list;
	}

	public Iterable<ActionItem> findAllPagedActionItems(int offset, int limit) {
		Iterable<ActionItem> kList =  actionItemRepository.findAllByPrincipalId(getAuthenticateUser(),new PageRequest(offset,limit));
		for(ActionItem kl : kList ) {
			setActionItem(kl);
		}
		return kList;
	}

	public ActionItem findOneActionItem(String id) {
		ActionItem k = actionItemRepository.findByIdAndPrincipalId(id, getAuthenticateUser());
		setActionItem(k);
		return k;
	} 
	
	void setActionItem(ActionItem k ) {
//		Implemented to set the Request Label of of ActionItem object
		k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));
		
//		Implemented to set the Route Log URL of of ActionItem object
		k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		
//		Implemented to set the groupUrl in the Group object 
		if(k.getGroup() != null)
			k.getGroup().setGroupUrl(ActionListConstants.GROUP_URL + k.getGroup().getId());
		
//		Implemented to set the routeStatusLabel of the Document object
		k.getDocument().setRouteStatusLabel(ActionListUtil.getRouteStatusLabel(k.getDocument().getRouteStatusCode()));
		
//		Implemented to set the Principal(requestedOf) Details of the ActionItem object
		setPrincipalDetails(k.getRequestedOf());
	
//		Implemented to set the Principal(initiator) Details of the Document object
		setPrincipalDetails(k.getDocument().getInitiator());

	}
	
	String getAuthenticateUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
	
	void setPrincipalDetails(Principal p) {
		p.setPersonUrl(ActionListConstants.PERSON_URL + p.getUniversityId());
		EntityName e = p.getEntity();
		if (e.getDefaultIndicator().equalsIgnoreCase("N") || e.getActiveIndicator().equalsIgnoreCase("N")) {
			p.setDefaultDisplayName(null);
		}
		else {
			p.setDefaultDisplayName(getDefaultName(e));
		}
	}
	
	String getDefaultName(EntityName e) {
		String defaultName;
		
		defaultName = (e.getLastName() != null) ? e.getLastName().trim() + ", " : "";
		defaultName += (e.getFirstName() != null) ? e.getFirstName().trim(): "";
		defaultName += (e.getMiddleName() != null) ? " " + e.getMiddleName().trim() : "";
		
		return defaultName;
	}
	
}
