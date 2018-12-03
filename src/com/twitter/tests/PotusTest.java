package com.twitter.tests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.twitter.ui.DashboardPage;
import com.twitter.ui.LoginPage;
import com.twitter.ui.PotusDashboard;
import com.twitter.utilities.Base;
import com.twitter.utilities.CreateWebDriver;
import com.twitter.utilities.GetData;
import com.twitter.utilities.Utility;

public class PotusTest extends Base 
{

	LoginPage login ;
	DashboardPage dashboard;
	PotusDashboard potus;
	
	@BeforeSuite
	public void clearScreenshots()
	{
		Utility.deleteScreenshotsOptimised();
	}
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		driver = 	CreateWebDriver.instance(browser);
		login = new LoginPage(driver);
		dashboard = new DashboardPage(driver);
		potus = new PotusDashboard(driver);		
	}
	
	
	@Test(description="Test to search POTUS, follow and verify following")
	public void testPotusFollow()
	{
		login.getLoginButton();
		login.waitForPageToLoad();
		login.getLoginButton().click();
		login.getUserNameField().sendKeys(GetData.fromExcel("Data", "loginCredentials", 0, 1));
		login.getPwdField().sendKeys(GetData.fromExcel("Data", "loginCredentials", 1, 1));
		login.getLoginButton2().click();
		dashboard.waitForPageToLoad();
		dashboard.getSearchField().sendKeys(GetData.fromExcel("Data", "testData", 0, 1),Keys.ENTER);
		dashboard.getPOTUS().click();
		potus.waitForPageToLoad();	
		potus.getFollowButton().click();
		
		Assert.assertTrue(potus.getFollowingButton().isDisplayed());
		Assert.assertEquals("Following", potus.getFollowingButton().getText());
		
	}
	
	@AfterMethod
	public void tearDown()
	{
		potus.getFollowingButton().click();
		potus.getLogOutMenu().click();
		potus.waitForMenuToLoad();
		potus.getLogOut().click();
		driver.quit();
		
	}
	
	
	
	

}
