package teststore.pageobjects;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage 
{
	WebDriver driver;
	Properties prop;
	@FindBy(css=".user-info .hidden-sm-down")
	WebElement signinBtn;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void gotoHomePage()
	{
		driver.get("https://teststore.automationtesting.co.uk/index.php");
	}
	
	public SignInPage goToSignInPage()
	{
		signinBtn.click();
		SignInPage signinpage = new SignInPage(driver);
		return signinpage;
	}
	

}
