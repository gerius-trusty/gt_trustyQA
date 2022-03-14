package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import CommonMethods.CommonMethod;

public class ProducerDashboard {

	WebDriver driver;
	CommonMethod cm;

	public ProducerDashboard (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		cm = new CommonMethod(driver);
	}

	By btn_filter = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[1]/div[4]/div/div[2]");

	By btn_leadBuilder = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div[4]/div[1]/div/div[2]/div");
	
	By btn_selfGenerated = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div[3]/div[1]/div/div[2]/div");
	
	By btn_Upline = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div[2]/div/div[2]/div[1]/div/div[2]");
	
	By btn_back = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[1]/div[1]/div[2]/div/button");
	
	By btn_singleBene = By.xpath("/html/body/div[1]/div/div/div/div[1]/div[2]/div[2]/div/div/div[2]/div[2]/div[2]/div/div/div/div/div/div/div/div/div/div[2]/div[1]/div[1]/div[2]/div/div[2]/div[2]/div/div[1]/div/div[2]/div/div");

	
	public void clickFilter () throws Exception {

		cm.findElement(btn_filter).click();
	}
	
	
	public void clickleadBuilder () throws Exception {

		cm.findElement(btn_leadBuilder).click();
	}
	
	public void clickSelfGenerated () throws Exception {

		cm.findElement(btn_selfGenerated).click();
	}
	
	public void clickUpline () throws Exception {

		cm.findElement(btn_selfGenerated).click();
	}
	
	public void clickSingleBene () throws Exception {

		cm.findElement(btn_singleBene).click();
	}
	
	public void clickBackButton () throws Exception {

		cm.findElement(btn_back).click();
	}
	
	
	
	
}
