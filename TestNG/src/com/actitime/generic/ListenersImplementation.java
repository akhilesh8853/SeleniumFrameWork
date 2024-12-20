package com.actitime.generic;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

public class ListenersImplementation extends BaseClass  implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}
	
	
	/**
	 * Prints the name of the testcase saying it has been passed
	 */
	@Override
	public void onTestSuccess(ITestResult result) {
		String name = result.getName();
		Reporter.log(name + " Passed", true);
	}
	
	
	/**
	 * takes a screenshot whenever a testScript is failed.
	 */
	@Override
	public void onTestFailure(ITestResult result) {
		String res = result.getName(); // To get the name
		String timestamp = LocalDateTime.now().toString().replace(':', '-'); // To get the time and replace the : since we cannt crete 
		// a file in explorer while having the : in the name
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/"+ res + timestamp +".png");
		
		try {  // we can't use throws declaration in a overridden method, so we handle it using try-catch
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
		}
	}
	
	/**
	 * Prints the name of the testcase saying it has been skipped.
	 */
	@Override
	public void onTestSkipped(ITestResult result) {
		String name = result.getName();
		Reporter.log(name + " has been skipped", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}
	
}
