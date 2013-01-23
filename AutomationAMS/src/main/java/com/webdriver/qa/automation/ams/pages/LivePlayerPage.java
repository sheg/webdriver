/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages;

import static junit.framework.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webdriver.qa.automation.ams.enums.PlayerSettings.Autoplay;
import com.webdriver.qa.automation.ams.enums.PlayerSettings.ContentType;
import com.webdriver.qa.automation.ams.enums.PlayerSettings.Size;
import com.webdriver.qa.automation.ams.objects.JWPlayerObject;
import com.webdriver.qa.automation.framework.page.BasePage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 05/06/2012
 *
 * Java Page Object for the Live Player Page.
 * This Java class contains all identifiers available to the user in the 
 * Live Player page along with methods to mimic user interaction.<br>
 */
public class LivePlayerPage extends BasePage {

	/**
	 * Confirmation Message After Settings Saved #TextArea
	 */
	@FindBy(xpath = "//div[@id='configurator']/div[3]/h4")
	WebElement confirmation_message_textArea;

	/**
	 * Close Confirmation Message After Settings Saved #Button
	 */
	@FindBy(xpath = "//div[@id='configurator']/div[3]/a")
	WebElement confirmation_message_close;

	/**
	 * Player Wrapper #Container
	 */
	@FindBy(id = "player-wrapper")
	WebElement player_wrapper;

	/**
	 * Saves Live Player Configuration #Button
	 */
	@FindBy(id = "saveLiveSettings")
	WebElement saveConfig;

	/**
	 * Player Size Settings #Container
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[4]")
	WebElement playerSize_container;

	/**
	 * ContentType Video #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[2]/label")
	WebElement contentType_video;

	/**
	 * ContentType Audio #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[2]/label[2]")
	WebElement contentType_audio;

	/**
	 * Autoplay Off #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[3]/label")
	WebElement autoplay_off;

	/**
	 * Autoplay ON #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[3]/label[2]")
	WebElement autoplay_on;

	/**
	 * Size 400 x 325 #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[4]/label[1]")
	WebElement size_400x325;

	/**
	 * Size 320 x 265 #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[4]/label[2]")
	WebElement size_320x265;

	/**
	 * Size 240 x 205 #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[4]/label[3]")
	WebElement size_240x205;

	/**
	 * Size Custom #RadioButton
	 */
	@FindBy(xpath = "//div[@id='configurator']/div/div[4]/label[4]")
	WebElement size_custom;

	/**
	 * Size Custom Text Field for Height #TextField
	 */
	@FindBy(id = "PlayerConfig_Height")
	WebElement size_custom_height;

	/**
	 * Size Custom Text Field for Width #TextField
	 */
	@FindBy(id = "PlayerConfig_Width")
	WebElement size_custom_width;

	/**
	 * Permalink Page #Link
	 */
	@FindBy(css = "a.permalink")
	WebElement permalinkURL;

	/**
	 * Embeded Code #TextArea
	 */
	@FindBy(id = "LiveEmbedCode")
	WebElement embeddedCode_textArea;

	/**
	 * Close button #Button 
	 */
	@FindBy(css = "a.close")
	WebElement close;

	/**
	 * url meta tag from the player iframe.
	 */
	
	@FindBy(css = "#maincontent meta[itemprop='url']")
	WebElement previewPlayerUrl;


	/**
	 * The JWPlayer object helper
	 */
	private JWPlayerObject jwplayer;

	/**
	 * Default constructor from superclass {@link BasePage}
	 *
	 * @param driver
	 */
	public LivePlayerPage(WebDriver driver) {
		super(driver);
		jwplayer = new JWPlayerObject(driver);
	}

	/**
	 * Changes Content Type for Live Player to Video or Audio
	 *
	 * @param contentType {@link ContentType}
	 * @return {@link LivePlayerPage}
	 */
	public LivePlayerPage changeContentType(ContentType contentType) {
		switch (contentType) {
		case VIDEO:
			contentType_video.click();
			break;
		case AUDIO:
			contentType_audio.click();
			break;
		}
		return this;
	}

	/**
	 * Changes Autoplay to ON or OFF
	 *
	 * @param autoplay {@link Autoplay}
	 * @return {@link LivePlayerPage}
	 */
	public LivePlayerPage changeAutoplay(Autoplay autoplay) {
		switch(autoplay) {
		case ON:
			autoplay_on.click();
			break;
		case OFF:
			autoplay_off.click();
			break;
		}
		return this;
	}

	/**
	 * Changes Size to {@link Size#s400x325}, {@link Size#s320x265}, {@link Size#s240x205}, or {@link Size#CUSTOM}<br>
	 * In case of custom, use height and width to specify the size of the player.
	 *
	 * @param size {@link Size}
	 * @param height height when {@link Size#CUSTOM}
	 * @param width width when {@link Size#CUSTOM}
	 * @return {@link LivePlayerPage}
	 */
	public LivePlayerPage changeSize(Size size, String height, String width) {
		// Size is only changeable when contentType is VIDEO
		if (contentType_video.getAttribute("class").equals("checked")) {
			switch (size) {
			case s400x325:
				size_400x325.click();
				break;
			case s320x265:
				size_320x265.click();
				break;
			case s240x205:
				size_240x205.click();
				break;
			case CUSTOM:
				size_custom.click();
				size_custom_height.clear();
				size_custom_height.sendKeys(height);
				size_custom_width.clear();
				size_custom_width.sendKeys(width);
				break;
			}
		}
		return this;
	}

	/**
	 * Closes the live player window and goes back to Dashboard Page
	 *
	 * @return {@link DashboardPage}
	 */
	public DashboardPage closeLivePlayer() {
		close.click();
		return PageFactory.initElements(getDriver(), DashboardPage.class);
	}

	/**
	 * Saves Live Player with current settings.
	 *
	 * @return {@link LivePlayerPage}
	 * @throws Exception When no changes have been made.
	 */
	public LivePlayerPage saveLivePlayerSettings() throws Exception {
		if(!saveConfig.isDisplayed()) {
			throw new Exception("No changes to the configuration." +
					" Save Button for live player is hidden.");
		}
		saveConfig.click();
		assertEquals("Your Settings Have Been Saved.", confirmation_message_textArea.getText());
		confirmation_message_close.click();
		if (saveConfig.isDisplayed()) {
			throw new Exception("Took too long to save settings or the page hanged after saving.");
		}
		return this;
	}

	/**
	 * Validates if user is on Live Player Page
	 *
	 * @return Boolean:
	 * <ul>
	 *  <li><code>true</code> if Player Wrapper is visible
	 *  <li><code>false</code> otherwise
	 * </ul>
	 * @throws Exception When not in Live Player Page
	 */
	public boolean validateOnLivePlayerPage() {
		if (player_wrapper.isDisplayed()) {
			return true;
		}
		return false;
	}

	/**
	 * Validates Content Type settings after saving Live Player configuration.
	 *
	 * @param type {@link ContentType}
	 * @param autoplay {@link Autoplay}
	 * @param size {@link Size}
	 * @param height height when {@link Size#CUSTOM}
	 * @param width width when {@link Size#CUSTOM}
	 *
	 * @throws Exception When current config does not match expected.
	 */
	public void validateNewSettings(ContentType type, Autoplay autoplay, Size size, String height, String width) throws Exception {
		validateContentType(type);
		validateAutoplay(autoplay);
		// if ContentType is AUDIO, then the size is not shown
		if (type.equals(ContentType.VIDEO)) {
			validateSize(size, height, width);
		}
		validateEmbeddedCode(type, size, height, width);
	}

	/**
	 * Validates the embedded code found in the LivePlayer page.
	 *
	 * @param type {@link ContentType}
	 * @param autoplay {@link Autoplay}
	 * @param size {@link Size}
	 * @param height height when {@link Size#CUSTOM}
	 * @param width width when {@link Size#CUSTOM}
	 */
	private void validateEmbeddedCode(ContentType type, Size size, String height, String width) throws Exception {
		String embeddedCode = embeddedCode_textArea.getAttribute("value");
		String playerWidth;
		String playerHeight;
		switch (size) {
		case AUDIO:
			playerWidth = width;
			playerHeight = "" + size.getHeight();
			break;
		case CUSTOM:
			playerWidth = width;
			playerHeight = height;
			break;
		default:
			playerWidth = "" + size.getWidth();
			playerHeight = "" + size.getHeight();
			break;
		}

		String embeddedCodeWidth = embeddedCode.substring(embeddedCode.indexOf("width=\""), embeddedCode.indexOf("\"", embeddedCode.indexOf("width=\"") + 7) + 1);
		String embeddedCodeHeight = embeddedCode.substring(embeddedCode.indexOf("height=\""), embeddedCode.indexOf("\"", embeddedCode.indexOf("height=\"") + 8) + 1);
		String embeddedCodePermalink = embeddedCode.substring(embeddedCode.indexOf("src=\""), embeddedCode.indexOf("\"", embeddedCode.indexOf("src=\"") + 7) + 1);

		if (!embeddedCode.contains("width=\"" + playerWidth + "\"")) {
			throw new Exception ("Embedded Code has a different WIDTH.\nActual [" + embeddedCodeWidth + "]\nExpected [" + playerWidth + "].");
		}
		if (!embeddedCode.contains("height=\"" + playerHeight + "\"")) {
			throw new Exception ("Embedded Code has a different HEIGHT.\nActual [" + embeddedCodeHeight + "]\nExpected [" + playerHeight + "].");
		}
		if (!embeddedCode.contains("src=\"" + permalinkURL.getAttribute("href"))) {
			throw new Exception ("Embedded Code has a different PERMALINK.\nActual [" + embeddedCodePermalink + "]\nExpected [" + permalinkURL.getAttribute("href") + "].");
		}
	}

	/**
	 * Validates size of Live Player
	 *
	 * @param size {@link Size}
	 * @param height height when {@link Size#CUSTOM}
	 * @param width width when {@link Size#CUSTOM}
	 * @throws Exception
	 */
	private void validateSize(Size size, String height, String width) throws Exception {
		// Validate Size
		switch(size) {
		case s400x325:
			if(!size_400x325.getAttribute("class").equals("checked")) {
				throw new Exception("Size [400x325]: 400x325 is not selected.");
			}
			if(size_320x265.getAttribute("class").equals("checked")) {
				throw new Exception("Size [400x325]: 320x265 is selected.");
			}
			if(size_240x205.getAttribute("class").equals("checked")) {
				throw new Exception("Size [400x325]: 240x205 is selected.");
			}
			if(size_custom.getAttribute("class").equals("checked")) {
				throw new Exception("Size [400x325]: Custom is selected.");
			}
			break;
		case s320x265:
			if(size_400x325.getAttribute("class").equals("checked")) {
				throw new Exception("Size [320x265]: 400x325 is selected.");
			}
			if(!size_320x265.getAttribute("class").equals("checked")) {
				throw new Exception("Size [320x265]: 320x265 is not selected.");
			}
			if(size_240x205.getAttribute("class").equals("checked")) {
				throw new Exception("Size [320x265]: 240x205 is selected.");
			}
			if(size_custom.getAttribute("class").equals("checked")) {
				throw new Exception("Size [320x265]: Custom is selected.");
			}
			break;
		case s240x205:
			if(size_400x325.getAttribute("class").equals("checked")) {
				throw new Exception("Size [240x205]: 400x325 is selected.");
			}
			if(size_320x265.getAttribute("class").equals("checked")) {
				throw new Exception("Size [240x205]: 320x265 is selected.");
			}
			if(!size_240x205.getAttribute("class").equals("checked")) {
				throw new Exception("Size [240x205]: 240x205 is not selected.");
			}
			if(size_custom.getAttribute("class").equals("checked")) {
				throw new Exception("Size [240x205]: Custom is selected.");
			}
			break;
		case CUSTOM:
			if(size_400x325.getAttribute("class").equals("checked")) {
				throw new Exception("Size [custom]: 400x325 is selected.");
			}
			if(size_320x265.getAttribute("class").equals("checked")) {
				throw new Exception("Size [custom]: 320x265 is selected.");
			}
			if(size_240x205.getAttribute("class").equals("checked")) {
				throw new Exception("Size [custom]: 240x205 is selected.");
			}
			if(!size_custom.getAttribute("class").equals("checked")) {
				throw new Exception("Size [custom]: Custom is not selected.");
			}
			String actual_heigth = size_custom_height.getAttribute("value");
			if(!actual_heigth.equals(height)) {
				throw new Exception("Size [custom]: Heigth expected[" + height + "], but got[" + actual_heigth + "].");
			}
			String actual_width = size_custom_width.getAttribute("value");
			if(!actual_width.equals(width)) {
				throw new Exception("Size [custom]: Width expected[" + width + "], but got[" + actual_width + "].");
			}
			break;
		}
	}

	/**
	 * Validates autoplay in Live Player Page
	 * @param autoplay {@link Autoplay}
	 * @throws Exception
	 */
	private void validateAutoplay(Autoplay autoplay) throws Exception {
		// Autoplay is ON
		switch (autoplay) {
		case ON:
			if (!autoplay_on.getAttribute("class").equals("checked")) {
				throw new Exception("Autoplay [ON]: On is not selected");
			}
			if (autoplay_off.getAttribute("class").equals("checked")) {
				throw new Exception("Autoplay [ON]: Off is selected");
			}

			try {
				getDriver().switchTo().frame("mediaplayer");
				jwplayer.assertStatePlaying();
			} finally {
				getDriver().switchTo().defaultContent();
			}
			break;

			// Autoplay is OFF
		case OFF:
			if (autoplay_on.getAttribute("class").equals("checked")) {
				throw new Exception("Autoplay [OFF]: On is selected");
			}
			if (!autoplay_off.getAttribute("class").equals("checked")) {
				throw new Exception("Autoplay [OFF]: Off is not selected");
			}

			try {
				getDriver().switchTo().frame("mediaplayer");
				jwplayer.assertStateIdle();
			} finally {
				getDriver().switchTo().defaultContent();
			}
			break;
		}
	}

	/**
	 * Validates Content Type in Live Player
	 *
	 * @param type {@link ContentType}
	 * @throws Exception
	 */
	private void validateContentType(ContentType type) throws Exception {
		switch (type) {
		// Content Type is Video
		case VIDEO:
			if (!contentType_video.getAttribute("class").equals("checked")) {
				throw new Exception("ContentType [VIDEO]: video button is not selected");
			}
			if (!contentType_audio.getAttribute("class").equals("")) {
				throw new Exception("ContentType [VIDEO]: audio button is selected");
			}
			// In video player, the configuration of the player size is visible
			if (!playerSize_container.getAttribute("class").equals("toggle-wrapper player-size-wrapper")) {
				throw new Exception("ContentType [VIDEO]: Player Size is not visible");
			}
			break;
			// Content Type is Audio
		case AUDIO:
			if (!contentType_video.getAttribute("class").equals("")) {
				throw new Exception("ContentType [AUDIO]: video button is selected");
			}
			if (!contentType_audio.getAttribute("class").equals("checked")) {
				throw new Exception("ContentType [AUDIO]: audio button is not selected");
			}
			// In audio player, the configuration of the video size is hidden
			if (!playerSize_container.getAttribute("class").equals(
					"toggle-wrapper player-size-wrapper hide")) {
				throw new Exception("ContentType [AUDIO]: Player Size is visible");
			}
			break;
		}
	}

	/**
	 * Clicks in the permalink page's link button and redirects user to permalink for Live Player
	 *
	 * @return {@link PermaLinkPage}
	 * @throws Exception 
	 */
	public PermaLinkPage goToPermalinkPage() throws Exception {
		String new_url = permalinkURL.getAttribute("href");
		getDriver().get(new_url);
		PermaLinkPage permalinkPage =  PageFactory.initElements(getDriver(), PermaLinkPage.class);
		return permalinkPage;
	}

	/**
	 * Retrieves width for content player to store the value prior to changing the type from VIDEO to AUDIO
	 *
	 * @return Current width of the player
	 */
	public String retrieveWidth() {
		String embededCode = embeddedCode_textArea.getAttribute("value");
		int widthStartIndex = embededCode.indexOf("width=\"") + 7;
		int widthEndIndex = embededCode.indexOf("\"", widthStartIndex);
		return embededCode.substring(widthStartIndex, widthEndIndex);
	}

	/**
	 * @return <code>TRUE</code> if content type for player is audio,<br><code>FALSE</code> otherwise<br>
	 */
	public boolean isCurrentTypeAudio() {
		return contentType_audio.isSelected();
	}

	/**
	 * Use for changing size of player when content type is AUDIO.
	 */
	public void enableSizeEditing() {
		contentType_video.click();
	}

	/**
	 * Use for changing size of player when content type is AUDIO.
	 */
	public void disableSizeEditing() {
		contentType_audio.click();
	}

	public String getPreviewPlayerUrlType() {
		getDriver().switchTo().frame("mediaplayer");
		String content = previewPlayerUrl.getAttribute("content");
		getDriver().switchTo().defaultContent(); //switch back!
		return content.split("/") [3];
	}

	public String getPermalinkUrlType() {
		String permalinkUrl = permalinkURL.getAttribute("href");
		return permalinkUrl.split("/") [3];
	}

	public String getEmbedUrlType() {
		String embedText = embeddedCode_textArea.getAttribute("value");
		return embedText.split("/") [3];
	}
}