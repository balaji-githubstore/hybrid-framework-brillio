package com.brillio.test;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.brillio.base.WebDriverWrapper;
import com.brillio.pages.LoginPage;
import com.brillio.pages.MainPage;
import com.brillio.pages.SearchOrAddPatientPage;
import com.brillio.utilities.DataUtils;

public class PatientTest extends WebDriverWrapper {

	@Test(dataProviderClass = DataUtils.class,dataProvider = "commonDataProvider",groups = {"high","patient"})
	public void addPatientTest(String username,String password,String language,String firstname,String lastname,String dob,String gender,String expectedAlert,String expectedValue)
	{
		
		LoginPage login=new LoginPage(driver);
		login.enterUsername(username);
		login.enterPassword( password);
		login.selectLanguageByText(language);
		login.clickOnLogin();
		
		MainPage main=new MainPage(driver);
		main.clickOnPatient();
		main.clickOnNewSearch();
		
		SearchOrAddPatientPage sap=new SearchOrAddPatientPage(driver);
		
		sap.selectPatFrame();
		sap.enterFirstName(firstname);
		
		String actualAlertText=sap.getAlertTextAndHandleIt();
		
		//complete remaining steps 
//		6.	Click on Patient  Click New Search
//		7.	Add the first name, last name
//		8.	Update DOB as today's date driver.findElement(By.id("form_DOB")).sendKeys("2021-12-06");
//		9.	Update the gender
//		10.	Click on the create new patient button above the form
//		11.	Click on confirm create new patient button.
//		12.	Print the text from alert box (if any error before handling alert add 5 sec wait)
//		13.	Handle alert
//		14.	Close the Happy Birthday popup
//		15.	Get the added patient name and assert it
		
		

	}
}
