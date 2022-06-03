package com.brillio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handle all the menu - openemr dashboard page
public class MainPage {
	
	
	public static void waitForPresenceOfPatientMenu(WebDriver driver)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Patient']")));
	}

	public static String getMainPageTitle(WebDriver driver)
	{
		return  driver.getTitle();
	}
}
