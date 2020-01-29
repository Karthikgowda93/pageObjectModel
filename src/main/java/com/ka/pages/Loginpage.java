package com.ka.pages;

import org.openqa.selenium.By;

import com.ka.base.page;

public class Loginpage extends page{


		
	public zohoAppPage doLogin(String username, String password) {
		
		type("email_Css", username);
		click("nextBtn_Css");
		type("password_Css", password);
		click("signIn_Xpath");
		return new zohoAppPage();
	}
	
	
	
}
