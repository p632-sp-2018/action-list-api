package com.actionlistapi;


import java.util.TimeZone;

public class TimeConfig {

	public TimeConfig() {

		 TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	    
	}
	
	
}

