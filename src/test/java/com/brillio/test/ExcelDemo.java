package com.brillio.test;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDemo {

	public static void main(String[] args) throws IOException {

		FileInputStream file = new FileInputStream("test-data/orange_data.xlsx"); // location

		XSSFWorkbook book = new XSSFWorkbook(file); // open

		XSSFSheet sheet = book.getSheet("invalidCredentialTest");
		
		int rowCount=sheet.getPhysicalNumberOfRows();
		int cellCount=sheet.getRow(0).getPhysicalNumberOfCells();

		DataFormatter format = new DataFormatter();
		
		Object[][] main=new Object[rowCount-1][cellCount];
		

		for(int row=1;row<rowCount;row++)
		{
			for(int cell=0;cell<cellCount;cell++)
			{
				String value = format.formatCellValue(sheet.getRow(row).getCell(cell));
				System.out.println(value);
				main[row-1][cell]=value;
			}	
		}
		
		System.out.println();
	}
}





