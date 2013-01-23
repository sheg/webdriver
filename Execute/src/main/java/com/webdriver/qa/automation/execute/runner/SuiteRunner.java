package com.webdriver.qa.automation.execute.runner;

import java.util.ArrayList;
import java.util.List;

import org.testng.TestListenerAdapter;
import org.testng.TestNG;

public class SuiteRunner {

	public void executeTestNGSuite(String testFile) {
		List<String> testSuites = new ArrayList<String>();
		testSuites.add(testFile);
		TestNG testNG = new TestNG();
		TestListenerAdapter testListener = new CustomTestListener();
		testNG.setTestSuites(testSuites);
		testNG.addListener(testListener);
		testNG.run();
	}
}