package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginPage {

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(By.id("authUser")).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	
	public static void selectLanguageByText(WebDriver driver,String text)
	{
		Select selectLan=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(text);
	}
	
	public static void clickOnLogin(WebDriver driver)
	{
		driver.findElement(By.cssSelector("#login-button")).click();
	}
	
	public static void clickOnAcknowledgmentsLicensingAndCertification(WebDriver driver)
	{
		driver.findElement(By.partialLinkText("Acknowledgments")).click();
	}
	
	public static String getInvalidErrorMessage(WebDriver driver)
	{
		return driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText().strip();
	}
}
