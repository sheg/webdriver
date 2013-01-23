package com.webdriver.qa.automation.framework.testcase;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.webdriver.qa.automation.framework.Framework;
import com.webdriver.qa.automation.framework.WebDriverManager;

public abstract class TestCase {

	private static Logger Log = Logger.getRootLogger();
	
	protected static Framework m_framework = null;	
	protected WebDriver driver = null; 
	protected TestConfig m_config = null;
	String testCase = null;

	private void setTestConfig() throws Exception {
		testCase = this.getClass().getSimpleName();
		m_config = m_framework.getTestConfig(testCase);
	}

	@BeforeClass
	public void setup() throws Exception {
		try {
			if(m_framework == null) {
				m_framework = Framework.loadFramework(System.getProperty("configFile"));
			}
			setTestConfig();
			Log.info("*********************");
			Log.info("Starting test case: " + testCase);
			Log.info("Initializing WebDriver - " + m_framework.getBrowserType());
			
			if(m_framework.getExecution().equalsIgnoreCase("local")) {
				WebDriverManager.initLocalWebDriver(m_framework.getBrowserType());				
			}
			else if(m_framework.getExecution().equalsIgnoreCase("sauce")) {
				DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		        capabilities.setCapability("platform", Platform.MAC);
		        capabilities.setCapability("name", this.getClass().getSimpleName());
				WebDriverManager.initRemoteWebDriver(capabilities);
			}
			else
				throw new Exception("Could not resolve the following execution - " + m_framework.getExecution());
			
			driver = WebDriverManager.driver;
			driver.manage().timeouts().implicitlyWait(m_framework.getImplicitWaitTimout(), TimeUnit.SECONDS);
			driver.get(m_framework.getEnvironment().getLocation());
		}
		catch(Exception e) {
			e.printStackTrace();
			teardown();
		}
	}

	@AfterClass
	public void teardown() {
		Log.info("Closing WebDriver");
		driver.quit();
		Log.info("WebDriver closed");
	}
}