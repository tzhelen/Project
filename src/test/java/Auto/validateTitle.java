package Auto;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import resources.base;




public class validateTitle extends base  {
	
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
		
	
	@Test
	public void ValidateTitle() 
	{		
		
		//access the page object 
		LandingPage lp = new LandingPage(driver);		
		Assert.assertEquals(lp.getTitle().getText(), "Stack Overflow");
		log.info("Successfully validated the title text");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
		driver = null;
		log.info("Driver is closed");
	}

}
