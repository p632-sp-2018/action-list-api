package com.actionlistapi.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.KrewActnItmT;
import com.actionlistapi.service.KrewActnItmService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class PageKrewActnItmTDataFetcher implements DataFetcher<Iterable<KrewActnItmT>>{

	@Autowired
	private KrewActnItmService krewActnItmService;
	
	@Override
	public Iterable<KrewActnItmT> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		int offset = (int) arguments.get("offset");
		int limit = (int) arguments.get("limit");
		return krewActnItmService.findAllPagedKrewActnItm(offset,limit);
		 
	}

}
