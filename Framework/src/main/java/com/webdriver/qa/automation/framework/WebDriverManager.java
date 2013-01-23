package com.webdriver.qa.automation.framework;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.webdriver.qa.automation.framework.enums.BrowserType;

public class WebDriverManager {
	
	public static WebDriver driver = null;
	
	public static void initLocalWebDriver(BrowserType browserType) throws Exception {
		switch(browserType) {
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
		case GOOGLECHROME:		
			driver = new ChromeDriver();
			break;
		case INTERNETEXPLORER:
			driver = new InternetExplorerDriver();
			break;
		case SAFARI:
			driver = new SafariDriver();
			break;
		case HEADLESS:
			driver = new HtmlUnitDriver(true);
			break;
		default :
			throw new Exception("Could not properly create a webdriver instance - browserType: " + browserType);
		}
	}
	
	public static void initRemoteWebDriver(DesiredCapabilities capabilities) throws MalformedURLException {
        driver = new RemoteWebDriver(
                new URL("http://dforkosh:b49e8094-8876-4a5e-96ea-3c98bf9e8576@ondemand.saucelabs.com:80/wd/hub"),
                capabilities);
	}
}