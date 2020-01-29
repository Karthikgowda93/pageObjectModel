package com.ka.utilities;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ka.base.page;

public class ExtentManager extends page{

	
	private static ExtentReports extent;
	
	
	

    public static ExtentReports createInstance(String fileName) {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(fileName);
       
        
        htmlReporter.config().setTheme(Theme.DARK);
        htmlReporter.config().setDocumentTitle(fileName);
        htmlReporter.config().setEncoding("utf-8");
        htmlReporter.config().setReportName(fileName);
        
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Automation Tester", "Karthik");
        extent.setSystemInfo("Organization", "Essilor");
        extent.setSystemInfo("Build no", "141.2.54");
        extent.setSystemInfo("Project", "Rainbow");
        
        
        return extent;
    }

    // for capturing screenshots enable this method
    public static String screenshotPath;
	public static String screenshotName;
	
	public static void captureScreenshot() throws WebDriverException, SQLException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
		screenshotPath = System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + screenshotName;

		try {
			FileUtils.copyFile(scrFile, new File(screenshotPath));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	
	}


}

	
