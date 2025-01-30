package teststore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import teststore.utilities.AbstractComponents;

public class ProductCataloguePage extends AbstractComponents{

	WebDriver driver;
	public ProductCataloguePage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css=".page-footer [href]")
	WebElement centerLogout;
	
	@FindBy(css=".col-xl-3")
	List<WebElement> products;
	
	By productsBy = By.cssSelector(".col-xl-3");
	public void successfullLogin()
	{
		System.out.println("Logged in successfully");
	}
    //This method will return all the products which are present on productcatalogue page after login.
	public List<WebElement> getAllProducts()
	{
		WaitForElementBy(productsBy);
		return products;
	}
	//This method will return the product selected by user
	public void selectProduct(String productName)
	{
		WebElement product = getAllProducts().stream().filter(prod -> prod.findElement(By.cssSelector(".col-xl-3")).getText()
				          .equals(productName)).findFirst().orElse(null);
		product.click();
	}
	
	
	
	
	
	
	
	
	
}
