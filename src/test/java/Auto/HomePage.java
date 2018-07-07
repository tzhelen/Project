package Auto;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.base;


public class HomePage extends base {
	
	public static Logger log =  LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initialize() throws IOException
	{
		//initialize web driver object
		driver = initializeDriver();
		log.info("Driver is initialized");
		driver.get( prop.getProperty("url"));
		log.info("Navigated to home page");
	}
	
	@Test(dataProvider="getdata")
	public void HomePageNavigation(String username, String password) 
	{
		//access the page object 
		LandingPage lp = new LandingPage(driver);			
		lp.getSignIn().click();		
		log.info("Navigated to sign in page");
		//enter email and password using data provider
		LoginPage lgp = new LoginPage(driver);
		lgp.getEmail().sendKeys(username);
		lgp.getPassword().sendKeys(password);
		lgp.getLogin().click();			
		
	}	

	
	@DataProvider
	public Object[][] getdata()
	{
		//we can have more data if we want
		Object[][] data = new Object[1][2];
		
		data[0][0]= "testusername1";
		data[0][1]= "testpassword1";
		
		//data[1][0]= "testusername2";
		//data[1][1]= "testpassword2";
		
		return data;
	}
	
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}

}
