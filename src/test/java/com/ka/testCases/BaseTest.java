package com.ka.testCases;

import org.testng.annotations.AfterSuite;

import com.ka.base.page;

public class BaseTest {

	
	@AfterSuite
	public void teardown() {
		
		page.quit();
	}
	
}
