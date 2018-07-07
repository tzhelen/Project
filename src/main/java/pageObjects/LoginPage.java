package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver mdriver;
	
	By email = By.cssSelector("[id='email']");	
	By password = By.cssSelector("[type='password']");
	By login = By.cssSelector("[id='submit-button']");
	
			
	
	public LoginPage(WebDriver driver)
	{
		mdriver = driver;		
	}


	public WebElement getEmail()
	{
		return mdriver.findElement(email);
	}

	public WebElement getPassword()
	{
		return mdriver.findElement(password);
	}
	
	public WebElement getLogin()
	{
		return mdriver.findElement(login);
	}
	
}
