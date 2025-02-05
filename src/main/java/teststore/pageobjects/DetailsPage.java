package teststore.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import teststore.utilities.AbstractComponents;

public class DetailsPage extends AbstractComponents {
	WebDriver driver;
	public DetailsPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="id_address_delivery")
	WebElement defaultAddress;
	
	@FindBy(linkText="add new address")
	WebElement addNewAddress;
	
	@FindBy(id="field-address1")
	WebElement address;
	
	@FindBy(id="field-city")
	WebElement city;

	@FindBy(id="field-id_state")
	WebElement state;

	@FindBy(id="field-postcode")
	WebElement zip;

	@FindBy(id="field-id_country")
	WebElement country;
	
	@FindBy(name="confirm-addresses")
	WebElement continueBtn;
	
	@FindBy(id="delivery_message")
	WebElement deliveryMessage;
	
	@FindBy(name="confirmDeliveryOption")
	WebElement confirmDelivery;
	
	@FindBy(id="payment-option-1")
	WebElement paymentOption;
	
	@FindBy(id="conditions_to_approve[terms-and-conditions]")
	WebElement ConditionsToApprove;
	
	@FindBy(xpath="//button[contains(text(),'Place order')]")
	WebElement placeOrderBtn;
	
	public void addAdressDetails()
	{
		if(defaultAddress.isSelected())
		{
			continueBtn.click();	
		}
		else
		{
			addNewAddress.click();
			address.sendKeys("123,Town");
			city.sendKeys("Delhi");
			Select options = new Select(state);
			options.selectByVisibleText("Florida");
			zip.sendKeys("40114");
			continueBtn.click();
		}
		
		
		
	}
	public void addShippingMethod()
	{
		deliveryMessage.sendKeys("Handle with care");
		confirmDelivery.click();
		
	}
	public OrderConfirmationPage selectPaymentOption()
	{
		if(paymentOption.isSelected())
		{
			ConditionsToApprove.click();
			placeOrderBtn.click();
		}
		else
		{
			paymentOption.click();
			ConditionsToApprove.click();
			placeOrderBtn.click();
		}
	
		OrderConfirmationPage confirmationpage = new OrderConfirmationPage(driver);
		return confirmationpage;
	}


	
}
