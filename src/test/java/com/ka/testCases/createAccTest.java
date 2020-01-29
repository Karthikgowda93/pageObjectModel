package com.ka.testCases;

import java.util.Hashtable;

import org.testng.annotations.Test;

import com.ka.base.page;
import com.ka.pages.zohoAppPage;
import com.ka.pages.crm.accounts.AccountsPage;
import com.ka.pages.crm.accounts.createAccPage;
import com.ka.utilities.Utilities;

public class createAccTest extends BaseTest{
	
	@Test(dataProviderClass=Utilities.class, dataProvider="dp")
	public void CreateAccTest(Hashtable<String, String> data) {
		
		zohoAppPage za = new zohoAppPage();
		za.goToCRM();
		AccountsPage  ap =  page.menu.goToAccounts();
		createAccPage  cap = ap.goToCreateAccPage();
	    cap.CreateAcc(data.get("username"));
	    page.menu.signOut();
		
	}
	
	

}
