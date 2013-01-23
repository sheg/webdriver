package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.framework.page.AmsPage;

public class EditSinglePage extends AmsPage{

	public EditSinglePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "#maincontent meta[itemprop='url']")
	WebElement previewPlayerUrl;
	
	@FindBy(css = "a.permalink")
	WebElement permalink;
	
	@FindBy(id = "EmbedCode")
	WebElement embedTextArea;
	
	public boolean verifyEditPage() {
		return getDriver().getCurrentUrl().contains("edit");
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
}
