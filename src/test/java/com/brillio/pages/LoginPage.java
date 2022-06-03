package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {
	private static By usernameLocator=By.id("authUser");
	private static By passwordLocator=By.id("clearPass");
	private static By languageLocator=By.xpath("//select[@name='languageChoice']");
	private static By loginLocator=By.cssSelector("#login-button");
	private static By ackLicCertLocator=By.partialLinkText("Acknowledgments");
	private static By errorLocator=By.xpath("//div[contains(text(),'Invalid')]");
	
	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(usernameLocator).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(passwordLocator).sendKeys(password);
	}
	
	public static void selectLanguageByText(WebDriver driver,String text)
	{
		Select selectLan=new Select(driver.findElement(languageLocator));
		selectLan.selectByVisibleText(text);
	}
	
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(loginLocator).click();
	}
	
	public static void clickOnAcknowledgmentsLicensingAndCertification(WebDriver driver)
	{
		driver.findElement(ackLicCertLocator).click();
	}
	
	public static String getInvalidErrorMessage(WebDriver driver)
	{
		return driver.findElement(errorLocator).getText().strip();
	}
}
