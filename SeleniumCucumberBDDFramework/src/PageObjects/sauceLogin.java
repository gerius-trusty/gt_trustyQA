package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;
import Utility.Log;

public class sauceLogin {
	WebDriver driver;
	CommonMethod cm;

	public sauceLogin(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);

	}
	
    
    @FindBy(id="user-name") 
    WebElement usernameField;
    
   // @FindBy(how = How.ID, using = "password")
   // WebElement passwordField;
    
	public By loginButton = By.id("login-button");
	
	
	public void enterUsername(String usrname) throws Exception
	{
		cm.type(usernameField, usrname);
	}

	public void enteruPassword(String enterPasswordText,String password) throws Exception
	{
		By loginButton = By.id(enterPasswordText);
		cm.findElement(loginButton).sendKeys(password);
	}
	public void clickOnLogin() throws Exception
	{
		cm.findElement(loginButton).click();
		
		Log.info("Click on Login");

	}

}
