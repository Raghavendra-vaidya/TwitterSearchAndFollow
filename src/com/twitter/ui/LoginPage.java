package com.twitter.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twitter.utilities.GetData;

public class LoginPage 
{
	Integer maxTime = Integer.valueOf(GetData.fromProperties("configuration", "maxExplicitTime"));
	WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GetData.fromExcel("Identifiers", "loginpage", 0, 1))));
	}
	
	public WebElement getLoginButton()
	{
		//todo xpathy.
	return	driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "loginpage", 1, 1)));
	}
	
	public WebElement getUserNameField(){
		
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "loginpage", 2, 1)));
	}
	
	public WebElement getPwdField(){
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "loginpage", 3, 1)));
	}
	public WebElement getLoginButton2(){
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "loginpage", 5, 1)));
		
	}
	

}
