package com.demo.lms.TestCase;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.demo.lms.TestBase.BaseTest;
import com.demo.lms.pages.HomePage;
import com.demo.lms.util.ScreenShotListner;
import com.demo.lms.util.Utility;

@Listeners(ScreenShotListner.class)
public class HomePageTest extends BaseTest  {
	
	HomePage hm;
	String url="https://www.facebook.com/";
	String sheetname="login";
	
	
	@BeforeMethod
	public void setUp()
	{
		openBrowser();
		hm=new HomePage();
		
	}
	
	@DataProvider
	public Object[][] data(){
		Object data[][]=Utility.excelRead(sheetname);
		return data;
		
	}	
	@Test(priority = 1,dataProvider = "data") 
	public void fbRegistrationTest(String uname,String pass,String mno) 
	{  
	  hm.fbRegistration(uname,pass,mno);
	  Assert.assertEquals(driver.getCurrentUrl(), url); 
	
    }

	/*
	 * @Test(priority = 2) public void countLinkTest() { hm.countLink(); }
	 */
	
	@AfterMethod
	public void closeInstance()
	{
//		driver.close();
	}
	
}
