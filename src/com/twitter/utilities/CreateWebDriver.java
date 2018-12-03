package com.twitter.utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;

public class CreateWebDriver 
{
	static WebDriver driver;
	static String chromeDriverPath = "./browser-drivers/chromedriver.exe";
	static String ieDriverPath = "./browser-drivers/IEDriverServer.exe";
	static String geckoDriverPath = "./browser-drivers/geckodriver.exe";
	static String url = GetData.fromProperties("configuration", "URL");
	static String timeFromConfig = GetData.fromProperties("configuration", "TimeOut");
	static Integer timout = Integer.valueOf(timeFromConfig); 

	public static WebDriver instance(String browser)
	{
		if(browser.equalsIgnoreCase("ie")){
			System.setProperty("webdriver.ie.driver", ieDriverPath);
			InternetExplorerOptions iops = new InternetExplorerOptions();
			iops.introduceFlakinessByIgnoringSecurityDomains();
			driver = new InternetExplorerDriver(iops);
		}
		else if(browser.equalsIgnoreCase("chrome")){
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			ChromeOptions cho = new ChromeOptions();
			cho.setExperimentalOption("useAutomationExtension", false);
			driver = new ChromeDriver(cho);
		}
		else if (browser.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(timout, TimeUnit.SECONDS);
		return driver;
	}
	
}
