/**
 * TODO
 *
 */
package com.webdriver.qa.automation.ams.pages.registration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.webdriver.qa.automation.framework.page.BasePage;

/**
 * @author bhutton(brianhutton@cinchcast.com)
 * Created on: 15/06/2012
 *
 */
public class ManageRegistrationFormsPage extends BasePage {

  /**
   * Page Header #Text
   */
  @FindBy(css = ".box-header")
  WebElement createHeader;

  /**
   * 
   */
  @FindBy(linkText = "+")
  WebElement new_form;

  /**
   * @param driver
   */
  public ManageRegistrationFormsPage(WebDriver driver) {
    super(driver);
  }

  /**
   * @return
   */
  public boolean validateOnManageRegistrationFormsPage() {
    return getDriver().getTitle().equals("Registration Forms");
  }

}
