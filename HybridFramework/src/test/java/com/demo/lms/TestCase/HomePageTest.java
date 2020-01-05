package com.demo.lms.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.demo.lms.TestBase.BaseTest;
import com.demo.lms.pages.HomePage;

public class HomePageTest extends BaseTest  {
	
	HomePage hm;
	String url="https://www.facebook.com/";
	
	@BeforeMethod
	public void setUp()
	{
		openBrowser();
		hm=new HomePage();
		
	}
	
	@Test(priority = 1) 
	public void fbRegistrationTest() 
	{  
	  hm.fbRegistration();
	  Assert.assertEquals(driver.getCurrentUrl(), url); 
    }
	 
	
	@Test(priority = 2)
	public void countLinkTest()
	{
		hm.countLink();
	}
	
	
	
	@AfterMethod
	public void closeInstance()
	{
		driver.close();
	}
	
}
