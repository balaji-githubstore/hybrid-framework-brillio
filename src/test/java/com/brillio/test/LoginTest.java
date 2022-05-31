package com.brillio.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;

public class LoginTest extends WebDriverWrapper {
	
	@Test
	public void validCredentialTest() {
		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.cssSelector("#login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest()
	{
		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.id("clearPass")).sendKeys("john123");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText().strip();
		Assert.assertEquals(actualError, "Invalid username or password");
	}
	
	
}



