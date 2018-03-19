package com.actionlistapi.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.ActionType;
import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.model.KrimEntityNmT;
import com.actionlistapi.repository.KrewActnItmTRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class KrewActnItmTDataFetcher implements DataFetcher<KrewActnItmT> {

	@Autowired
	private KrewActnItmTRepository krewItmActnListRepository;

	@Override
	public KrewActnItmT get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		KrewActnItmT k = krewItmActnListRepository.findOne((String)arguments.get("id"));
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
		return k;
	}

}
