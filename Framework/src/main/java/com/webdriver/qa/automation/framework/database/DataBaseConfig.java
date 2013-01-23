package com.webdriver.qa.automation.framework.database;

import java.util.HashMap;
import java.util.Map;

public class DataBaseConfig {
	
	private Map<String, String> dataBaseAttributes = new HashMap<String, String>();

	public Map<String,String> getDataBaseConfigAttributes() {
		return this.dataBaseAttributes;
	}
	
	public void setDataBaseConfigAttributes(Map<String,String> dataBaseConfigs) {
		this.dataBaseAttributes = dataBaseConfigs;
	}
}
