package com.brillio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//handle all the menu - openemr dashboard page
public class MainPage {
	private static By patientLocator=By.xpath("//div[text()='Patient']");
	
	public static void waitForPresenceOfPatientMenu(WebDriver driver)
	{
		WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.presenceOfElementLocated(patientLocator));
	}

	public static String getMainPageTitle(WebDriver driver)
	{
		return  driver.getTitle();
	}
	
	public static void clickOnPatient(WebDriver driver)
	{
		driver.findElement(patientLocator).click();
	}
}
