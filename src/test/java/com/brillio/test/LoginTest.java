package com.brillio.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest {

	@Test
	public void validCredentialTest() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demo.openemr.io/b/openemr");

		driver.findElement(By.id("authUser")).sendKeys("admin");
		driver.findElement(By.id("clearPass")).sendKeys("pass");
		driver.findElement(By.cssSelector("#login-button")).click();

		String actualTitle = driver.getTitle();
		Assert.assertEquals(actualTitle, "OpenEMR");
	}
	
	@Test
	public void invalidCredentialTest()
	{
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		driver.get("https://demo.openemr.io/b/openemr");

		driver.findElement(By.id("authUser")).sendKeys("john");
		driver.findElement(By.id("clearPass")).sendKeys("john123");
		driver.findElement(By.cssSelector("#login-button")).click();
		
		String actualError=driver.findElement(By.xpath("//div[contains(text(),'Invalid')]")).getText().strip();
		
		Assert.assertEquals(actualError, "Invalid username or password");
	}
	
	
}



