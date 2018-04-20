package com.actionlistapi.service;

import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.actionlistapi.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.actionlistapi.repository.ActionItemRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

@Service
public class ActionItemService {

	@Autowired
	private ActionItemRepository actionItemRepository;

	public List<ActionItem> findAllActionItems(ActionItemFilter filter, CustomSort customSort) {
		setFilterDetails(filter);
		ActionSpecification as = new ActionSpecification(filter);
		List<ActionItem> list;
		Sort sort;
		if(customSort.getOrderBy() == null)
			list = (List<ActionItem>) actionItemRepository.findAll(as);
		else {
			System.out.println(customSort.getDirection() + " " + customSort.getOrderBy());
			if ("ASC".equalsIgnoreCase(customSort.getDirection())) {

				sort = new Sort(new Sort.Order(Sort.Direction.ASC, customSort.getOrderBy()));
			}
			else
				sort = new Sort(new Sort.Order(Sort.Direction.DESC, customSort.getOrderBy()));
			    list = (List<ActionItem>) actionItemRepository.findAll(as, sort);
		}
		for(ActionItem k : list ) {
			setActionItem(k);
		}
		return list;
	}

	public Iterable<ActionItem> findAllPagedActionItems(int offset, int limit, ActionItemFilter filter, CustomSort customSort) {
		setFilterDetails(filter);
		ActionSpecification as = new ActionSpecification(filter);
		Iterable<ActionItem> kList;
	    Sort sort;
		if(customSort.getOrderBy() == null)
			kList =  actionItemRepository.findAll(as,new PageRequest(offset,limit));
		else{
			System.out.println(customSort.getDirection() + " " + customSort.getOrderBy());
			if ("ASC".equalsIgnoreCase(customSort.getDirection()))
				sort = new Sort(new Sort.Order(Sort.Direction.ASC, customSort.getOrderBy()));
			else
				sort = new Sort(new Sort.Order(Sort.Direction.DESC, customSort.getOrderBy()));
			kList =  actionItemRepository.findAll(as,new PageRequest(offset,limit,sort));
		}

		for(ActionItem kl : kList ) {
			setActionItem(kl);
		}
		return kList;
	}

	public ActionItem findOneActionItem(String id, ActionItemFilter filter) {
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
	
	// Map the schema filter fields with the POJO of ActionItemFilter fields
	public ActionItemFilter mapArgumentsToFilterPojo (Map arguments) {
		ActionItemFilter filter = new ActionItemFilter();
		filter.setDocumentTypeLabel((String)arguments.get("documentTypeLabel"));
		filter.setRequestLabel((String)arguments.get("requestLabel"));
		filter.setRouteStatusLabel((String)arguments.get("routeStatusLabel"));
		return filter;
	}

	// Map the schema filter fields with the POJO of ActionItemFilter fields
	public CustomSort mapArgumentsToCustomSortPojo (Map arguments) {
		CustomSort customSort = new CustomSort();
		customSort.setDirection((String)arguments.get("direction"));
		customSort.setOrderBy((String)arguments.get("orderBy"));
		return customSort;
	}

	void setFilterDetails(ActionItemFilter filter) {
		filter.setUserId(getAuthenticateUser());
		if(filter.getRequestLabel() != null) {
			filter.setRequestCode(ActionListUtil.getRequestCode(filter.getRequestLabel()));
		}
		if(filter.getRouteStatusLabel() != null) {
			filter.setRouteStatusCode(ActionListUtil.getRouteStatusCode(filter.getRouteStatusLabel()));
		}
	}
	
}
