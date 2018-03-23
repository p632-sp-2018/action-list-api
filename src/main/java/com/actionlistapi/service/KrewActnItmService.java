package com.actionlistapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.model.KrimEntityNmT;
import com.actionlistapi.repository.KrewActnItmTRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

@Service
public class KrewActnItmService {

	@Autowired
	private KrewActnItmTRepository krewItmActnListRepository;

	public List<KrewActnItmT> findAllKrewActionItm() {
		List<KrewActnItmT> list = (List<KrewActnItmT>) krewItmActnListRepository.findAll();
		for(KrewActnItmT k : list ) {
			setKrewActionItm(k);
		}
		return list;
	}

	public Iterable<KrewActnItmT> findAllPagedKrewActnItm(int offset, int limit) {
		Iterable<KrewActnItmT> kList =  krewItmActnListRepository.findAll(new PageRequest(offset,limit)); 
		for(KrewActnItmT kl : kList ) {
			setKrewActionItm(kl);
		}
		return kList;
	}

	public KrewActnItmT findOneKrewActionItm(String id) {
		KrewActnItmT k = krewItmActnListRepository.findOne(id);
		setKrewActionItm(k);
		return k;

	} 
	
	void setKrewActionItm(KrewActnItmT k ) {
		k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));
		k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		
		// Implemented to set the groupUrl in the KrimGrpT / group 
		if(k.getGroup() != null)
			k.getGroup().setGroupUrl(ActionListConstants.GROUP_URL + k.getGroup().getId());
		
		// Implemented to set the personUrl inside KrimPrncplT / initiator
		k.getInitiator().setPersonUrl(ActionListConstants.PERSON_URL + k.getInitiator().getUniversityId());
		//k.getDocument().getInitiator().setPersonUrl(ActionListConstants.PERSON_URL + k.getInitiator().getUniversityId());
		
		// Implemented to set the entity details in KrimPrncplT pojo
		KrimEntityNmT e = k.getInitiator().getEntity();
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
