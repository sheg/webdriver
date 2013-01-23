package com.webdriver.qa.automation.framework.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class BtrPage extends BasePage {

	public BtrPage(WebDriver driver) {
		super(driver);
	}

	public void exposeBtrProfileDropdown() {
 		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("return !!window.jQuery('.profiletab .subnav2').css({ visibility: 'visible' });");
		ExpectedConditions.presenceOfElementLocated(By.cssSelector(".subnav2")).apply(getDriver());
	}
}
