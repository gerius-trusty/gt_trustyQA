package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonMethods.CommonMethod;

public class InstantReviewRXPlan {

	WebDriver driver;
	CommonMethod cm;

	public InstantReviewRXPlan (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);
	}

	By btn_selectAll = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div/div[4]/div/div/div[1]/div[1]/div/div[1]/div/div/div[2]/div");

	By btn_planComparison = By.xpath("//*[contains(text(), 'Start Plan Comparison')]");

	By btn_continue = By.xpath("//*[contains(text(), 'Continue')]");

	By btn_close = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div[1]/div");

	By btn_viewBatchdetails = By.xpath("//div[@id='viewBatchDetailsLink']");

	By txt_batchProcessingDetails = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div[2]/div/div/div/div[1]/div[1]");

	
	public void clickOnSelectAll () throws Exception {

		cm.findElement(btn_selectAll).click();
	}
	
	public void startPlanComparisonBatch( ) {
		
		
		cm.findElement(btn_planComparison).click();
	}
	
	public void clickContinue( ) {
		
		
		cm.findElement(btn_continue).click();
	}
	
	public void clickClose( ) {
		
		
		cm.findElement(btn_close).click();
	}
	
	public void clickViewBatchDetails( ) {
		
		
		cm.findElement(btn_viewBatchdetails).click();
	}
	
	public void verifyBatchDetails( ) {
		
		
		cm.findElement(txt_batchProcessingDetails).isDisplayed();
	}

}


