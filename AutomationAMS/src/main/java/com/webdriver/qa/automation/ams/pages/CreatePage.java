package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.ams.enums.AudioSourceType;
import com.webdriver.qa.automation.framework.page.BasePage;

public class CreatePage extends BasePage {

	public CreatePage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "Container_Title")
	WebElement titleTextField;
	
	@FindBy(css = ".box-header")
	WebElement createHeader;
	
	@FindBy(xpath = "//fieldset[@id='basics-tab']/blockquote[2]/div/label[1]")
	WebElement studioSourceButton;
	
	@FindBy(xpath = "//fieldset[@id='basics-tab']/blockquote[2]/div/label[2]")
	WebElement quickRecordSourceButton;
	
	@FindBy(xpath = "//fieldset[@id='basics-tab']/blockquote[2]/div/label[3]")
	WebElement uploadSourceButton;
	
	@FindBy(css = "[name='file']")
	WebElement fileInput;
	
	public void uploadFile(String path) {
		fileInput.sendKeys(path);
	}
	
	public void selectAudioSource(AudioSourceType audioSource) throws Exception {
		WebElement currentWebelement = null;
		String elementName = null;
		switch(audioSource) {
		case STUDIO:
			studioSourceButton.click();
			currentWebelement = studioSourceButton;
			elementName = "radio_audiomode_webcast"; 
			break;
		case QUICK_RECORD:
			quickRecordSourceButton.click();
			currentWebelement = quickRecordSourceButton;
			elementName = "radio_audiomode_record";
			break;
		case UPLOAD_AUDIO:
			uploadSourceButton.click();
			currentWebelement = uploadSourceButton;
			elementName = "radio_audiomode_upload";
			break;
		}
		if(!currentWebelement.getAttribute("class").equals("checked")) {
			throw new Exception("Could not select the following audio source when creating new content - " + audioSource);
		}
		if(!currentWebelement.getAttribute("for").equals(elementName)) {
			throw new Exception("Did not select: " + elementName + "Currenty selected: " + studioSourceButton.getAttribute("for"));
		}
	}
	
	public void inputContentTitle(String title) {
		titleTextField.sendKeys(title);
	}

  /**
   * Validates user is in Create Page by looking at the style attribute
   * on the Create Page<br>
   *
   * @return <code>true</code> if user is in Create Page<br>
   *         <code>false</code> otherwise
   */
	public boolean validateOnCreatePage() {
		return createHeader.getText().equals("New Content");
	}
}