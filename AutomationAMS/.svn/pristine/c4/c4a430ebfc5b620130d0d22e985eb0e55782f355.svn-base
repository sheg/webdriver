/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.WebDriver;

import com.webdriver.qa.automation.framework.page.AmsPage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: Aug 7, 2012
 *<br>
 * Java Page Object for the Help Page.<br>
 * This Java class contains all identifiers available to the user in the 
 * Help Page along with methods to mimic user interaction.<br>
 *
 */
public class HelpPage extends AmsPage {

  /**
   * Defaul Constructor
   *
   * @param driver
   */
  public HelpPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Validates user is in Help Page by looking at the style attribute
   * on the Help Page<br>
   *
   * @return <code>true</code> if user is in Help Page<br>
   *         <code>false</code> otherwise
   */
  public boolean validateOnHelpPage() {
    return getDriver().getTitle().equals("Cinchcast Connect User Guide");
  }
}
