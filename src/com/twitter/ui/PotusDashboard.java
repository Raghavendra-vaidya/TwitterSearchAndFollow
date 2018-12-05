package com.twitter.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twitter.utilities.GetData;


public class PotusDashboard {

	Integer maxTime = Integer.valueOf(GetData.fromProperties("configuration", "maxExplicitTime"));
	WebDriver driver;
	
	public PotusDashboard(WebDriver driver){
		this.driver = driver;
	}
	
	public void waitForPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 0, 1))));
	}
	
	public WebElement getFollowButton(){
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 1, 1)));
	}
	public WebElement getFollowingButton(){
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 2, 1)));
	}
	
	public WebElement getLogOutMenu()
	{
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 3, 1))); 
	}
	public void waitForMenuToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 5, 1))));
	}
	public WebElement getLogOut()
	{
		return driver.findElement(By.xpath(GetData.fromExcel("Identifiers", "potusdashboard", 4, 1)));
	}
	
		
}
