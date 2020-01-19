 package com.demo.lms.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.demo.lms.TestBase.BaseTest;

public class Utility extends BaseTest{
	
	public static int IMPLICITWAIT=30;
	public static int PAGELOADTIME=30;
	public static Workbook  book;
	public static Sheet sheet;
	public static String excelPath="F:\\TestData.xlsx";
	
	
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
	
	public static Object[][] excelRead(String sheetname)
	{
		FileInputStream fis=null;
		try {
			
			fis=new FileInputStream(excelPath);
			book=WorkbookFactory.create(fis);
			
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		sheet=book.getSheet(sheetname);
		
		Object data[][]=new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
		
		for(int row=0;row<sheet.getLastRowNum();row++)
		{
			for(int col=0;col<sheet.getRow(0).getLastCellNum();col++)
			{
				data[row][col]=sheet.getRow(row+1).getCell(col).toString();
			}
		}
		
		return data;
	}
	
	

}
