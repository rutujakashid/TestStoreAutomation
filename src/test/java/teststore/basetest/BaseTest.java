package teststore.basetest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import teststore.pageobjects.HomePage;

public class BaseTest
{
	public WebDriver driver;
    protected HomePage homepage;
   
	
	public WebDriver webDriverInitializing() throws IOException 
	{
		//Creating new instance of Properties class so we can load data present in "Config.properties" file
		Properties prop = new Properties();
		//System.getProperty("user.dir"):It gives us the current project directory.
		//*Why there is need of FileInputStream:Properties.load method is designed in such a way (in format of Key-Value pair) that it takes InputStream as parameter .
		//Config.properties file cannot directly loaded.
		FileInputStream fis = new FileInputStream("C:\\Users\\DELL\\Desktop\\Resources\\eclipse-workspace_new\\TestStore\\src\\main\\java\\teststore\\utilities\\Config.properties");
		prop.load(fis);
		
		//String browserName = prop.getProperty("browser");
		String browserName =  System.getProperty("browser")!=null ? System.getProperty("browser") : prop.getProperty("browser");
		String url = prop.getProperty("url");
		//initialize Chrome driver
		if(browserName.contains("chrome"))
		{
			ChromeOptions option = new ChromeOptions();
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\DELL\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
			if(browserName.contains("headless"))
			{
				option.addArguments("headless");
			}
			
			driver = new ChromeDriver(option);	
			//ensure headless browser is opened in mazimize form 
			driver.manage().window().setSize(new Dimension(1440, 900));
		}
		//initialize Firefox driver
		else if(browserName.equalsIgnoreCase("fiefox"))
		{
		//	System.setProperty("webdriver.gecko.driver", "C:\\Users\\DELL\\Desktop\\Resources\\driver_v1\\chromedriver.exe");
		//	driver = new ChromeDriver();	
		}
		//initialize Microsoft Edge driver
		else if(browserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\Users\\DELL\\Desktop\\Resources\\driver_v1\\msedgedriver.exe");
			driver = new EdgeDriver();	
		}
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		return driver;
	}
	
	public List<HashMap<String, String>> GetJsonDataToHashmap() throws IOException
	{
		//covert json to string
		String jsonContent = FileUtils.readFileToString(new File(System.getProperty("user.dir")+"\\src\\test\\java\\teststore\\data\\LoginInfo.json"));
		//convert string to hashmap -ge dependency Jackson databind
		ObjectMapper mapper =new ObjectMapper();
		List<HashMap<String, String>> data = mapper.readValue(jsonContent, new TypeReference<List<HashMap<String, String>>>(){ 
			
		});
		return data;

    }
	
	public String takeScreenShot(String testcaseName, WebDriver driver) throws IOException
	{
		 if (driver == null) {
		        throw new NullPointerException("Driver is null; cannot capture screenshot.");
		    }
		TakesScreenshot ss= (TakesScreenshot) driver;
		File source = ss.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//AutomationTest//" + testcaseName + ".png");
		FileUtils.copyFile(source, file);
		//return System.getProperty("user.dir" + "//AutomationTest//" + testcaseName + ".png");
		return file.getPath();
		
	}

	
	
	@BeforeMethod(alwaysRun=true)
	public HomePage launchApplication() throws IOException
	{
		driver = webDriverInitializing();
		homepage = new HomePage(driver);
		homepage.gotoHomePage();
		return homepage;
		
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDownApplication()
	{
		driver.close();
	}
	
}
