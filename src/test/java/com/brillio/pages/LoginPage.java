package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private By usernameLocator = By.id("authUser");
	private By passwordLocator = By.id("clearPass");
	private By languageLocator = By.xpath("//select[@name='languageChoice']");
	private By loginLocator = By.cssSelector("#login-button");
	private By ackLicCertLocator = By.partialLinkText("Acknowledgments");
	private By errorLocator = By.xpath("//div[contains(text(),'Invalid')]");
	
	private WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void enterUsername(String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public void enterPassword(String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}

	public void selectLanguageByText( String text) {
		Select selectLan = new Select(driver.findElement(languageLocator));
		selectLan.selectByVisibleText(text);
	}

	public void clickOnLogin() {
		driver.findElement(loginLocator).click();
	}

	public void clickOnAcknowledgmentsLicensingAndCertification() {
		driver.findElement(ackLicCertLocator).click();
	}

	public String getInvalidErrorMessage() {
		return driver.findElement(errorLocator).getText().strip();
	}
}
