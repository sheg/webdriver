package com.webdriver.qa.automation.execute;

import com.webdriver.qa.automation.execute.runner.SuiteRunner;

public class Execute {

	public static void main(String [] args) {
		new SuiteRunner().executeTestNGSuite(args[0]);
	}
}