package com.brillio.utilities;

import org.testng.annotations.DataProvider;

public class DataUtils {
	
	@DataProvider
	public Object[][] invalidCredentialData()
	{
		Object[][] main=new Object[3][4];
		
		main[0][0]="John";
		main[0][1]="Johb123";
		main[0][2]="English (Indian)";
		main[0][3]="Invalid username or password";
		
		main[1][0]="Peter";
		main[1][1]="Peter123";
		main[1][2]="Dutch";
		main[1][3]="Invalid username or password";
		
		main[2][0]="Mark";
		main[2][1]="Mark123";
		main[2][2]="Dutch";
		main[2][3]="Invalid username or password";

		return main;
	}
	
	
	@DataProvider
	public Object[][] validCredentialData()
	{
		Object[][] main=new Object[2][4];
		
		main[0][0]="admin";
		main[0][1]="pass";
		main[0][2]="English (Indian)";
		main[0][3]="OpenEMR";
		
		main[1][0]="physician";
		main[1][1]="physician";
		main[1][2]="Dutch";
		main[1][3]="OpenEMR";
		
		return main;
	}

}
