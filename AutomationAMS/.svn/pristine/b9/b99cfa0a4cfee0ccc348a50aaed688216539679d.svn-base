package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webdriver.qa.automation.framework.page.BasePage;

public class DashboardPage extends BasePage {

  /**
   * User Preferences #Dropdown
   */
  @FindBy(id = "username")
  WebElement usernameDropDown;

  /**
   * Craete new Webcast Quick Access #Button
   */
  @FindBy(id = "button-broadcast")
  WebElement webcastButton;

  /**
   * Create New Playlist Quick Access #Button
   */
  @FindBy(id = "button-playlist")
  WebElement playlistButton;

  /**
   * Opens the Live Player #Button
   */
  @FindBy(id = "button-liveplayer")
  WebElement playerButton;

  /**
   * Opens the manage registration forms page #Option
   */
  @FindBy(linkText = "Manage Registration Forms")
  WebElement manage_registration_forms;

  /**
   * Manage Content #DropDown
   */
  @FindBy(linkText = "Manage")
  WebElement manageDropDown;

  /**
   * Archived Content #Link
   */
  @FindBy(linkText = "Archived Content")
  WebElement archivedContent;

  /**
   * Default constructor
   *
   * @param driver
   */
  public DashboardPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Validates a user is logged in by searching in the user preferences dropdown
   * for the user's email account
   * @param loggedInUsername
   * @return
   */
  public boolean validateLoggedIn(String loggedInUsername) {
    boolean isLoggedIn = false;
    try {
      if(usernameDropDown.getText().equals(loggedInUsername)) {
        isLoggedIn = true;
      }
    } catch (NoSuchElementException e) {
      return false;
    }
    return isLoggedIn;
  }

  /**
   * Clicks on the Create new Webcast Quick Acces Button
   *
   * @return {@link CreatePage}
   * @throws Exception When the validation for being in the create page fails.
   */
  public CreatePage clickNewWebcastButton() throws Exception {
    CreatePage createPage = PageFactory.initElements(getDriver(), CreatePage.class);
    webcastButton.click();
    
    if(!createPage.validateOnCreatePage()) {
      throw new Exception("Could not validate being on the new content page");
    }
    return createPage;
  }

  /**
   * Clicks on the New Playlist Quick Access button
   *
   * @return {@link CreatePlaylistPage}
   * @throws Exception When the validation for being in the playlist page fails.
   */
  public CreatePlaylistPage clickNewPlaylistButton() throws Exception {
    playlistButton.click();

    CreatePlaylistPage playlistPage = PageFactory.initElements(getDriver(), CreatePlaylistPage.class);
    if (!playlistPage.validateOnCreatePlaylistPage()) {
      throw new Exception("Could not validate being on the new playlist page");
    }
    return playlistPage;
  }

  /**
   * Clicks on the Live Player Button
   *
   * @return {@link LivePlayerPage}
   * @throws Exception When the validation for being in the live player page fails.
   */
  public LivePlayerPage clickOnLivePlayer() throws Exception {
    playerButton.click();

    LivePlayerPage livePlayer = PageFactory.initElements(getDriver(), LivePlayerPage.class);
    if (!livePlayer.validateOnLivePlayerPage()) {
      throw new Exception("Could not validate being on the live player page.");
    }
    return livePlayer ;
  }

  /**
   * Validates if user is in Dashboard Page<br>
   * @return <code>true</code> if page has css class dashboard<br>
   *         <code>false</code> otherwise.
   */
  public boolean validateInDashboardPage() {
    try {
      getDriver().findElement(By.className("body.dashboard"));
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }
}