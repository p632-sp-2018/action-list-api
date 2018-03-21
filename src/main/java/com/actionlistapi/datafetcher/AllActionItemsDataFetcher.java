package com.actionlistapi.datafetcher;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.ActionItem;
import com.actionlistapi.service.KrewActnItmService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

@Component
public class AllActionItemsDataFetcher implements DataFetcher<List<ActionItem>> {
	
	@Autowired
	private KrewActnItmService krewActnItmService;
	
	@Override
	public List<ActionItem> get(DataFetchingEnvironment env) {
		// TODO Auto-generated method stub
		return krewActnItmService.findAllKrewActionItm();
		
	}
	
}
