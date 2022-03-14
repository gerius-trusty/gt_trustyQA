package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;

public class PlanRecommendationOverview {
	
	WebDriver driver;
	CommonMethod cm;

	public PlanRecommendationOverview (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	cm = new CommonMethod(driver);
	}
	
	public By BackButton = By.xpath("//button[@id='backBtn']");
	
	public By EditButton = By.xpath("//div[contains(text(), 'Edit')]");
	
	public By SaveButton = By.xpath("(//div[contains(text(), 'SAVE')])[1]");
	
	public By BrokerPortalButton = By.xpath("//div[contains(text(), 'BROKER PORTAL')]");
	
	public By ComparePlansButton = By.xpath("//div[contains(text(), 'COMPARE PLANS')]");
	
	public By ViewPackagedetailsButton = By.xpath("//div[contains(text(), 'VIEW PACKAGE DETAILS')]");
	
	public By MedicapAndPrescriptionDrugTab = By.xpath("//div[contains(text(), 'MEDIGAP & PRESCRIPTION DRUG')]");
	
	public By MedicareAdvantagePlanTab = By.xpath("//div[contains(text(), 'MEDICARE ADVANTAGE PLAN')]");
	
    public By OriginalMedicareMedigapPDPSummuryTab = By.xpath("//div[contains(text(), 'ORIGINAL MEDICARE + MEDIGAP + PDP SUMMARY')]");
	
	
	public void clickOnEditButton () throws Exception {
		
		cm.findElement(EditButton).click();
	}
	public void clickOnBackButton () throws Exception {
		
		cm.findElement(BackButton).click();
	}
	
	public void clickOnSaveButton () throws Exception {
		
		WebElement svbt = driver.findElement(By.xpath("(//div[contains(text(), 'SAVE')])[1]"));
		
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].scrollIntoView();",svbt);
		//driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
//		js.executeScript("arguments[0].click();",SaveButton);
	//js.executeScript("window.scrollBy(0,600)");
	
//	driver.manage().timeouts().implicitlyWait(10 ,TimeUnit.SECONDS);
		
		cm.findElement(SaveButton).click(); 
	}
	
	public void clickOnBrokerPortal () throws Exception {
		
		cm.findElement(BrokerPortalButton).click();
	}
	
	public void clickOnComparePlans () throws Exception {
		
     cm.findElement(ComparePlansButton).click();
	}
	
	public void clickOnViewPackageDetails () throws Exception {
		
		cm.findElement(ViewPackagedetailsButton).click();
	}
	
	public void clickOnMedicapAndPrescriptionDrug () throws Exception {
		cm.findElement(MedicapAndPrescriptionDrugTab).click();
	}
	
	public void clickOnMedicareAdvantagePlan () throws Exception {
		
		cm.findElement(MedicareAdvantagePlanTab).click();
	}
	
	public void clickOnOriginalMedicareMedigapPDPSummury () throws Exception {
		cm.findElement(OriginalMedicareMedigapPDPSummuryTab).click();
	}
}
