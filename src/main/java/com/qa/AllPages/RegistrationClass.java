package com.qa.AllPages;

import java.io.IOError;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

import com.qa.BaseClass.BaseClass;
import com.qa.TestCases.Excel_Reading;
import com.qa.configuration.CommonUtilities;

public class RegistrationClass extends BaseClass
{

	public RegistrationClass() throws IOException 
	{
		super();
	}
	
	@FindBy(xpath = "//a[@class='login']")
	public static WebElement SignIn;
	
	@FindBy(xpath = "//input[@id = 'email_create']")
	public static WebElement E_mail;
	
	@FindBy(xpath = "//input[@id='customer_firstname']")
	public static WebElement Firstname;
	
	@FindBy(xpath = "//input[@id='customer_lastname']")
	public static WebElement Lastname;
	
	@FindBy(xpath = "//input[@id='passwd']")
	public static WebElement Password;
	
	@FindBy(xpath = "//input[@id='firstname']")
	public static WebElement Add_firstname;
	
	@FindBy(xpath = "//input[@id='lastname']")
	public static WebElement Add_lastname;
	
	@FindBy(xpath = "//input[@id='address1']")
	public static WebElement address1;
	
	/*@FindBy(xpath = "//select[@id='id_state']/option")
	public static WebElement State;*/
	
	@FindBy(id="id_state")
	public static WebElement State;
	
	@FindBy(xpath = "//input[@id='city']")
	public static WebElement City;
	
	@FindBy(xpath = "//input[@id='phone_mobile']")
	public static WebElement MobileNo;
	
	@FindBy(xpath = "//input[@id='postcode']")
	public static WebElement Postcode;
	
	@FindBy(xpath = "//button[@id='submitAccount']")
	public static WebElement submitAccount;
	
	@FindBy(xpath = "//button[@id='SubmitCreate']")
	public static WebElement SubmitCreate;
	
	@FindBy(xpath = "//button[@id='SubmitLogin']")
	public static WebElement SignIN;
	
	@FindBy(xpath = "//input[@id='email']")
	public static WebElement email;
	
	@FindBy(xpath = "//a[@title='My Store']")
	public static WebElement home_logo;

	public void RegistrationClass()
	{
		PageFactory.initElements(driver,this);
	}
	
	
	public static void Registration(String Email,String first_name, String last_name, String password, String add_fn, String Add_ln, String address, String city, String postcode, String MobileNumber) throws InterruptedException, IOException
	{
		E_mail.sendKeys(Email);
		SubmitCreate.click();
		Thread.sleep(2000);
		CommonUtilities.Capture_Screenshot("EmailEntered");
		
		for(int i=0;i<Excel_Reading.File_data("a").length;i++)
		{
		Firstname.sendKeys(first_name);
		Lastname.sendKeys(last_name);
		Password.sendKeys(password);
		Add_firstname.sendKeys(add_fn);
		Add_lastname.sendKeys(Add_ln);
		address1.sendKeys(address);
		
		Select sel = new Select(State);
		System.out.println(State.getText());
		List<WebElement> list = sel.getOptions();
		sel.selectByIndex(4);
		
		Thread.sleep(2000);
		City.sendKeys(city);
		
		//Parcing value of postcode from String to int
		String s1 = String.valueOf(postcode);    
		s1 =(int)Double.parseDouble(s1) + "";
		Postcode.sendKeys(s1);
		
		MobileNo.sendKeys(MobileNumber);
		submitAccount.click();
		
		driver.navigate().back();
		//Boolean logo = home_logo.isDisplayed();		
	}}
	
	
	public static void SignIn()
	{
		email.sendKeys(prop.getProperty("email"));
		Password.sendKeys(prop.getProperty("password"));
		SignIN.click();
	}
	
	@AfterTest
	public void TearDown()
	{
		driver.quit();
	}

}
