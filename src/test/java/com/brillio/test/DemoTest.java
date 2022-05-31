package com.brillio.test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DemoTest {
	
	@DataProvider
	public String[][] validData()
	{
		String[][] main=new String[4][2];
		//i->number of test case
		//j->number of arguments 
		
		main[0][0]="john";
		main[0][1]="john123";
		
		main[1][0]="peter";
		main[1][1]="peter123";
		
		main[2][0]="mark";
		main[2][1]="mark123";
		
		main[3][0]="bala";
		main[3][1]="bala12";
		
		return main;
	}

	@Test(dataProvider = "validData")
	public void validTest(String username,String password)
	{
		System.out.println("Valid Test"+username+password);
	}
	
}
