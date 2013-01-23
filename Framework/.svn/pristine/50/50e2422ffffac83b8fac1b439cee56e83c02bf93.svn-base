package com.webdriver.qa.automation.framework.traffic;

import java.lang.reflect.Type;
import java.util.Collection;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.server.SeleniumServer;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;

public class TrafficAnalyzer {
	
	private SeleniumServer server = null;
	private Selenium selenium1 = null;
	private WebDriver driver = null;
	private Collection<HTMLRequestFromSelenium> seleniumRequests = null;
	private String trafficOutputJson = null;
	
	public TrafficAnalyzer(WebDriver driver) {
		this.driver = driver;
	}

	private void startServer() throws Exception {
		server = new SeleniumServer();
		server.start();
	}
	private void startSelenium(WebDriver driver) {
		selenium1 = new DefaultSelenium("localhost",4444,"*firefox", driver.getCurrentUrl() + "/");
		selenium1.start("captureNetworkTraffic=true");
		selenium1.open("/");
		selenium1.waitForPageToLoad("100000");		
	}
	public void setSeleniumRequests() {
		try {
			startServer();
			startSelenium(driver);
			trafficOutputJson = selenium1.captureNetworkTraffic("json");
			Gson gson = new Gson();
			Type collectionOfHTMLRequestsType = new TypeToken<Collection<HTMLRequestFromSelenium>>(){}.getType();
			seleniumRequests = gson.fromJson(trafficOutputJson, collectionOfHTMLRequestsType);					
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			if(selenium1 != null) {
				selenium1.close();
				selenium1.stop();
			}
			if(server != null) {
				server.stop();
			}
		}
	}
	
	public String getRequestJson() throws Exception {
		if(trafficOutputJson == null || trafficOutputJson == "") {
			throw new Exception("traffic output has not been set");
		}
		return trafficOutputJson;
	}
	
	public Collection<HTMLRequestFromSelenium> getRequests () {
		return this.seleniumRequests;
	}
}