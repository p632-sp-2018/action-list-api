package com.actionlistapi.datafetcher;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.repository.KrewActnItmTRepository;
import com.actionlistapi.util.ActionListConstants;
import com.actionlistapi.util.ActionListUtil;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PageKrewActnItmTDataFetcher implements DataFetcher<Iterable<KrewActnItmT>>{

	@Autowired
	private KrewActnItmTRepository krewItmActnListRepository;

	@Override
	public Iterable<KrewActnItmT> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		int offset = (int) arguments.get("offset");
		int limit = (int) arguments.get("limit");
		Iterable<KrewActnItmT> kList =  krewItmActnListRepository.findAll(new PageRequest(offset,limit)); 
		for(KrewActnItmT k : kList ) {
			k.setRequestLabel(ActionListUtil.getRequestCodeLabel(k.getRequestCode()));
			k.setRouteLogUrl(k.getDocumentUrl()+ActionListConstants.ROUTE_LOG_URL);
		}
		return kList; 
	}


}
