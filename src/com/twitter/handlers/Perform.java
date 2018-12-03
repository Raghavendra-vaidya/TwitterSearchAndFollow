package com.twitter.handlers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Perform 
{
	static void login(WebDriver driver, String username, String password) 
	{
		driver.findElement(By.xpath("")).sendKeys(username);
		driver.findElement(By.xpath("")).sendKeys(password);
		driver.findElement(By.xpath("")).click();
	}
	
	/*** add similar project specific methods in this class.
	 * Add similar classes to this package***/
}
