package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;
import Utility.Log;

public class TrustyLogin {
	WebDriver driver;
	CommonMethod cm;

	public TrustyLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);

	}
	
	
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter Email']") 
    WebElement usernameField;
	
	public void enterUsername(String username)
	{
		cm.type(usernameField, username);
	}
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter Password']") 
    WebElement PasswordField;
	
	public void enterPassword(String Password)
	{
		cm.type(PasswordField, Password);
	}

	
	@FindBy(xpath="//div[contains(text(),'LOGIN')]") 
    WebElement loginbutton;
	
	public void clickOnLoginButton()
	{
		cm.click(loginbutton);
	}
	
}
