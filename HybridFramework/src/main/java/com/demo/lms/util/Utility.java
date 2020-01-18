 package com.demo.lms.util;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.lms.TestBase.BaseTest;

public class Utility extends BaseTest{
	
	public static int IMPLICITWAIT=30;
	public static int PAGELOADTIME=30;
	
	
	public void elemenetTobePrsesent(WebElement elements )
	{
		new WebDriverWait(driver, 20).until(ExpectedConditions.visibilityOfAllElements(elements));
		elements.click();
	}
	
	public static void takeScreenshot(String name)
	{
		
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path=System.getProperty("user.dir");
		
		try {
			FileUtils.copyFile(src,new File(path+"/screenshot/"+name+".png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void excelRead()
	{
		
	}
	
	

}
