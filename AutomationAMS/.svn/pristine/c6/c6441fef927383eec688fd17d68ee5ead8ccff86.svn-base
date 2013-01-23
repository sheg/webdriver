package com.webdriver.qa.automation.ams.testcases.login;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class TestAMSBlankPasswordLogin extends TestCase {
	
	@Test
	public void testPasswordBlankLogin() throws Exception {
		String username = m_config.getValue("username");
		String password_blank =  m_config.getValue("password");

		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		loginPage.inputLoginCredentials(username, password_blank);
		DashboardPage dashboardPage = loginPage.clickSignIn();
		Assert.assertFalse(
		    "Log in was successful, but failure was expected.\n" +
		    "Username [" + username + "]\n" +
		    "Password[" + password_blank + "].", dashboardPage.validateLoggedIn(username));
		Assert.assertTrue(
        "Cannot locate error message when password is blank.",
        loginPage.hasLoginFailedWithBlankPassword());
	}
}