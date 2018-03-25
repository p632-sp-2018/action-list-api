package com.actionlistapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.actionlistapi.model.ActionItem;
import com.actionlistapi.model.EntityName;
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
		k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));
		k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		
		// Implemented to set the groupUrl in the KrimGrpT / group 
		if(k.getGroup() != null)
			k.getGroup().setGroupUrl(ActionListConstants.GROUP_URL + k.getGroup().getId());
		
		// Implemented to set the personUrl inside KrimPrncplT / initiator
		k.getInitiator().setPersonUrl(ActionListConstants.PERSON_URL + k.getInitiator().getUniversityId());
		//k.getDocument().getInitiator().setPersonUrl(ActionListConstants.PERSON_URL + k.getInitiator().getUniversityId());
		
		// Implemented to set the entity details in KrimPrncplT pojo
		EntityName e = k.getInitiator().getEntity();
		if (e.getDefaultIndicator().equalsIgnoreCase("N") || e.getActiveIndicator().equalsIgnoreCase("N")) {
			k.getInitiator().setDefaultDisplayName(null);
		}
		else {
			k.getInitiator().setDefaultDisplayName(e.getLastName() + ", " + e.getFirstName() + " " + e.getMiddleName());
		}
		
		k.getDocument().setRouteStatusLabel(ActionListUtil.getRouteStatusLabel(k.getDocument().getRouteStatusCode()));

	}
	
	String getAuthenticateUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
	
}
