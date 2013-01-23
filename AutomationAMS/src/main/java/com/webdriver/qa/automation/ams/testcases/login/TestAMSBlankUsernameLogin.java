package com.webdriver.qa.automation.ams.testcases.login;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class TestAMSBlankUsernameLogin extends TestCase {
	
	@Test
	public void tesUsernameBlankLogin() throws Exception {
		String username_blank = m_config.getValue("username");
		String password =  m_config.getValue("password");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputLoginCredentials(username_blank, password);
		DashboardPage dashboardPage = loginPage.clickSignIn();
		Assert.assertFalse(
		    "Log in was successful, but failure was expected.\n" +
		    "Username [" + username_blank + "]\n" +
		    "Password[" + password + "].", dashboardPage.validateLoggedIn(username_blank));
		Assert.assertTrue(
		    "Cannot locate error message when username is blank.",
		    loginPage.hasLoginFailedWithBlankUsername());
	}
}