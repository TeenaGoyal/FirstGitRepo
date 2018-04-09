package com.qa.AllPages;

import java.io.IOException;
import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.qa.BaseClass.BaseClass;
import com.qa.configuration.CommonUtilities;

public class HomePage extends BaseClass
{
	CommonUtilities ul = new CommonUtilities();

	public HomePage() throws IOException 
	{
		super();
	}
	
	@FindBy(xpath = "//a[@title='Women']")
	public static WebElement Women;
	
	@FindBy(xpath = "//div[@id='block_top_menu']/ul/li[1]/ul/li[2]/ul/li[2]/a[@title='Evening Dresses']")
	public static WebElement Evng_dress;
	
	
	
	@FindBy(xpath = "//a[@class='button ajax_add_to_cart_button btn btn-default']")
	public static WebElement Add_cart;
	
	@FindBy(xpath = "html/body/div/div[1]/header/div[3]/div/div/div[4]/div[1]/div[2]/div[4]/a/span")
	public static WebElement checkout;
	
	@FindBy(xpath = "//a[@class='button btn btn-default standard-checkout button-medium']/span")
	public static WebElement checkoutAtmainPage;
	
	@FindBy(xpath = "html/body/div/div[2]/div/div[3]/div/form/p/button")
	public static WebElement checkout3;
	
	@FindBy(xpath = "html/body/div/div[2]/div/div[3]/div/div/form/p/button")
	public static WebElement checkout4;
	
	@FindBy(xpath = "//input[@id='cgv']")
	public static WebElement Terms;
	
	@FindBy(xpath = "//div[@class='ui-slider-range ui-widget-header ui-corner-all']")
	public static WebElement Slider;

	public void HomePage()
	{
		PageFactory.initElements(driver, this);
	}

	public static void AddtoCart() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(Women).build().perform();
	
		//calling commonUtility class for the Wait concept
		CommonUtilities.clickWhenReady(Evng_dress, 10);
		
		//calling SliderMove method from CommonUtilities class
		CommonUtilities.SliderMove();
		

		//Saving the MainWindow
		String mainWindow = driver.getWindowHandle();
		Add_cart.click();	
		
		//Handling Actions in New Window
		for(String winHandle : driver.getWindowHandles())
		{
		    driver.switchTo().window(winHandle);
		    Thread.sleep(2000);
		    checkout.click();	}
		    
		    checkoutAtmainPage.click();
		    
		    //RegistrationClass.SignIn();
			
		    Thread.sleep(1000);
			HomePage.checkout3.click();
			
            Thread.sleep(1000);
            Terms.click();
			HomePage.checkout4.click();
	}
}
	

