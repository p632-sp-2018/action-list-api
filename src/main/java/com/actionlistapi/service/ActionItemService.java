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
		ActionSpecification as = new ActionSpecification(filter);
		Sort sort = setSortOrder(customSort);
		
		List<ActionItem> list;
	    list = (List<ActionItem>) actionItemRepository.findAll(as, sort);
	    
		for(ActionItem k : list ) {
			setActionItem(k);
		}
		return list;
	}

	public Iterable<ActionItem> findAllPagedActionItems(int offset, int limit, ActionItemFilter filter, CustomSort customSort) {
		ActionSpecification as = new ActionSpecification(filter);
		Sort sort = setSortOrder(customSort);
		
		Iterable<ActionItem> kList;
		kList =  actionItemRepository.findAll(as, new PageRequest(offset,limit, sort));
		
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
	
	// Set some of the properties of ActionItem Pojo
	void setActionItem(ActionItem k ) {
		k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));		
		k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		k.getDocument().setRouteStatusLabel(ActionListUtil.getRouteStatusLabel(k.getDocument().getRouteStatusCode()));
		setPrincipalDetails(k.getRequestedOf());
		setPrincipalDetails(k.getDocument().getInitiator());
		
		if(k.getGroup() != null)
			k.getGroup().setGroupUrl(ActionListConstants.GROUP_URL + k.getGroup().getId());
	}
	
	// Get the authenticated user details
	String getAuthenticateUser() {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		return name;
	}
	
	
	void setPrincipalDetails(Principal p) {
		p.setPersonUrl(ActionListConstants.PERSON_URL + p.getUniversityId());
		EntityName e = p.getEntity();
		if (e.getDefaultIndicator().equalsIgnoreCase("Y") && e.getActiveIndicator().equalsIgnoreCase("Y")) {
			p.setDefaultDisplayName(getDefaultName(e));
		}
		else {
			p.setDefaultDisplayName(null);
		}
	}
	
	// Default name of the user to be displayed in the response
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
		if (arguments != null) {
			filter.setDocumentTypeLabel((String)arguments.get("documentTypeLabel"));
			filter.setRequestLabel((String)arguments.get("requestLabel"));
			filter.setRouteStatusLabel((String)arguments.get("routeStatusLabel"));	
		}
		setFilterDetails(filter);
		return filter;
	}
	
	// Set some more fields of the ActionItemFilter
	void setFilterDetails(ActionItemFilter filter) {
		filter.setUserId(getAuthenticateUser());
		if(filter.getRequestLabel() != null) {
			filter.setRequestCode(ActionListUtil.getRequestCode(filter.getRequestLabel()));
		}
		if(filter.getRouteStatusLabel() != null) {
			filter.setRouteStatusCode(ActionListUtil.getRouteStatusCode(filter.getRouteStatusLabel()));
		}
	}

	// Map the schema sort fields with the POJO of CustomSort fields
	public CustomSort mapArgumentsToCustomSortPojo (Map arguments) {
		CustomSort customSort = new CustomSort();
		if (arguments != null) {
			customSort.setDirection((String)arguments.get("direction"));
			customSort.setOrderBy((String)arguments.get("orderBy"));
		}
		return customSort;
	}
	
	// Set the sort direction and the field on which the data is to be sorted 
	private Sort setSortOrder(CustomSort customSort) {
		Sort sort;
		if(customSort.getDirection() != null && customSort.getOrderBy() != null) {
			if ("ASC".equalsIgnoreCase(customSort.getDirection()))
				sort = new Sort(new Sort.Order(Sort.Direction.ASC, customSort.getOrderBy()));
			else
				sort = new Sort(new Sort.Order(Sort.Direction.DESC, customSort.getOrderBy()));
		}
		else {
			// Default: Sorting direction is in ascending order and on creationDate column
			sort = new Sort(new Sort.Order(Sort.Direction.ASC, ActionListConstants.DEFAULT_SORT_FIELD));
		}
		return sort;
	}	
}
