/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages.manage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.framework.page.AmsPage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 14/06/2012
 *<br>
 * Java Page Object for the Playlist Content Page.<br>
 * This Java class contains all identifiers available to the user in the 
 * Playlist Content Page along with methods to mimic user interaction.<br>
 *
 */
public class PlaylistContentPage extends AmsPage {

  /**
   * Upcoming #Tab
   */
  @FindBy(id = "tab-upcoming")
  WebElement tab_upcoming;

  /**
   * Content #Tab
   */
  @FindBy(id = "tab-content")
  WebElement tab_content;

  /**
   * Playlist #Tab
   */
  @FindBy(id = "tab-playlist")
  WebElement tab_playlist;

  /**
   * Default Constructor
   *
   * @param driver
   */
  public PlaylistContentPage(WebDriver driver) {
    super(driver);
  }

  /**
   * @param title
   */
  public PlaylistContentPage verifyPlaylistHasBeenDeleted(String title) throws Exception{
    long wait_timeout = getImplicitWaitTimout();
    try {
      setImplicitWaitTimout(5 * 1000);
      getDriver().findElement(By.linkText(title));
      throw new Exception("Playlist with title [" + title + "] still present in page");
    } catch (NoSuchElementException e) {
      // Playlist was deleted
    } finally {
      setImplicitWaitTimout(wait_timeout);
    }
    return this;
  }

  /**
   * Validates user is in Playlist Content tab by looking at the style attribute
   * on the playlist content tab<br>
   *
   * @return <code>true</code> if user is in playlist content tab<br>
   *         <code>false</code> otherwise
   */
  public boolean validateOnPlaylistContentPage() {
    return tab_playlist.getAttribute("style").isEmpty();
  }

}
