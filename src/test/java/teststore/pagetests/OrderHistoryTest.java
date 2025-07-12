package teststore.pagetests;

import org.testng.annotations.Test;

import teststore.basetest.BaseTest;
import teststore.pageobjects.MyAccountPage;
import teststore.pageobjects.ProductCataloguePage;
import teststore.pageobjects.SignInPage;

public class OrderHistoryTest extends BaseTest {
	@Test
	public void OrderHistory()
	{
	SignInPage  signinpage = homepage.goToSignInPage();
	ProductCataloguePage productcatalogue = signinpage.logInToProductCatalogue("raavi@gmail.com","Raavi@123");
	productcatalogue.successfullLogin();
	MyAccountPage accountPage= productcatalogue.gotoViewMyCustomerAccountPage();
	accountPage.goToOrserHistoryPage();
	
}
}
