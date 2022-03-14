package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonMethods.CommonMethod;

public class BeneficiaryListView {

WebDriver driver;
CommonMethod cm;

public BeneficiaryListView (WebDriver driver) {
this.driver = driver;
PageFactory.initElements(driver, this);
cm = new CommonMethod(driver);
}

public By AddBeneficiariesIcon= By.xpath("//*[contains(text(), 'Beneficiaries')]");

public By AddSingleBeneficiariesButton = By.xpath("//*[@id=\"Single Beneficiary\"]/div");

public By Btn_BatchProcessing = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[2]/ul/div[4]");

public By Btn_Dashboard = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[1]/div/div/div[2]/ul/div[2]");






public void ClickOnAddBeneficiaries () throws Exception

{ 
	
	WebDriverWait wait=new WebDriverWait(driver,20);

 

//Wait till the element is not visible

WebElement element=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(), 'Beneficiaries')]")));
	
cm.findElement(AddBeneficiariesIcon).click();
}

public void ClickOnSignleBeneficiaries () throws Exception

{
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
cm.findElement(AddSingleBeneficiariesButton).click();
}



public void ClickOnBatchProcessingBtn( ) {
	
	
	cm.findElement(Btn_BatchProcessing).click();
	
}

public void ClickDashboard( ) {
	
	
	cm.findElement(Btn_Dashboard).click();
	
}

}