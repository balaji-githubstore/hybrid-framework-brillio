package com.brillio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchOrAddPatientPage {
	private static By patFrameLocator=By.xpath("//iframe[@name='pat']");
	private static By firstnameLocator=By.id("form_fname");
	
	
	public static void selectPatFrame(WebDriver driver)
	{
		driver.switchTo().frame(driver.findElement(patFrameLocator));
	}
	
	public static void enterFirstName(WebDriver driver,String firstname)
	{
		driver.findElement(firstnameLocator).sendKeys(firstname);
	}
	
	public static String getAlertTextAndHandleIt(WebDriver driver)
	{
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(50));
		wait.until(ExpectedConditions.alertIsPresent());
		
		String text=driver.switchTo().alert().getText();
		
		driver.switchTo().alert().accept();
		
		return text;
	}
	

}
