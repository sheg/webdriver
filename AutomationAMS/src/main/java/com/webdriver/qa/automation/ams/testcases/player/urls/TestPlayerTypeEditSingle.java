package com.webdriver.qa.automation.ams.testcases.player.urls;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.webdriver.qa.automation.ams.pages.EditSinglePage;
import com.webdriver.qa.automation.ams.pages.LoginPage;
import com.webdriver.qa.automation.ams.pages.NavBarPageObject;
import com.webdriver.qa.automation.ams.pages.SingleArchivePage;
import com.webdriver.qa.automation.framework.testcase.TestCase;

public class TestPlayerTypeEditSingle extends TestCase {

	@Test
	public void testPlayerTypeEditSingle() throws Exception { 
		LoginPage login = PageFactory.initElements(driver, LoginPage.class);
		login.inputLoginCredentials(m_config.getValue("username"), m_config.getValue("password"));
		login.clickSignIn();

		NavBarPageObject navBar = PageFactory.initElements(driver, NavBarPageObject.class);
		SingleArchivePage singleArchivePage = navBar.goToArchivedContentPage();

		EditSinglePage editPage = singleArchivePage.goToEditSinglePageViaArchive(0);

		Assert.assertEquals(m_config.getValue("previewUrlType"), editPage.getPreviewPlayerUrlType());
		Assert.assertEquals(m_config.getValue("permalinkUrlType"), editPage.getPermalinkUrlType());
		Assert.assertEquals(m_config.getValue("embedUrlType"), editPage.getEmbedUrlType());
						
		navBar.signOut();
	}
}
