package com.twitter.utilities;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
public class Utility 
{
	public static void deleteScreenshotsOptimised() 
	{
		File parentFolder = new File("./screenshots/");
		if(parentFolder.exists() && parentFolder.list().length > 0) 
		{
			String []names = parentFolder.list();
			for(String name: names) 
			{
				FileUtils.deleteQuietly(new File("./screenshots/"+name));
			}
			
			//cleanDirectory method deletes folder contents
		}
		else 
		{
			return;
		}
	}

/*---------------------------*/

	public static void captureScreenshot(WebDriver driver,ITestResult result )
		{
	 
			try 
				{
				TakesScreenshot ts=(TakesScreenshot)driver;	 
				File source=ts.getScreenshotAs(OutputType.FILE);
				String method_name = result.getName();
				String PackageName = result.getInstanceName();
				String[] names = PackageName.split(Pattern.quote("."));
				String classname = names[names.length-1];
				File folder = new File("./screenshots/"+classname+"/");
				File destn = new File("./screenshots/"+classname+"/"+method_name+".jpg");
				
				if(!folder.exists())
				{
					folder.mkdir();
					Files.copy(source.toPath(), destn.toPath(), StandardCopyOption.REPLACE_EXISTING);	
					/*FileUtils.copyFile(source, new File("./screenshots/"+classname+"/"+method_name+".jpg"));*/	
				}
				else if (folder.exists() && !destn.exists() ) 
				{
					Files.copy(source.toPath(), destn.toPath(), StandardCopyOption.REPLACE_EXISTING);
				}
	
				else
				{
					return;
				}

			}
			catch(Exception e){
				e.printStackTrace();
			}

}}
