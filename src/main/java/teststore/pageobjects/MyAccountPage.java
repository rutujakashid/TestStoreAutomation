package teststore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import teststore.utilities.AbstractComponents;

public class MyAccountPage extends AbstractComponents{ 
	WebDriver driver;
	public MyAccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="history-link")
	WebElement Order_History_And_DetailsLink;
	
	
	public OrderHistoryPage goToOrserHistoryPage()
	{
		Order_History_And_DetailsLink.click();
		OrderHistoryPage orderhistorypage = new OrderHistoryPage(driver);
		return orderhistorypage;
	}
	
	
}

