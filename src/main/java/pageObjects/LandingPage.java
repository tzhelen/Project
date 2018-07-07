package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver mdriver;
	
	By signin = By.cssSelector("a.btn-clear");
	By title = By.cssSelector("*[class='-logo js-gps-track']");
	By navuser = By.cssSelector("*[id='nav-users']");
	
	public LandingPage(WebDriver driver)
	{
		mdriver = driver;		
	}

	public WebElement getSignIn()
	{
		return mdriver.findElement(signin);
	}
	
	public WebElement getTitle()
	{
		return mdriver.findElement(title);
	}

	public WebElement getNavUser()
	{
		return mdriver.findElement(navuser);
	}
}
