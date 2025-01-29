package teststore.basetest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import teststore.utilities.ExtentReporterNG;


public class Listeners extends BaseTest implements ITestListener  
{
	
	
	ExtentTest test;
	ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	ExtentReports extent = ExtentReporterNG.getReportObject();
	@Override
	public void onTestStart(ITestResult result)
	{
		test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
		 test.log(Status.PASS, "TestCases Passed");
	}
	@Override
	public void onTestFailure(ITestResult result)
	{
		String pathofss = null;
	   
		extentTest.get().fail(result.getThrowable());
		
			try {
				driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchFieldException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		try {
			 pathofss = takeScreenShot(result.getMethod().getMethodName(), driver);
			System.out.println(pathofss);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	
		
		test.addScreenCaptureFromPath(pathofss, result.getMethod().getMethodName());
	}
	@Override
	public void onFinish(ITestContext context)
	{
		extent.flush();   
	}
	
	
	

}

