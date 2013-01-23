package com.webdriver.qa.automation.ams.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.webdriver.qa.automation.framework.page.BasePage;

public class LoginPage extends BasePage {
		
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "UserName")
	WebElement usernameTextField;
	
	@FindBy(id = "Password")
	WebElement passwordTextField;
	
	@FindBy(css = "[type='submit']")
	WebElement signInButton;
	
	@FindBy(id = "username")
	WebElement usernameDropDown;

	@FindBy(xpath = "//div[@id='login']/form/div/ul/li")
	WebElement error_message;

	@FindBy(xpath = "//div[@id='login']/form/div/span")
	WebElement username_blank_cross;

  @FindBy(xpath = "//div[@id='login']/form/div/span[2]")
  WebElement password_blank_cross;

	public void inputLoginCredentials(String username, String password) {
		usernameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
	}
	
	public DashboardPage clickSignIn() {
		signInButton.click();

		return PageFactory.initElements(getDriver(), DashboardPage.class);
	}

	public boolean hasLoginFailed() {
	  return error_message.getText().equals("The user name or password provided is incorrect.");
	}

	public boolean hasLoginFailedWithBlankUsername() {
	  return username_blank_cross.isDisplayed() &&
	         usernameTextField.getAttribute("class").equals("input-validation-error");
	}

  public boolean hasLoginFailedWithBlankPassword() {
    return password_blank_cross.isDisplayed() &&
           passwordTextField.getAttribute("class").equals("input-validation-error");
  }

  /**
   * Validates user is in Login Page by looking at the style attribute
   * on the Login Page<br>
   *
   * @return <code>true</code> if user is in Login Page<br>
   *         <code>false</code> otherwise
   */
  public boolean validateOnLoginPage() {
    return usernameTextField.isDisplayed() && passwordTextField.isDisplayed();
  }
}