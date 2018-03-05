package com.actionlistapi.util;

import com.actionlistapi.model.ActionType;

public final class ActionListUtil {

	public static String getRequestCodeLabel(String requestCode) {
		return ActionType.fromCode(requestCode).getLabel();
	}
	
}
