package com.ka.utilities;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.DataProvider;

import com.ka.base.page;

public class Utilities extends page {

	public static String screenshotpath;
	public static String screenshotName;

	public static void captureScreenshot() throws IOException {

		File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();

		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(srcFile,
				new File(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName));

	}
	
	
	public static boolean isTestRunnable(String testName, ExcelReader excel ){
		
		String sheetName = "Test_Suite";
		int rows=excel.getRowCount(sheetName);
		
		for(int rNum=2; rNum<=rows;rNum++) {
			
			String testCase = excel.getCellData(sheetName, "TCID", rNum);
			if(testCase.equalsIgnoreCase(testName)) {
				
				String RunMode= excel.getCellData(sheetName, "RunMode", rNum);
				
				if(RunMode.equalsIgnoreCase("Y"))
					return true;
				else
					return false;
			}
			
		}return false;
		
		
	}
	
	
	

	@DataProvider(name="dp")
	public Object[][] getdata(Method m) {

		Object[][] data = null;

		if (m.getName().equals("loginTest")) {
			
			String sheetName = "loginTest";

			// System.out.println(excel.getRowCount(sheetName));
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);

			// Object[][] data = new Object[rows-1][1];
			data = new Object[rows - 1][1];
			Hashtable<String, String> table = null;

			for (int rowNum = 2; rowNum <= rows; rowNum++) {

				table = new Hashtable<String, String>();

				for (int colNum = 0; colNum < cols; colNum++) {

					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));

					data[rowNum-2][0] = table;
				}
			}
		}else if(m.getName().equals("CreateAccTest")) { // have to give the class name here
			
			String sheetName = "createAccTest";

			// System.out.println(excel.getRowCount(sheetName));
			int rows = excel.getRowCount(sheetName);
			int cols = excel.getColumnCount(sheetName);

			// Object[][] data = new Object[rows-1][1];
			data = new Object[rows - 1][1];
			Hashtable<String, String> table = null;

			for (int rowNum = 2; rowNum <= rows; rowNum++) {

				table = new Hashtable<String, String>();

				for (int colNum = 0; colNum < cols; colNum++) {

					table.put(excel.getCellData(sheetName, colNum, 1), excel.getCellData(sheetName, colNum, rowNum));

					data[rowNum - 2][0] = table;
				}
			}
		}

		return data;
	}

}
