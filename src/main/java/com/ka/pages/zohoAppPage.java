package com.ka.pages;

import org.openqa.selenium.By;

import com.ka.base.page;
import com.ka.pages.crm.CRMHomePage;

public class zohoAppPage extends page{

	
	
	public CRMHomePage goToCRM() {
		
		click("crm_Xpath");
		return new CRMHomePage();
	}
	
	
}
