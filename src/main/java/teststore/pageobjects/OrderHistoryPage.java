package teststore.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrderHistoryPage{
	WebDriver driver;
	public OrderHistoryPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(css=".table")
	WebElement Table;
	@FindBy(xpath="//table/tbody/tr")
	List<WebElement> rows;
	@FindBy(xpath="//table/thead/tr/th")
	List<WebElement> columns;
	
	//locate a table on a web page
	public void locatingWebTable()
	{
		int rowCount = rows.size();
		int columnCount = columns.size();
		System.out.println("Number of rows/coulmns present" + rowCount + "/" + columnCount);
		//read data from table
		
		for(int i=0; i<rowCount ;i++)
		{
			List<WebElement> currentRow = rows.get(i).findElements(By.tagName("td"));
			
			
			for(int j=0;j<currentRow.size();j++)
			{
				 String text = currentRow.get(j).getText().trim(); // Get cell text
				//checking if the text is present in the table
				if(text.equals("$36.00"))
				{
					System.out.println("this text is present at row" + i + "and coolumn"+ j);
				}
				//prints all data of table
				System.out.println(currentRow.get(j).getText());
				
			}
			System.out.println();
		}
		
		
	}

}
