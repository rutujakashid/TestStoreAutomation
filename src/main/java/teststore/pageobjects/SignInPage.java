package teststore.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignInPage 
{
	WebDriver driver;
	@FindBy(id="field-email")
	WebElement emaiId;
	@FindBy(id="field-password")
	WebElement password;
	@FindBy(id="submit-login")
	WebElement loginBtn;
	@FindBy(css=".alert.alert-danger")
	WebElement errorMessage1;
	
    By errorMessage = By.cssSelector(".alert.alert-danger");
	
	public SignInPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public ProductCataloguePage logInToProductCatalogue(String user , String pass)
	{
		emaiId.sendKeys(user);
		password.sendKeys(pass);
		loginBtn.click();
		ProductCataloguePage productcatalogue = new ProductCataloguePage(driver);
		return productcatalogue;
	}
	public String isErrorMessageDisplayed()
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage));
		//errorMessage.isDisplayed();
		System.out.println(errorMessage1.getText());
		return errorMessage1.getText();
		
	}
	public boolean isUsernameRequiredValidationTriggered() {
	    loginBtn.click();  // tries to submit form
	    String message = emaiId.getAttribute("validationMessage");
	    System.out.println(message);
	    return message != null && !message.isEmpty();
	}

	public boolean isPasswordRequiredValidationTriggered() {
	    loginBtn.click();  // tries to submit form
	    String message = password.getAttribute("validationMessage");
	    System.out.println(message);
	    return message != null && !message.isEmpty();
	}

}
