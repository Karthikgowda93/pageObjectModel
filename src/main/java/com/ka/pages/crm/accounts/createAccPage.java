package com.ka.pages.crm.accounts;

import org.openqa.selenium.By;

import com.ka.base.page;

public class createAccPage extends page{

	
	public void CreateAcc(String username) {
		
		
		type("accountName_Css",username);
		
	}
	
	
}
