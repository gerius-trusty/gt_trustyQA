package PageObjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import CommonMethods.CommonMethod;

public class AddNewBeneMedicalInformation {

	WebDriver driver;
	CommonMethod cm;

	public AddNewBeneMedicalInformation (WebDriver driver) {
	this.driver = driver;
	PageFactory.initElements(driver, this);
	cm = new CommonMethod(driver);
	}
	
	public By PreferredPharmaciesSearchField = By.xpath("//*[@id='Search for pharmacies']");
	
	public By DoctorsSearcField = By.xpath("//*[@id='Search for doctors']");
	
	public By AddMoreMedicineTab = By.xpath("//p[contains(text(), 'Add more Medicine')]");
	
	public By DrugNameSearchField = By.xpath("//*[@id='drug-name-search']");
	
	public By NextButton = By.xpath("//*[@id='nextbutton']/div[1]");
	
	public By SaveandquitButton = By.xpath("//*[@id='saveandquit']");
	
	
	
	
	public void enterPreferredPharmacies (String pharma) throws Exception {
		
		cm.findElement(PreferredPharmaciesSearchField).sendKeys(pharma);
	}
	
	public void enterDoctorSearch (String doctor) throws Exception {
		
		cm.findElement(DoctorsSearcField).sendKeys(doctor);
	}
	
	public void clickOnAddMoreMedicne () throws Exception {
		
	cm.findElement(AddMoreMedicineTab).click();
	}
	
	public void enterDrugNameSearch (String drugname) throws Exception{
		
		cm.findElement(DrugNameSearchField).sendKeys(drugname);
	}
	
	public void clickOnNextButton () throws Exception {
		try {
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		cm.findElement(NextButton).click();
		}catch(Exception E)	{
			System.out.println(E);
		}
	}

	public void ClickOnSaveandQuit () throws Exception { 
		
		cm.findElement(SaveandquitButton).click();
	}
	
	}
