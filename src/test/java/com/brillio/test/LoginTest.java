package com.brillio.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.brillio.base.WebDriverWrapper;
import com.brillio.pages.LoginPage;
import com.brillio.pages.MainPage;
import com.brillio.utilities.DataUtils;

public class LoginTest extends WebDriverWrapper {
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"high","login"})
	public void validCredentialTest(String username,String password,String language,String expectedTitle) {
		
		LoginPage login=new LoginPage(driver);
		
		login.enterUsername(username);
		test.log(Status.INFO, "Enter Username as "+username);
		
		login.enterPassword( password);
		test.log(Status.INFO, "Enter Password as "+password);
		
		login.selectLanguageByText( language);
		test.log(Status.INFO, "Selected Lanaguage as "+language);
		
		login.clickOnLogin();
		test.log(Status.INFO, "Clicked on login ");
		
		MainPage main=new MainPage(driver);
		main.waitForPresenceOfPatientMenu();

		String actualTitle = main.getMainPageTitle();
		test.log(Status.INFO, "Title is "+actualTitle);
		
		Assert.assertEquals(actualTitle, expectedTitle);
	}
	
	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"low","login"})
	public void invalidCredentialTest(String username,String password,String language,String expectedError)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword( password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		String actualError=login.getInvalidErrorMessage();
		Assert.assertEquals(actualError, expectedError);
	}
	
	
}



