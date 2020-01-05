package com.demo.lms.TestBase;
import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.demo.lms.util.Utility;

public class BaseTest {
	
	public static WebDriver driver;
	public static Properties pro;

	public BaseTest(){
		FileInputStream fis;
		try {
		fis=new FileInputStream("F:\\hybrid  framework\\HybridFramework\\src\\main\\java\\com\\demo\\lms\\property\\config.properties");
		pro=new Properties();
		pro.load(fis);
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}

	public void openBrowser(){
	
		String browsername =pro.getProperty("browser");
		
		if(browsername.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\selenium softwares\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			System.setProperty("webdriver.chrome.driver","F:\\selenium softwares\\geckodriver-v0.26.0-win64 (1)\\geckodriver.exe");
			driver=new FirefoxDriver();
		}
		driver.manage().timeouts().pageLoadTimeout(Utility.PAGELOADTIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Utility.IMPLICITWAIT, TimeUnit.SECONDS);
		driver.get((pro.getProperty("url")));
		}
}
