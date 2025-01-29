package teststore.utilities;

import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG 
{
	@BeforeTest
	public static ExtentReports  getReportObject()
	{
	String filepath =System.getProperty("user.dir") + "//AutomationTest//reports.htm";
	ExtentSparkReporter reporter = new ExtentSparkReporter(filepath);
	reporter.config().setReportName("Web Automation Results");
	reporter.config().setDocumentTitle("Test Results");

	// now attach the created report to main class i.e ExtentRports
	ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Rutuja Kashid");
	return extent;

	}
}
