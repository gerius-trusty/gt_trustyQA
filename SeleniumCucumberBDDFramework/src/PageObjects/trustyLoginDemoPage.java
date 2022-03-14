package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;
import Utility.Log;

public class trustyLoginDemoPage {
	WebDriver driver;
	CommonMethod cm;

	public trustyLoginDemoPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);

	}
	
	
	
	
	
	@FindBy(xpath="//input[@placeholder='Enter Email']") 
    WebElement emailField;
	
	public void enterEmail(String email)
	{
		cm.type(emailField, email);
	}
	
	
	@FindBy(xpath="//input[@placeholder='Enter Password']") 
    WebElement passwordField;
	
	public void enterpassword(String password)
	{
		cm.type(passwordField, password);
	}
	
	
	
	
	@FindBy(xpath="//*[contains(text(),'LOGIN')]") 
    WebElement LoginField;
	
	public void clickOnLogin()
	{
		cm.click(LoginField);
	}
	
	@FindBy(xpath="//*[contains(text(),'Beneficiaries')]") 
    WebElement benclick;
	
	public void clickonben()
	{
		cm.click(benclick);
		cm.wait(20);
	}
	
	
	
}