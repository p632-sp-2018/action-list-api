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
	
	public static String getRequestCode(String requestCodeLabel) {
		return ActionType.fromLabel(requestCodeLabel).getCode();
	}
	
	public static String getRouteStatusCode(String routeStatusLabel) {
		return DocumentStatus.fromLabel(routeStatusLabel).getCode();
	}
}
