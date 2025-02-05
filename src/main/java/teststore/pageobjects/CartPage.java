package teststore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import teststore.utilities.AbstractComponents;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
	WebElement checkoutBtn;
	
	public DetailsPage finalCheckout()
	{
		checkoutBtn.click();
		DetailsPage detailspage = new DetailsPage(driver);
		return detailspage;
	}
	
}
