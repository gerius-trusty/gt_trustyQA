package PageObjects;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.ExtentReporter;
import com.aventstack.extentreports.ExtentTest;

import CommonMethods.CommonMethod;
import Utility.Log;
import CommonMethods.*;

public  class PlanRecommendation {
	
	WebDriver driver;
	CommonMethod cm;

	public PlanRecommendation(WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	cm = new CommonMethod(driver);
		
	}
	
	public By PrescriptionDrugPlanTab = By.xpath("//span[contains(text(),'Prescription Drug Plan')]");
	
	public By MedicareAdvantagePlanTab = By.xpath("//span[contains(text(),'Medicare Advantage Plan')]");
	
	public By CarrierFilterTab = By.xpath("//p[contains(text(),'Carrier')]");
	
	public By PlanTypeFilterTab =  By.xpath("//p[contains(text(),'Plan Type')]");
	
	public By SNPPlansFilterTab = By.xpath("//p[contains(text(),'SNP Plans')]");
	
	
	

	public void selectPlan(String plan,String carrierProvider) throws Exception{
		
		
		try
		{
			
			ExtentTest logInfo = null;
			
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			Log.info("Entered to select plan");
			WebElement target = driver.findElement(By.xpath("//*[starts-with(text(),'"+plan+"')]/../..//*[@type=\"button\"]"));
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();",target);
			
			
//			WebElement target = driver.findElement(By.xpath("//*[starts-with(text(),'Medi')]/../..//*[@type=\"button\"]"));
//			
//			
//			Actions act =  new Actions(driver);
//			Action mouseOverHome = act.moveToElement(target).click().build();
//			mouseOverHome.perform();
	
		
		//driver.findElement(By.xpath("//span[starts-with(text(),'"+plan+"')]/..")).click();
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		WebElement target1 = driver.findElement(By.xpath("//p[contains(text(),'"+carrierProvider+"')]/following::span[contains(text(),'Save')][1]"));
		JavascriptExecutor js1 = (JavascriptExecutor)driver;
		js1.executeScript("arguments[0].scrollIntoView();", target1);
		js1.executeScript("arguments[0].click();",target1);
		
		
		

		
	//	driver.findElement(By.xpath("//p[contains(text(),'"+carrierProvider+"')]/following::span[contains(text(),'Save')][1]")).click();
		
		
		}catch(Exception E)
		{
			System.out.println(E);
		}
	}
	
	
}
