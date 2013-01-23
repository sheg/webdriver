package com.webdriver.qa.automation.ams.testcases.player.urls;

import junit.framework.Assert;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LivePlayerPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.ams.pages.NavBarPageObject;
import com.webdriver.qa.automation.framework.testcase.TestCase;

/**
 * Asserts that on the live player modal:
 * 1) The embed player is a eel
 * 2) Permalink player is eel
 * 3) Preview player is eel
 * 
 * @throws Exception
 */

public class TestPlayerTypeLiveModal extends TestCase {
	
	@Test
	public void testPlayerTypeLiveModal() throws Exception {

	    LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
	    loginPage.inputLoginCredentials(m_config.getValue("username"), m_config.getValue("password"));
	    DashboardPage dashboardPage = loginPage.clickSignIn();

	    dashboardPage.validateLoggedIn(m_config.getValue("username"));
	    LivePlayerPage livePlayer = dashboardPage.clickOnLivePlayer();
		
		Assert.assertEquals(m_config.getValue("previewUrlType"), livePlayer.getPreviewPlayerUrlType());
		Assert.assertEquals(m_config.getValue("permalinkUrlType"), livePlayer.getPermalinkUrlType());
		Assert.assertEquals(m_config.getValue("embedUrlType"), livePlayer.getEmbedUrlType());
		
		livePlayer.closeLivePlayer();
		PageFactory.initElements(driver, NavBarPageObject.class).signOut();
	}
}
