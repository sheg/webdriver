package com.webdriver.qa.automation.ams.testcases.login;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class TestAMSWrongPasswordLogin extends TestCase {
	
	@Test
	public void testWrongPasswordLogin() throws Exception {
		String username = m_config.getValue("username");
		String password_wrong =  m_config.getValue("password");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputLoginCredentials(username, password_wrong);
		DashboardPage dashboardPage = loginPage.clickSignIn();
		Assert.assertFalse(
		    "Log in was successful, but failure was expected.\n" +
		    "Username [" + username + "]\n" +
		    "Password[" + password_wrong + "].", dashboardPage.validateLoggedIn(username));
		Assert.assertTrue(
		    "Cannot locate error message when credentials are incorrect.",
		    loginPage.hasLoginFailed());
	}
}