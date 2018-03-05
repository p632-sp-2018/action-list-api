package com.actionlistapi.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.repository.KrewActnItmTRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllKrewActnItmTDataFetcher implements DataFetcher<List<KrewActnItmT>> {
	
	@Autowired
	private KrewActnItmTRepository krewItmActnListRepository; 
	
	@Override
	public List<KrewActnItmT> get(DataFetchingEnvironment env) {
		// TODO Auto-generated method stub
		List<KrewActnItmT> list = (List<KrewActnItmT>) krewItmActnListRepository.findAll();
		for(KrewActnItmT k : list ) {
			k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));
			k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		}
		return list;
	}
	
}
