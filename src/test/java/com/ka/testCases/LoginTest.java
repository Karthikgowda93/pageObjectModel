package com.ka.testCases;

import java.util.Hashtable;


import org.testng.annotations.Test;
import com.ka.pages.Loginpage;
import com.ka.pages.homePage;
import com.ka.utilities.Utilities;

public class LoginTest extends BaseTest{

	@Test(dataProviderClass=Utilities.class,dataProvider="dp")
	public void loginTest(Hashtable<String, String> data) {
		
		System.out.println(">>>>>>>>>>>>>>>>>Excecuting the test cases<<<<<<<<<<<<<<<<");
	
		homePage hp = new homePage();
		Loginpage lp = hp.clickLogin();
		lp.doLogin(data.get("username"), data.get("password"));
		
		//Assert.fail("the Login Test Failed");
		System.out.println(">>>>>>>>>>>>>>>>>test case Excecuted Successfully<<<<<<<<<<<<<<<<");
	}
	
	
}
