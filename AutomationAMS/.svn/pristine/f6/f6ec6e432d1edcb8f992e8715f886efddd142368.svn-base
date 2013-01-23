package com.webdriver.qa.automation.ams.testcases.login;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class TestAMSSuccessfulChangeLoginPassword extends TestCase {
	
	@Test
	public void testSuccessfulChangePassword() throws Exception {
		String username = m_config.getValue("username");
		String password =  m_config.getValue("password");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputLoginCredentials(username, password);
		DashboardPage dashboardPage = loginPage.clickSignIn();
		Assert.assertTrue("Could not validate logging in - username:pass = " + username + ":" + password, dashboardPage.validateLoggedIn(username));
	}
}