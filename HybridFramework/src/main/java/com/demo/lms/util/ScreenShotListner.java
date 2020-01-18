package com.demo.lms.util;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenShotListner implements ITestListener
{

	 public void onTestFailure(ITestResult result)
	 {
		 Utility.takeScreenshot(result.getName());
	 }
}
