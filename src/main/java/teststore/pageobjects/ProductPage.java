package teststore.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import teststore.utilities.AbstractComponents;

public class ProductPage extends AbstractComponents{
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="group_3")
	WebElement productDimension;
	
	@FindBy(css=".bootstrap-touchspin-up")
	WebElement increaseqty;
	
	@FindBy(className="add-to-cart")
	WebElement addToCartBtn;
	
	@FindBy(xpath="//a[contains(text(),'Proceed to checkout')]")
	WebElement checkoutBtn;
	
	
	public void inputDimension(String dim)
	{
		Select dropdown = new Select(productDimension);
		dropdown.selectByVisibleText(dim);
		
	}
	
	public CartPage addToCart()
	{
		increaseqty.click();
		addToCartBtn.click();
		checkoutBtn.click();
		CartPage cartpage = new CartPage(driver);
		return cartpage;
	}

}
