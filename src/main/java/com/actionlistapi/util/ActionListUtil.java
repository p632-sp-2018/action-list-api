package com.actionlistapi.util;

import com.actionlistapi.model.ActionType;
import com.actionlistapi.model.DocumentStatus;

public final class ActionListUtil {

	public static String getRequestCodeLabel(String requestCode) {
		return ActionType.fromCode(requestCode).getLabel();
	}
	
	public static String getRouteStatusLabel(String routeStatusCode) {
		return DocumentStatus.fromCode(routeStatusCode).getLabel();
	}
	
}
