package com.ka.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.ka.base.page;


public class homePage extends page{


	
	
	public void goToCustomers() {
		
		driver.findElement(By.cssSelector(".zh-customers")).click();
	}
	
	
	public void goTOSupport() {
		
		
		
	}
	
	public void goToContactSales() {
		
		
	}
	
	public void doSignUp() {
		
		
	}
	
	
	public Loginpage clickLogin() {
		
		click("loginLink_Css");
		return new Loginpage();
	}
	
	public void goToLanguages() {
		
		Actions action = new Actions(driver);
		
		WebElement ele = driver.findElement(By.xpath("//div[@class='zh-user-account']//span[@class='zgh-localSelect'][contains(text(),'English')]"));
		action.moveToElement(ele).perform();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='zh-user-account']//a[contains(text(),'Nederlands')]"))).click();
		//driver.findElement(By.xpath("(//a[@data-lang='nl'])[1]")).click();

	
	}
	
	
	public void goToLearnmore() {
		
		driver.findElement(By.xpath("a[xpath='1']")).click();
	}
	
	public void validateFooterElements() {
		
		
	}
	
	
}
