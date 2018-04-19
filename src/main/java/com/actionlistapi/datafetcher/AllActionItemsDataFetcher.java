package com.actionlistapi.datafetcher;

import java.util.List;
import java.util.Map;

import com.actionlistapi.model.CustomSort;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.actionlistapi.model.ActionItem;
import com.actionlistapi.service.ActionItemService;

import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import com.actionlistapi.model.ActionItemFilter;

@Component
public class AllActionItemsDataFetcher implements DataFetcher<List<ActionItem>> {
	
	@Autowired
	private ActionItemService actionItemService;
	
	@Override
	public List<ActionItem> get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		return actionItemService.findAllActionItems(actionItemService.mapArgumentsToFilterPojo((Map)arguments.get("filter")), actionItemService.mapArgumentsToCustomSortPojo((Map)arguments.get("sort")));
	}
}
