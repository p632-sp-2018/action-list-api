package com.actionlistapi.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.ActionType;
import com.actionlistapi.model.KrewActnItmT;
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
		return k;
	}

}
