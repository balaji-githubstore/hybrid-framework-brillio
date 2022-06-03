package com.brillio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.brillio.base.WebDriverWrapper;
import com.brillio.pages.LoginPage;
import com.brillio.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"high","login"})
	public void validCredentialTest(String username,String password,String language,String expectedTitle) {
		
		LoginPage.enterUsername(driver, username);
		test.log(Status.INFO, "Enter Username as "+username);
		
		LoginPage.enterPassword(driver, password);
		test.log(Status.INFO, "Enter Password as "+password);
		
		Select selectLan=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(language);
		
		test.log(Status.INFO, "Selected Lanaguage as "+language);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		test.log(Status.INFO, "Clicked on login ");

		String actualTitle = driver.getTitle();
		
		test.log(Status.INFO, "Title is "+actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"low","login"})
	public void invalidCredentialTest(String username,String password,String language,String expectedError)
	{
		LoginPage.enterUsername(driver, username);
		LoginPage.enterPassword(driver, password);

		Select selectLan=new Select(driver.findElement(By.xpath("//select[@name='languageChoice']")));
		selectLan.selectByVisibleText(language);
		
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText().strip();
		Assert.assertEquals(actualError, expectedError);
	}
	
	
}



