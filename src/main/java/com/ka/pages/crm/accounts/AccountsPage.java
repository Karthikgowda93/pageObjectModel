package com.ka.pages.crm.accounts;

import org.openqa.selenium.By;

import com.ka.base.page;

public class AccountsPage extends page{
	
	
	public createAccPage goToCreateAccPage() {
		
		click("creatAcc_Css");
		return new createAccPage();
	}
	
	public void goToImportAccPage() {
		
		
	}
	
	

}
