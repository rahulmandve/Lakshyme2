package com.demo.lms.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.demo.lms.TestBase.BaseTest;

public class HomePage extends BaseTest{
	
	
	@FindBy(xpath="//input[@name='firstname']")
	WebElement fname;

	@FindBy(css="input#u_0_o")
	WebElement sname;

	@FindBy(css="input#u_0_r")
	WebElement mobileno;
	
	@FindBy(tagName="a")
	java.util.List<WebElement> countlink;
	
	
	  public HomePage() {
	  
	  PageFactory.initElements(driver,this); 
	  
	  }
	 
	
	public void fbRegistration()
	{
		fname.sendKeys("rahul");
		sname.sendKeys("mandve");
		mobileno.sendKeys("9561877666");
	}
	
	public void countLink()
	{
		
//		return countlink.size();
		
		for(int i=0;i<countlink.size();i++) 
		 {
			  
			  String s=countlink.get(i).getText();
			  System.out.println(s);
			  
		  }
		 
		
		
	}
	
	
}
