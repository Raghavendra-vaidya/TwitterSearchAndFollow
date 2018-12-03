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
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='StaticLoggedOutHomePage-cell StaticLoggedOutHomePage-utilityBlock']")));
	}
	
	public WebElement getLoginButton()
	{
		//todo xpathy.
	return	driver.findElement(By.xpath("//div[@class='StaticLoggedOutHomePage-buttons']/a[contains(text(),'Log in')]"));
	}
	
	public WebElement getUserNameField(){
		
		return driver.findElement(By.xpath("//input[@type='text' and @placeholder='Phone, email or username']"));
	}
	
	public WebElement getPwdField(){
		return driver.findElement(By.xpath("//div[@class='clearfix field']/input[@name='session[password]']"));
	}
	public WebElement getLoginButton2(){
		return driver.findElement(By.xpath("//div[@class='clearfix']/button[text()='Log in']"));
		
	}
	

}
