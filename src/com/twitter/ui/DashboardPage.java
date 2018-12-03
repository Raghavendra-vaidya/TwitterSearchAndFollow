package com.twitter.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.twitter.utilities.GetData;

public class DashboardPage 
{
	Integer maxTime = Integer.valueOf(GetData.fromProperties("configuration", "maxExplicitTime"));
	WebDriver driver;
	
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void waitForPageToLoad()
	{
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='timeline']")));
	}
	
	public WebElement getSearchField()
	{
		return driver.findElement(By.xpath("//input[@name='q']"));
	}
	
	public void waitForVisibilityOfPotus(){
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//a[contains(text(),'    President Trump')]")));
	}
	
	public WebElement getPOTUS()
	{
		WebElement pot= driver.findElement(By.xpath("//h3[contains(text(),'People')]"));
		((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();",pot );
		
	/*	((JavascriptExecutor)driver).executeScript("window.scroll(0,300)");*/
		
		return driver.findElement(By.xpath("//a[contains(text(),'    President Trump')]"));
	}
	
}
