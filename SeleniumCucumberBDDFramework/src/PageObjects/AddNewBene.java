package PageObjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonMethods.CommonMethod;
import Utility.Log;

public class AddNewBene {

WebDriver driver;
CommonMethod cm;

public AddNewBene (WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
cm = new CommonMethod(driver);
}

public By FirstNameField = By.xpath("//*[contains(text(),'First Name')]/../input");

public By LastNameField = By.xpath("//input[@id='lastName']");

public By ZipCodeField = By.xpath("//input[@id='zipcode']");

public By PhoneNumberField = By.xpath("//input[@id='phonenumber']");

public By BenficiaryEmailAddressField = By.xpath("//input[contains(@placeholder,'Enter beneficiary')]");

public By EffectiveDateDropdown = By.xpath("//select[@id='effectivedate']");

//public By SelectEffectiveDateDropdown = By.xpath("//option[@value='december']");


public By LegalGenderButton = By.xpath("//*[//*[@id='genderselect']/div[2]]");

//public By TobbacoUseButton = By.xpath("//*[@data-testid='checkboxTitle' and contains(text(),'YES')]");


public By SaveAndContinueButton = By.xpath("//div[contains(text(), 'Save and continue')]");

public By CancelButton = By.xpath("//*[@id='cancel']");

public By SaveAndQuitButton = By.xpath("//*[@id='saveandquit']");

public By DateDropDown = By.xpath("//*[contains(text(),'Month')]");

public By MonthDropDown = By.xpath("//*[contains(text(),'Month')]/../../select[@data-focusable=\"true\"]");

public By IncomeRangeDropDown = By.xpath("//*[@id=\"incomerange=picker\"]");


//public By DateDropDown =By.xpath(null)

public void EnterFirstname (String firstname) throws Exception

{
	cm.findElement(FirstNameField).click();
cm.findElement(FirstNameField).sendKeys(firstname);
}

public void EnterLastName (String lastname) throws Exception

{
cm.findElement(LastNameField).sendKeys(lastname);
}

public void EnterZipCode (String Zipcode) throws Exception

{
cm.findElement(ZipCodeField).sendKeys(Zipcode);
}

public void EnterPhoneNumber (String phnno) throws Exception

{
cm.findElement(PhoneNumberField).sendKeys(phnno);
}

public void EnterBeneEmail (String beneEmai) throws Exception

{
cm.findElement(BenficiaryEmailAddressField).sendKeys(beneEmai);
}

public void ClickonLeganGender (String gender) throws Exception

{
cm.findElement(By.xpath("//*[contains(text(),'"+gender+"')]/../div[1]")).click();
}

public void selectEffectiveDateDropdown (String date) throws Exception {
	
	cm.findElement(EffectiveDateDropdown).click();
    WebElement dropdown = driver.findElement(By.xpath("//select[@id='effectivedate']"));
	cm.selectFromDropdownByValue(dropdown, date);
	
}

//public void SelectEffectiveDate () throws Exception {
//	cm.findElement(SelectEffectiveDateDropdown).submit();
//}

public void ClickOnTobbacoUse (String tobocoUse) throws Exception

{ 
	
	cm.findElement(By.xpath("//*[@data-testid='checkboxTitle' and contains(text(),'"+tobocoUse+"')]/../div[1]")).click();
}

public void ClickOnCancel () throws Exception

{

cm.findElement(CancelButton).click();
}

public void ClickOnSaveAndContinue () throws Exception

{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
cm.findElement(SaveAndContinueButton).click();
}

public void ClickOnSaveAndQuit () throws Exception

{

cm.findElement(SaveAndQuitButton).click();
}

public void SelectDateOfBirth (String Month,String Day, String Year) throws Exception {

	try {
//Selecting Month
	
	int monthCount = driver.findElements(By.xpath("(//*[contains(text(),'Month')]/../../select[1])/option")).size();
	
	
	for(int i=1;i<=monthCount;i++)
	{
		String optionsValue = driver.findElement(By.xpath("//*[contains(text(),'Month')]/../../select[1]/option["+i+"]")).getText();
		
		if(optionsValue.equals(Month))
		{
			
		cm.findElement(By.xpath("//*[contains(text(),'Month')]/../../select[1]/option["+i+"]")).click();
		}
		
	}
	
	//Selected day
	driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	
int dayCount = driver.findElements(By.xpath("//*[contains(text(),'Day')]/../../select[2]/option")).size();

Log.info("daysCount"+dayCount);
	

	for(int i=2;i<=dayCount;i++)
	{
		String dayValue = driver.findElement(By.xpath("//*[contains(text(),'Day')]/../../select[2]/option["+i+"]")).getText();
		
		if(dayValue.equals(Day))
		{
			
		cm.findElement(By.xpath("//*[contains(text(),'Day')]/../../select[2]/option["+i+"]")).click();
		}
	}
	
	
	
	//Selected Year
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	int yearCount = driver.findElements(By.xpath("//*[contains(text(),'Year')]/../../select[3]/option")).size();

	Log.info("year Count"+yearCount);
	Log.info("year "+Year);
		

		for(int i=2;i<=yearCount;i++)
		{
			String yearValue = driver.findElement(By.xpath("//*[contains(text(),'Year')]/../../select[3]/option["+i+"]")).getText();
			
			if(yearValue.equals(Year))
			{
				
			cm.findElement(By.xpath("//*[contains(text(),'Year')]/../../select[3]/option["+i+"]")).click();
			}
		}
		
	
	
	
	
	}
	catch(Exception E)
	{
		System.out.println(E);
	}
	
	
	
}

public void SelectIncomeRange(String IncomeRange) throws Exception 
{
	try{
		
		WebDriverWait wait=new WebDriverWait(driver,20);



		//Wait till the element is not visible

		WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(IncomeRangeDropDown));
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	cm.findElement(IncomeRangeDropDown).click();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.findElement(By.xpath("//*[contains(text(),'"+IncomeRange+"')]")).click();
	
	

}
catch(Exception E)
{
	System.out.println(E);
}
	
	
}

public String getIncomeRange()
{
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	String selectedOp = driver.findElement(By.xpath("//*[@aria-selected=\"true\"]")).getText();
	
	return selectedOp;
	
}
public void selectEnrolledPlan (String enrolledPlan) throws Exception {
	
	try {
	
	driver.findElement(By.xpath("//div[starts-with(text(),'"+enrolledPlan+"')]/parent::div/div[1]")).click();
}
catch(Exception E)
{
	System.out.println(E);
}
}



}