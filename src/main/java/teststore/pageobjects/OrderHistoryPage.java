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
			WebElement headerR = rows.get(i).findElement(By.tagName("th"));
			
			
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
	
	public void linkInTable()
	{
		int rowCount = rows.size();
		int columnCount = columns.size();
		for (int i = 0; i < rowCount; i++) {
	        // Get the row header (th tag in the row)
	        WebElement headerR = rows.get(i).findElement(By.tagName("th"));
	        String headerText = headerR.getText().trim();

	        if (headerText.equals("GZSUTTWRQ")) {
	            System.out.println("Found row header: " + headerText);

	            // Get all columns (td) of the current row
	            List<WebElement> currentRow = rows.get(i).findElements(By.tagName("td"));

	            // Click link in column 6 (index 5)
	            WebElement link = currentRow.get(5).findElement(By.tagName("a"));

	            // Optional: Wait for 3 seconds before clicking
	            try {
	                Thread.sleep(5000);
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	   
	            link.click();
	            System.out.println("Clicked link in column 6 of the matching row.");
	            break; // Exit loop once the link is clicked
	        }
		
		
		
	}
	}

}
