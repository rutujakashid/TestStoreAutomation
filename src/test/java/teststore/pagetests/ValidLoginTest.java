package teststore.pagetests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import teststore.basetest.BaseTest;
import teststore.basetest.Retry;
import teststore.pageobjects.ProductCataloguePage;
import teststore.pageobjects.SignInPage;
import teststore.utilities.ExtentReporterNG;

public class ValidLoginTest extends BaseTest{


	
	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String, String>> data = GetJsonDataToHashmap();
		return new Object[][] {{data.get(0)}};
		
	}
	
	@Test(dataProvider = "getData")
	public void login(HashMap<String, String> input)  
	{	
		SignInPage  signinpage = homepage.goToSignInPage();
		String email = input.get("email");
	    String password = input.get("password");
	    String isValid = input.get("isValid");
	    
	    ProductCataloguePage productCatalogue = signinpage.logInToProductCatalogue(email, password);
        productCatalogue.successfullLogin(); 
        System.out.println("✅ Valid login successful.");
		
	}
	

}
