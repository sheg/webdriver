package com.webdriver.qa.automation.ams.testcases.create;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.enums.AudioSourceType;
import com.webdriver.qa.automation.ams.pages.CreatePage;
import com.webdriver.qa.automation.ams.pages.DashboardPage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class CreateUploadAudioContent extends TestCase {
	
	@Test
	public void testCreateUploadAudioContent() throws Exception {
		String username = m_config.getValue("username");
		String password = m_config.getValue("password");
		String contentTitle = m_config.getValue("contentTitle");
		LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
		DashboardPage dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
		
		loginPage.inputLoginCredentials(username, password);
		loginPage.clickSignIn();
		dashboardPage.validateLoggedIn(username);
		CreatePage createPage = dashboardPage.clickNewWebcastButton();
		createPage.validateOnCreatePage();
		createPage.selectAudioSource(AudioSourceType.UPLOAD_AUDIO);
		createPage.inputContentTitle(contentTitle);
		createPage.uploadFile("/Users/danielforkosh/Music/iTunes/iTunes Media/Music/Taylor Swift/Speak Now (Deluxe Edition)/Mine.mp3");
		System.out.println();
	}
}