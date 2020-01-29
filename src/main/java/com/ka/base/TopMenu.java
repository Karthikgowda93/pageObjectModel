package com.ka.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ka.pages.crm.accounts.AccountsPage;

public class TopMenu {

	// Top Menu is encapsulation, since all the pages can access the top menu

	WebDriver driver;

	public TopMenu(WebDriver driver) {

		this.driver = driver;
	}

	public void goToHome() {

	}

	public void goToLeads() {

	}

	public void goToContacts() {

	}

	public AccountsPage goToAccounts() {

		page.click("accMenu_Xpath");
		return new AccountsPage();
	}

	public void goToDeals() {

	}

	public void goToActivities() {

	}

	public void goToReports() {

	}

	public void goToAnalytics() {

	}

	public void goToProducts() {

	}

	public void goToMarketPlace() {

	}

	public void signOut() {

		page.click("profileBtn_Css");
		//WebDriverWait wait = new WebDriverWait(driver, 12);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".black.hovchg.hovchgred.cP"))).click();
		page.click("signOut_Css");
	}

	public void goToSearch() {

	}

	public void goToAddbtn() {

	}

	public void goToSettings() {

	}

}
