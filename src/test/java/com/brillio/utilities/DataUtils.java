package com.brillio.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataUtils {

	@DataProvider
	public Object[][] invalidCredentialData() throws IOException {
		Object[][] main = ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", "invalidCredentialTest");
		return main;
	}

	@DataProvider
	public Object[][] validCredentialData() throws IOException {
		Object[][] main = ExcelUtils.getSheetIntoTwoDimArray("test-data/orange_data.xlsx", "validCredentialTest");
		return main;
	}

//	@DataProvider
//	public Object[][] validCredentialData()
//	{
//		Object[][] main=new Object[2][4];
//		
//		main[0][0]="admin";
//		main[0][1]="pass";
//		main[0][2]="English (Indian)";
//		main[0][3]="OpenEMR";
//		
//		main[1][0]="physician";
//		main[1][1]="physician";
//		main[1][2]="Dutch";
//		main[1][3]="OpenEMR";
//		
//		return main;
//	}

}
