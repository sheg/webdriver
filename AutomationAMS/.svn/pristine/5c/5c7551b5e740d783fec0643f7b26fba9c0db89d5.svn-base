package com.webdriver.qa.automation.ams.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webdriver.qa.automation.framework.page.AmsPage;

public class SingleArchivePage extends AmsPage {

	public SingleArchivePage(WebDriver driver) {
		super(driver);
	}

	List<WebElement> archivedContents = getDriver().findElements(By.id("content-list-items")); 
	
	@FindBy(css = "#maincontent meta[itemprop='url']")
	WebElement previewPlayerUrl;
	
	@FindBy(id = "tab-content")
	WebElement archivedContentTab;
	
	@FindBy(css = "a.permalink")
	WebElement permalink;
	
	@FindBy(id = "EmbedCode")
	WebElement embedTextArea;
	
	@FindBy(css = ".edit")
	WebElement editButton;
	
	/**
	 * Validates if user is on Archived Content Page
	 *
	 * @return Boolean:
	 * <ul>
	 *  <li><code>true</code> if Upcoming, content and playlist tabs are visible
	 *  <li><code>false</code> otherwise
	 * </ul>
	 * @throws Exception When not in Archived Content Page
	 */
	public boolean validateOnArchivedContentPage() {
		return archivedContentTab.getAttribute("style").isEmpty();
	}

	/**
	 * Click on the n-th item in the Archived content list. Indexed at 0.
	 * 
	 * @param itemInList
	 */
	public void clickOnNthItem(int itemInList) throws Exception {
		WebElement archivedContentElement = archivedContents.get(itemInList);
		if(archivedContentElement == null) {
			throw new Exception("Could not find the " + itemInList + " item in the list. List size = " + archivedContents.size());
		}
		archivedContentElement.click();
		waitForElementPresent(By.id("maincontent"));
	}
	
	/**
	 * 
	 * @return type of player. i.e. ses, sep, eesp etc.
	 */
	public String getPreviewPlayerUrlType() {
		getDriver().switchTo().frame("singleplayer");
		String content = previewPlayerUrl.getAttribute("content");
		getDriver().switchTo().defaultContent(); //switch back!
		return content.split("/") [3];
	}
	
	public String getPermalinkUrlType() {
		String permalinkUrl = permalink.getAttribute("href");
		return permalinkUrl.split("/") [3];
	}
	
	public String getEmbedUrlType() {
		String embedText = embedTextArea.getAttribute("value");
		return embedText.split("/") [3];
	}
	
	/**
	 * Hover over the selected archivedElement and click on the edit page.
	 * 
	 * @param archivedElement the n-th item in the archived list indexed at 0.
	 * @return
	 */
	
	public EditSinglePage goToEditSinglePageViaArchive(int archivedElement) throws Exception {
		Actions action = new Actions(getDriver());
		action.moveToElement(archivedContents.get(archivedElement));
		action.build().perform();
		editButton.click();
		EditSinglePage editPage = PageFactory.initElements(getDriver(), EditSinglePage.class);
		if(!editPage.verifyEditPage()) {
			throw new Exception("Could not navigate to the edit single page by clicking on the edit button");
		}
		return editPage;
	}
}