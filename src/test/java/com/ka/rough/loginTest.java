package com.ka.rough;


import com.ka.pages.Loginpage;
import com.ka.pages.homePage;
import com.ka.pages.zohoAppPage;
import com.ka.pages.crm.accounts.AccountsPage;
import com.ka.pages.crm.accounts.createAccPage;

public class loginTest {

	
	
	public static void main(String[] args) {
		
		
		homePage page= new homePage();
		Loginpage lp = page.clickLogin();
		zohoAppPage za = lp.doLogin("karthikbdvt6@gmail.com", "Anusuya@63");
		//System.out.println("login Successful");
		za.goToCRM();
		AccountsPage  ap =  page.menu.goToAccounts();
		createAccPage  cap = ap.goToCreateAccPage();
	     cap.CreateAcc("Karthik");
	     page.menu.signOut();
	     //page.menu.signOut();
		
		//driver.quit();
		
	}
	
	
}
