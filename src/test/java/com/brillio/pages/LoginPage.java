package com.brillio.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

	public static void enterUsername(WebDriver driver, String username) {
		driver.findElement(By.id("authUser")).sendKeys(username);
	}

	public static void enterPassword(WebDriver driver, String password) {
		driver.findElement(By.id("clearPass")).sendKeys(password);
	}
	
	//selectLanaguageByText()
	
	//clickOnLogin
	
	//GetInvalidErrorMessage()
}
