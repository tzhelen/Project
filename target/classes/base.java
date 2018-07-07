package resources;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;


//base class to write test cases which will reuse across the framework
public class base {

	public static WebDriver driver;
	public static Properties prop;

	
	//initialize the browser according to data defined in property file
	public WebDriver initializeDriver() throws IOException
	{
		prop = new Properties();
		
		//get a property file 		
		InputStream ips = this.getClass().getResourceAsStream("/data.properties");
		//load the property file
		prop.load(ips);
		
		//get the define value for browser
		String browser = prop.getProperty("browser");
		
		//initialize browser
		if( browser.equals("chrome"))
		{			
			System.setProperty("webdriver.ie.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if ( browser.equals("firefox"))
		{		
			 System.setProperty("webdriver.ie.driver",
			            "C:\\Software\\Drivers\\geckodriver-v0.20.1-win64\\geckodriver.exe");			
			driver = new FirefoxDriver();
		}
		else if ( browser.equals("IE"));
		{
			driver = new InternetExplorerDriver();
		}		
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;
		
	}
	
	//save screen shot in file
	public void getScreenshot(String filename) throws IOException
	{
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);		
		FileUtils.copyFile(src, new File("C:/testsreenshot/"+filename+".png"));
		
	}
	
}
