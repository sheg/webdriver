/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages.manage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.framework.page.AmsPage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: Aug 7, 2012
 *<br>
 * Java Page Object for the Upcoming Event Page.<br>
 * This Java class contains all identifiers available to the user in the 
 * Upcoming Event Page along with methods to mimic user interaction.<br>
 *
 */
public class UpcomingEventPage extends AmsPage {

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
  public UpcomingEventPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Validates user is in Upcoming Event tab by looking at the style attribute
   * on the Upcoming Event tab<br>
   *
   * @return <code>true</code> if user is in Upcoming Event tab<br>
   *         <code>false</code> otherwise
   */
  public boolean validateOnUpcomingEventPage() {
    return tab_upcoming.getAttribute("style").isEmpty();
  }

}
