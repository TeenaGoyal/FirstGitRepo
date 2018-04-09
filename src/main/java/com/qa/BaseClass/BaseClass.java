package com.qa.BaseClass;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass 
{
	public static WebDriver driver = null;
	public static Properties prop;
	
	public BaseClass() throws IOException
	{
		prop = new Properties();
		FileInputStream FIS = new FileInputStream("/home/teena/eclipse-workspace/AutomationPracticeTestCases/src/main/java/com/qa/configuration/config.properties");
		prop.load(FIS);
		
	}
	
	public static void BrowserSelection() throws InterruptedException
	{
		String BrowserName = prop.getProperty("browser");
		
		if (BrowserName.equalsIgnoreCase("chrome"))
		{
			System.out.println("Its GOOGLE CHROME");
			System.setProperty("webdriver.chrome.driver","/home/teena/Documents/chromedriver (2)");
			driver = new ChromeDriver();
		}
			
			else
			{
				System.out.println("Its FIREFOX");
				System.setProperty("webdriver.gecko.driver", "/home/teena/Documents/geckodriver");
			}
		
		Thread.sleep(2000);
		prop.getProperty("url");
		driver.get(prop.getProperty("url"));
		}
	
	}


