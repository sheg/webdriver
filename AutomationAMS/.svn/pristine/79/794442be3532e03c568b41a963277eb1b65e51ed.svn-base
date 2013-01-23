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
 * Java Page Object for the Account Settings Page.<br>
 * This Java class contains all identifiers available to the user in the 
 * Account Settings along with methods to mimic user interaction.<br>
 *
 */
public class AccountSettingsPage extends AmsPage {

  /**
   * Default Constructor
   *
   * @param driver
   */
  public AccountSettingsPage(WebDriver driver) {
    super(driver);
  }

  /**
   * Validates user is in Account Settings by looking at the style attribute
   * on the Accoutn Settings Page<br>
   *
   * @return <code>true</code> if user is in Account Settings Page<br>
   *         <code>false</code> otherwise
   */
  public boolean validateOnAccountSettingsPage() {
    return getDriver().getTitle().equals("Your Account Settings");
  }
}
