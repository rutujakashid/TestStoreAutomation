package teststore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import teststore.utilities.AbstractComponents;

public class OrderConfirmationPage extends AbstractComponents{

	WebDriver driver;
	public OrderConfirmationPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".h1")
	WebElement confirmationMsg;
	
	public void DisplayOrderConfirmationMsg()
	{
		String msg = confirmationMsg.getText();
		System.out.println(msg);
	}
}
