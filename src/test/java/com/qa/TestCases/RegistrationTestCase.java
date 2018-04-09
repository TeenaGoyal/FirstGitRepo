package com.qa.TestCases;

import java.io.IOError;
import java.io.IOException;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.qa.TestCases.Excel_Reading;
import com.qa.configuration.CommonUtilities;
import com.qa.AllPages.RegistrationClass;
import com.qa.BaseClass.BaseClass;

public class RegistrationTestCase extends BaseClass
{
	public static RegistrationClass RegObj;
	String sheetName = "a";

	public RegistrationTestCase() throws IOException 
	{
		super();
	}
	
	@BeforeTest
	public static void SetUp() throws InterruptedException
	{
		BrowserSelection();
		RegObj = PageFactory.initElements(driver,RegistrationClass.class);	
	}
	
	@DataProvider
	public Object[][] VarifyExcel_ReadingFile() throws IOException
	{
		Object data[][] = Excel_Reading.File_data(sheetName);
		return data;
	}
	
	@Test(dataProvider ="VarifyExcel_ReadingFile")
	public static void Verifyregistration(String Email,String first_name, String last_name, String password, String add_fn, String Add_ln, String address, String city, String postcode, String MobileNumber) throws InterruptedException, IOException
	{
		RegistrationClass.Registration(Email,first_name,last_name,password,add_fn,Add_ln,address,city,postcode,MobileNumber);
		Thread.sleep(2000);
		RegistrationClass.SignIn();
		//Assert.assertTrue(true);
		
	}
	
	
		
	
}
