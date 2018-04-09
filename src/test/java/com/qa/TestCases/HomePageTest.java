package com.qa.TestCases;

import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.AllPages.HomePage;
import com.qa.AllPages.RegistrationClass;
import com.qa.BaseClass.BaseClass;

public class HomePageTest extends BaseClass
{
	public static RegistrationClass RegObj;
	public static HomePage homepage;

	public HomePageTest() throws IOException
	{
		super();
	}
	
	@BeforeMethod
	public static void SetUp() throws InterruptedException, IOException
	{
		BrowserSelection();
		RegObj = PageFactory.initElements(driver,RegistrationClass.class);	
		homepage = PageFactory.initElements(driver,HomePage.class);	
	}
	
	
	@Test(priority=1)
	public static void VarifyAddToCart() throws InterruptedException
	{
		RegistrationClass.SignIn();
		HomePage.AddtoCart();
	}
	
	@AfterTest
	public void TearDown() throws InterruptedException
	{
		driver.quit();
	}
}
