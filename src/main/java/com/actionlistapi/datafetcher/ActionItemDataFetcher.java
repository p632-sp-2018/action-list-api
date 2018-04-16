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
public class ActionItemDataFetcher implements DataFetcher<ActionItem> {

	@Autowired
	private ActionItemService actionItemService;

	@Override
	public ActionItem get(DataFetchingEnvironment environment) {
		// TODO Auto-generated method stub
		Map arguments = environment.getArguments();
		String id = (String)arguments.get("id");
		return actionItemService.findOneActionItem(id,actionItemService.mapArgumentsToFilterPojo((Map)arguments.get("filter")));
	}

}
