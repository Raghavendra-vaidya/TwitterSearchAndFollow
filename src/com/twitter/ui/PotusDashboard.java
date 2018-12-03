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
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='ProfileNav']")));
	}
	
	public WebElement getFollowButton(){
		return driver.findElement(By.xpath("(//span/button/span[text()='Follow'])[1]"));
	}
	public WebElement getFollowingButton(){
		return driver.findElement(By.xpath("(//span/button/span[text()='Following'])[1]"));
	}
	
	public WebElement getLogOutMenu()
	{
		return driver.findElement(By.xpath("//a[@id='user-dropdown-toggle']")); 
	}
	public void waitForMenuToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='js-first-tabstop']/..")));
	}
	public WebElement getLogOut()
	{
		return driver.findElement(By.xpath("//button[text()='Log out']"));
	}
	
	
	
	
}
