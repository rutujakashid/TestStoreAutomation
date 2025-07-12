package teststore.pagetests;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import teststore.basetest.BaseTest;
import teststore.pageobjects.SignInPage;

public class InvalidLoginTest extends BaseTest {

	@DataProvider
	public Object[][] getData() throws IOException
	{

		List<HashMap<String, String>> data = GetJsonDataToHashmap();
		return new Object[][] {{data.get(1)},{data.get(2)},{data.get(3)},{data.get(4)},{data.get(5)},{data.get(6)}};
		
	}
	@Test(dataProvider = "getData")
	public void LoginNegativeTestCase(HashMap<String, String> input)
	{
		SignInPage  signinpage = homepage.goToSignInPage();
		String email = input.get("email");
	    String password = input.get("password");
	    String isValid = input.get("isValid");
	    
	    if(email == "" || email.isEmpty())
	    {
	    	signinpage.logInToProductCatalogue(email, password);
	    	Boolean result = signinpage.isUsernameRequiredValidationTriggered();
	    	Assert.assertTrue(result);
	    	System.out.println("username cannot be blank");
	    	
	    	
	    }
	    else if(password == "" || password.isEmpty())
	    {
	    	signinpage.logInToProductCatalogue(email, password);
	    	Boolean result = signinpage.isPasswordRequiredValidationTriggered();
	    	Assert.assertTrue(result);
	    	System.out.println("password cannot be blank");
	    }
	    else if(email == "" || email.isEmpty() && password == "" || password.isEmpty())
	    {
	    	signinpage.logInToProductCatalogue(email, password);
	    	signinpage.isUsernameRequiredValidationTriggered();
	    	signinpage.isPasswordRequiredValidationTriggered();
	    	System.out.println("username cannot be blank");
	    	System.out.println("password cannot be blank");
	    	
	    }
	    else
	    {
	    	signinpage.logInToProductCatalogue(email, password);
	    	String errorText = signinpage.isErrorMessageDisplayed();
	        Assert.assertEquals(errorText.trim(), "Authentication failed.", "❌ Error message mismatch.");
	    }
		
	}
}
