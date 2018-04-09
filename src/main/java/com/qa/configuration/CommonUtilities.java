package com.qa.configuration;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.AllPages.HomePage;
import com.qa.BaseClass.BaseClass;
import com.steadystate.css.util.Output;

public class CommonUtilities extends BaseClass
{
	static Wait<WebDriver> wait;
	public static HomePage homepage;
	static Actions action = new Actions(driver);

	public CommonUtilities() throws IOException
	{
		super();
	}
	
	public static void clickWhenReady(WebElement evng_dress, int timeout)
		{
			wait = new WebDriverWait(driver, timeout);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(evng_dress));
			element.click();
		}
		
	public static void SliderMove() throws InterruptedException
	{
		        //Moving Slider to a perticular location
				/*action.click(Slider).build().perform();
				for (int i = 0; i < 1; i++)
				{
				    action.sendKeys(Keys.ARROW_RIGHT).build().perform();
				}*/
		
		        //Moving Slider
				int x=6;
				int width=HomePage.Slider.getSize().getWidth();
			    action.moveToElement(HomePage.Slider, ((width*x)/100), 0).click();
			    action.build().perform();
			    Thread.sleep(2000);
			    System.out.println(width);
	}
	
	public static void Capture_Screenshot(String screenShotNames) throws IOException
	{
		try 
		{
			TakesScreenshot srcShot = (TakesScreenshot)driver; //this will capture the screnshot
			
			File src = srcShot.getScreenshotAs(OutputType.FILE);
			
			FileUtils.copyFile(src, new File("./Screenshots/"+screenShotNames+ ".png"));
			
			System.out.println("successfully taken screenshot");
		} 
		
		catch (WebDriverException e)
		{
			e.printStackTrace();
			
			System.out.println("Exception while taking screenshots");
		}

	}

}
