package com.actionlistapi.datafetcher;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.ActionItem;
import com.actionlistapi.service.ActionItemService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;
import com.actionlistapi.model.ActionItemFilter;

@Component
public class PageActionItemDataFetcher implements DataFetcher<Iterable<ActionItem>>{

	@Autowired
	private ActionItemService actionItemService;
	
	@Override
	public Iterable<ActionItem> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		int offset = (int) arguments.get("offset");
		int limit = (int) arguments.get("limit");
		return actionItemService.findAllPagedActionItems(offset,limit,actionItemService.mapArgumentsToFilterPojo((Map)arguments.get("filter")),actionItemService.mapArgumentsToCustomSortPojo((Map)arguments.get("sort")));
		 
	}
}
