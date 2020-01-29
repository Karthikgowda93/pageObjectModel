package com.ka.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.ka.listeners.customlistener;
import com.ka.utilities.ExcelReader;
import com.ka.utilities.ExtentManager;
import com.ka.utilities.Utilities;


import io.github.bonigarcia.wdm.WebDriverManager;

public class page {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(
			System.getProperty("user.dir") + "\\src\\test\\resources\\com\\ka\\excel\\testData.xlsx");
	public static WebDriverWait wait;

	static Date d = new Date();
	//static String fileName = "Extent_" + d.toString().replace(":", "_").replace(" ", "_") + ".html";
	 static String fileName = "Extent.html"; // this is for the extent reports to
	// show in jenkins
	public ExtentReports extent = ExtentManager
			.createInstance(System.getProperty("user.dir") + "\\target\\surefire-reports\\html\\" + fileName);
	public static ExtentTest test;
	public static String browser;
	public static TopMenu menu;

	public page() {

		if (driver == null) {

			try {
				fis = new FileInputStream(System.getProperty("user.dir")
						+ "\\src\\test\\resources\\com\\ka\\properties\\config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\ka\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			if (System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {

				browser = System.getenv("browser");
			} else {
				browser = config.getProperty("browser");
			}
			config.setProperty("browser", browser);
			
			

			if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.chromedriver().setup();

				WebDriverManager.chromedriver().setup();

				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 2);
				prefs.put("credentials_enable_service", false);
				prefs.put("profile.password_manager_enabled", false);

				ChromeOptions options = new ChromeOptions();
				options.setExperimentalOption("prefs", prefs);
				options.addArguments("--disable_extensions");
				options.addArguments("--disable_infobars");
				options.addArguments("--incognito");

				driver = new ChromeDriver(options);

				log.debug("Chrome Launched!!!");

			} else if (config.getProperty("browser").equals("chrome")) {

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();

			} else if (config.getProperty("browser").equals("ie")) {

				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();

			}

			driver.get(config.getProperty("testurl"));
			log.debug("Navigeted to !!!" + config.getProperty("testurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 10);
			
			menu = new TopMenu(driver);

		}
	}
	
	public static void quit() {
		
		driver.quit();
	}
	
	
	public boolean isElementPresent(By by) {

		try {
			driver.findElement(by);
			return true;

		} catch (NoSuchElementException e) {
			return false;
		}

	}
	
	
	public static void click(String locator) {
		
		if(locator.endsWith("_Css")) {
			 
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_Xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		
		log.debug("Clicking on :"+locator);
		customlistener.testReport.get().log(Status.INFO, "Clicked on : " + locator);
		}
	
	public static void type(String locator, String value) {

		if (locator.endsWith("_Css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_Xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		} else if (locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		log.debug("Typing on :"+locator+" with the value as"+value);
		customlistener.testReport.get().log(Status.INFO, "Typing in : "+locator+" the value is "+value);
		//getting nullpointer exception for this line
		// test.log(Status.INFO, "Typing in : "+locator+"the value is"+ value);

	}
	
	static WebElement dropdown;
	public static void select(String locator, String value) {
		
		if(locator.endsWith("_Css")) {
			dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}else if(locator.endsWith("_Xpath")) {
			dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if(locator.endsWith("_id")) {
			dropdown=driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
		log.debug("Selected the : "+ value+"frome the Select "+locator);
		customlistener.testReport.get().log(Status.INFO, "Clicked on :"+locator+" Selected the customer "+value);
	}
	
	
	public static void verifyequals(String expected, String actual) throws IOException  {

		try {
			Assert.assertEquals(expected, actual);
		} catch (Throwable t) {
			
			
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Utilities.captureScreenshot();
			
			Reporter.log("<br>"+"Verification failure : "+t.getMessage()+"<br>");
			Reporter.log("<a> target=\"_blank\" href="+Utilities.screenshotName+"<img height=500 width=400 src="+Utilities.screenshotName+">");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//for extent report
			
			customlistener.testReport.get().log(Status.FAIL, "Verification failed with exception"+t.getMessage());
			//customlistener.testReport.get().log(Status.FAIL, customlistener.testReport.get().addScreenCaptureFromPath(testUtils.screenshotName));
			//ExtentManager.captureScreenshot();
			//Nullpointerexception for this line
			//test.log(Status.FAIL, "Verification failure :"+testUtils.screenshotName );

			

		}

	}

	
		
	}



