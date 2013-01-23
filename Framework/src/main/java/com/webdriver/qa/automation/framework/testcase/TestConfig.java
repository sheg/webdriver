package com.webdriver.qa.automation.framework.testcase;

import java.util.Map;

import com.webdriver.qa.automation.framework.exceptions.InvalidAttributeException;

public class TestConfig {
	public Map<String, String> attributes;

	public Map<String, String> getAttributes() {
		return attributes;
	}

	public void setAttributes(Map<String, String> attributes) {
		this.attributes = attributes;
	}
	
	public String getValue(String attribute) throws InvalidAttributeException {
		String value = this.attributes.get(attribute);
		if(value == null) {
			throw new InvalidAttributeException("Could not locate the following attribute: " + attribute);
		}
		return value;
	}
}
