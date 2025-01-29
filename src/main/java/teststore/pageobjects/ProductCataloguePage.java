package teststore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductCataloguePage {

	WebDriver driver;
	public ProductCataloguePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".page-footer [href]")
	WebElement centerLogout;
	
	public void successfullLogin()
	{
		System.out.println("Logged in successfully");
	}
}
