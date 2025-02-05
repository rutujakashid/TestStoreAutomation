package teststore.pagetests;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import teststore.basetest.BaseTest;
import teststore.pageobjects.CartPage;
import teststore.pageobjects.DetailsPage;
import teststore.pageobjects.OrderConfirmationPage;
import teststore.pageobjects.ProductCataloguePage;
import teststore.pageobjects.ProductPage;
import teststore.pageobjects.SignInPage;

public class PlaceOrderTest extends BaseTest {
	@Test
	public void submitOrder()
	{
	SignInPage  signinpage = homepage.goToSignInPage();
	ProductCataloguePage productcatalogue = signinpage.logInToProductCatalogue("raavi@gmail.com","Raavi@123");
	productcatalogue.successfullLogin();
	List<WebElement> allproducts =   productcatalogue.getAllProducts();
	for(int i=0;i<allproducts.size();i++)
	{
		String s = allproducts.get(i).getText();
		System.out.println(s);
	}
	ProductPage productpage = productcatalogue.selectProduct("The Best Is Yet To Come'...");
	productpage.inputDimension("60x90cm");
	CartPage cartpage = productpage.addToCart();
	DetailsPage detailspage = cartpage.finalCheckout();
	detailspage.addAdressDetails();
	detailspage.addShippingMethod();
	OrderConfirmationPage confirmationpage = detailspage.selectPaymentOption();
	confirmationpage.DisplayOrderConfirmationMsg();
	
	}

}
