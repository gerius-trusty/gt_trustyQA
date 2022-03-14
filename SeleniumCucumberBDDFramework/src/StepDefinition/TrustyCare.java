package StepDefinition;

import static org.testng.Assert.assertEquals;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.GherkinKeyword;
import com.aventstack.extentreports.gherkin.model.Feature;
import com.aventstack.extentreports.gherkin.model.Scenario;

import CommonMethods.CommonMethod;
import Listeners.ExtentReportListener;
import PageObjects.AddNewBene;
import PageObjects.AddNewBeneMedicalInformation;
import PageObjects.BeneficiaryListView;
import PageObjects.InstantReviewRXPlan;
import PageObjects.PlanRecommendation;
import PageObjects.PlanRecommendationOverview;
import PageObjects.ProducerDashboard;
import PageObjects.ProducerListView;
import PageObjects.TrustyLogin;
import PageObjects.sauceHomePage;
import PageObjects.sauceLogin;
import PageObjects.trustyLoginDemoPage;
import Utility.BrowserUtility;
import Utility.ExcelHandler;
import Utility.Log;
import Utility.PropertiesFileReader;
import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import jxl.Workbook;



public class TrustyCare extends ExtentReportListener {

	public static WebDriver driver;

	TrustyLogin trustylogin;

	ProducerListView producerlistview;

	AddNewBene addnewbene;

	BeneficiaryListView beneficiarylistview;

	AddNewBeneMedicalInformation addnewbenemedinfo;

	PlanRecommendationOverview planrecommendationoverview;

	InstantReviewRXPlan  instantReviewRxPlan;
	
	ProducerDashboard producerdashboard;



	CommonMethod cm = new CommonMethod(driver);
	
	CommonMethod commonmethod;


	PropertiesFileReader obj = new PropertiesFileReader();







	@Given("user launches TC Url1")

	public void opentheURL() throws Exception {

		ExtentTest logInfo = null;

		try {

			Properties properties = obj.getProperty();  

			test = extent.createTest(Feature.class, "TEST");
			//				Thread.currentThread().getStackTrace()[1].getMethodName().toString()

			test = test.createNode(Scenario.class ,Thread.currentThread().getStackTrace()[1].getMethodName(), "TRUSTY CARE AUTOMATION");

			logInfo = test.createNode(new GherkinKeyword("Given"), "Add Bene With Plan");

			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser"),

					properties.getProperty("URL"),properties.getProperty("HeadLess"));



			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} 

		catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@When("users enters the Username")
	public void enter_username() throws Exception {
		ExtentTest logInfo = null;
		trustylogin = new TrustyLogin(driver);
		try {

			Properties properties = obj.getProperty();
			//				Map<String, String> TestDataInMap = ExcelHandler
			//						.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String username = properties.getProperty("Username");
			logInfo = test.createNode(new GherkinKeyword("When"), "enter username");
			trustylogin.enterUsername(username);
			cm.wait(1);



			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}
	}

	@When("users enters the Password")
	public void enter_password() throws Exception {
		ExtentTest logInfo = null;
		trustylogin = new TrustyLogin(driver);
		try {
			Properties properties = obj.getProperty();
			//				Map<String, String> TestDataInMap = ExcelHandler
			//						.getTestDataInMap(properties.getProperty("testdatafilepath"), "Login", "Data1");

			String password = properties.getProperty("Password");

			logInfo = test.createNode(new GherkinKeyword("When"), "enter password");

			trustylogin.enterPassword(password);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}

	}

	@And("click on login button")

	public void clickOnLoginButton() throws Exception
	{
		ExtentTest logInfo = null;
		trustylogin = new TrustyLogin(driver);

		try {



			logInfo = test.createNode(new GherkinKeyword("And"), "click on login button");
			trustylogin.clickOnLoginButton();


			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}

	}

	@When("Admin switches to broker account")

	public void clickOnSwitchBrokerAccount () throws Exception {

		ExtentTest logInfo = null;
		producerlistview= new ProducerListView(driver);

		try {
			logInfo =test.createNode(new GherkinKeyword ("When"), "Admin switches to broker account");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			producerlistview.clickOnAdminViewIcon();
			producerlistview.ClickOnSwitchBrokerViewButton();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
		}


	}

	@When("Broker Clicks on add beneficiaries button")

	public void clicOnAddBeneficiariesButton () throws Exception {

		ExtentTest logInfo = null;
		beneficiarylistview= new BeneficiaryListView(driver);

		try {
			logInfo=test.createNode(new GherkinKeyword ("When"), "Broker Clicks on add beneficiaries button");
			beneficiarylistview.ClickOnAddBeneficiaries();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}
	@And("Click on single beneficiary")

	public void clickOnSingleBeneficiaryButton () throws Exception {

		ExtentTest logInfo = null;
		beneficiarylistview= new BeneficiaryListView(driver);

		try {
			logInfo=test.createNode(new GherkinKeyword ("And"), "Click on single beneficiary");
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
			beneficiarylistview.ClickOnSignleBeneficiaries();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}


	}

	@When("Enter FirstName")

	public void enterFirstName() throws Exception {

		ExtentTest logInfo = null;
		addnewbene= new AddNewBene(driver);


		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");


			String firstName = TestDataInMap.get("FirstName");

			logInfo=test.createNode(new GherkinKeyword ("When"), "Enter FirstName");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			addnewbene.EnterFirstname(firstName);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}



	@And("Enter LastName")

	public void enterLastName() throws Exception {

		ExtentTest logInfo = null;
		addnewbene= new AddNewBene(driver);


		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");


			String lastName = TestDataInMap.get("LastName");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Enter LastName");
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS) ;
			addnewbene.EnterLastName(lastName);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@And("Enter ZipCode")

	public void enterZipCode () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String zipCode = TestDataInMap.get("ZipCode");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Enter ZipCode");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addnewbene.EnterZipCode(zipCode);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}

	@And("Enter PhoneNumber")

	public void enterPhoneNumber () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String phoneNumber = TestDataInMap.get("PhoneNumber");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Enter PhoneNumber");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addnewbene.EnterPhoneNumber(phoneNumber);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}

	@And("Enter BeneficiaryEmail")

	public void enterBeneficiaryEmail () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {
			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String beneEmail = TestDataInMap.get("BeneficiaryEmail");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Enter BeneficiaryEmail");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addnewbene.EnterBeneEmail(beneEmail);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}
	@And("Select EffectiveDate")

	public void selectEffectiveDate () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String effectiveDate = TestDataInMap.get("EffectiveDate");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Select EffectiveDate");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			addnewbene.selectEffectiveDateDropdown(effectiveDate);
			// addnewbene.SelectEffectiveDate();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}


	@And("Select Gender")

	public void selectGender () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String gender = TestDataInMap.get("Gender");


			logInfo=test.createNode(new GherkinKeyword ("And"), "Select Gender");
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

			addnewbene.ClickonLeganGender(gender);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}

	@And("Select Tobbaco Use")

	public void selectTobbacoUse () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String tobbacouse = TestDataInMap.get("TobbacoUse");


			logInfo=test.createNode(new GherkinKeyword ("And"), "Select Tobbaco Use");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			addnewbene.ClickOnTobbacoUse(tobbacouse);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}
	@And("Enter Date of Birth")

	public void selectDateOfBirth() throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String dateofbirth = TestDataInMap.get("DateOfBirth");

			String[] arrSplit = dateofbirth.split("/");

			String month = arrSplit[0];
			String day = arrSplit[1];
			String year = arrSplit[2];


			logInfo=test.createNode(new GherkinKeyword ("And"), "Enter Date of Birth");
			//  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

			addnewbene.SelectDateOfBirth(month,day,year);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch(AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);


		}
	}

	@And("Select Income Range")

	public void selectIncomeRange () throws Exception {

		ExtentTest logInfo = null;
		addnewbene= new AddNewBene(driver);



		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String incomerange = TestDataInMap.get("IncomeRange");

			logInfo=test.createNode(new GherkinKeyword ("And"), "Select Income Range");
			addnewbene.SelectIncomeRange(incomerange);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

	@And("Select Enrolled Plan")

	public void selectEnrolledPlan () throws Exception {
		ExtentTest logInfo = null;
		addnewbene= new AddNewBene(driver);


		try {

			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String enrolledPlan = TestDataInMap.get("EnrolledPlan");


			logInfo=test.createNode(new GherkinKeyword ("And"), "Select Enrolled Plan");
			addnewbene.selectEnrolledPlan(enrolledPlan);

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

	@And("Click on Save and continue")

	public void clickOnSaveAndContinue () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);

		try {


			logInfo=test.createNode(new GherkinKeyword ("And"), "Click on Save and continue");
			addnewbene.ClickOnSaveAndContinue();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

	@And("Click on Next Button")

	public void clickOnNext () throws Exception {

		ExtentTest logInfo = null;
		addnewbenemedinfo= new AddNewBeneMedicalInformation(driver);

		try {


			logInfo=test.createNode(new GherkinKeyword ("And"), "Click on Next Button");
			addnewbenemedinfo.clickOnNextButton();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

	@And("Select Plan on Plan Recomendation Page")

	public void selectPlan () throws Exception {


		ExtentTest logInfo = null;
		PlanRecommendation planRecommendation =  new PlanRecommendation(driver);


		try {


			Properties properties = obj.getProperty();
			Map<String, String> TestDataInMap = ExcelHandler
					.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data1");

			String planRecomendation = TestDataInMap.get("PlanRecomendation");

			String carrierProvider = TestDataInMap.get("CarrierProvider");

			Log.info("carrierProvider"+carrierProvider);
			Log.info("planRecomendation"+planRecomendation);



			logInfo=test.createNode(new GherkinKeyword ("And"), "Select Plan on Plan Recomendation Page");

			planRecommendation.selectPlan(planRecomendation,carrierProvider);

			Log.info("Step Executed");


			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}





	}

	@And("click Save on Plan Recomendation Overview Page")

	public void clickOnSave () throws Exception { 

		ExtentTest logInfo = null;
		planrecommendationoverview = new PlanRecommendationOverview(driver);

		try {


			logInfo=test.createNode(new GherkinKeyword ("And"), "click Save on Plan Recomendation Overview Page");
			planrecommendationoverview.clickOnSaveButton();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}




	}


	@And("Click on Save and Quit")

	public void clickOnSaveAndQuit () throws Exception {

		ExtentTest logInfo = null;
		addnewbene = new AddNewBene(driver);


		try {


			logInfo=test.createNode(new GherkinKeyword ("And"), "Click on Save and Quit");
			addnewbene.ClickOnSaveAndQuit();

			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

	@Given("User Creates Mutiple Beneficiaries")

	public void createMultipleBene () throws Exception{

		//int i;

		ExtentTest logInfo = null;

		FileInputStream fis = new FileInputStream("./resources-testdata/TestData.xlsx");     //Excel read and write condition (702-706)
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet sh = wb.getSheet("AddBene");

		int rows = sh.getLastRowNum();

		SoftAssert sassert = new SoftAssert();



		try {

			//

			System.out.println("count"+rows);


			opentheURL();

			enter_username();

			enter_password();

			clickOnLoginButton();

			clickOnSwitchBrokerAccount();



			for(int i =1;i<=rows;i++) {


				try {
					if(i>1) {

						driver.navigate().refresh();}

					clicOnAddBeneficiariesButton();
					//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					clickOnSingleBeneficiaryButton();
					//logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					AddNewBene addNewBene = new AddNewBene(driver);


					Properties properties = obj.getProperty();
					Map<String, String> TestDataInMap = ExcelHandler
							.getTestDataInMap(properties.getProperty("testdatafilepath"), "AddBene", "Data"+i);



					logInfo=test.createNode(new GherkinKeyword ("Given"), "User Creates Mutiple Beneficiaries");



					String firstname = TestDataInMap.get("FirstName");

					//  logInfo=test.createNode(new GherkinKeyword ("Given"), "User Creates Mutiple Beneficiaries");
					addNewBene.EnterFirstname(firstname);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					String lastName = TestDataInMap.get("LastName");
					addNewBene.EnterLastName(lastName);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


					String zipCode = TestDataInMap.get("ZipCode");
					addNewBene.EnterZipCode(zipCode);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					String phoneNo = TestDataInMap.get("PhoneNumber");
					addNewBene.EnterPhoneNumber(phoneNo);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					String email = TestDataInMap.get("BeneficiaryEmail");
					addNewBene.EnterBeneEmail(email);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					String dateofbirth = TestDataInMap.get("DateOfBirth");

					String[] arrSplit = dateofbirth.split("/");

					String month = arrSplit[0];
					String day = arrSplit[1];
					String year = arrSplit[2];

					addNewBene.SelectDateOfBirth(month, day, year);
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					// driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					String effectiveDate = TestDataInMap.get("EffectiveDate");
					Log.info("Effective Date"+effectiveDate);
					//   driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					addNewBene.selectEffectiveDateDropdown(effectiveDate);
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));


					String tobbaccoUse= TestDataInMap.get("TobbacoUse");
					addNewBene.ClickOnTobbacoUse(tobbaccoUse);
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					String incomerange = TestDataInMap.get("IncomeRange");

					addNewBene.SelectIncomeRange(incomerange);
					String selectedIncomeRange = addNewBene.getIncomeRange();

					// sassert. assert(incomerange, selectedIncomeRange, "Both are Matched");
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

					String gender = TestDataInMap.get("Gender");
					addNewBene.ClickonLeganGender(gender);
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					String enrolledPlan = TestDataInMap.get("EnrolledPlan");
					addNewBene.selectEnrolledPlan(enrolledPlan);
					//	   logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					clickOnSaveAndContinue();
					// logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					AddNewBeneMedicalInformation addNewBeneMedicalInfo = new AddNewBeneMedicalInformation(driver);

					addNewBeneMedicalInfo.clickOnNextButton();
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					PlanRecommendation planRecommendation = new PlanRecommendation (driver);

					String planRecomendation = TestDataInMap.get("PlanRecomendation");
					String carrierProvider = TestDataInMap.get("CarrierProvider");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					planRecommendation.selectPlan(planRecomendation, carrierProvider);
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

					PlanRecommendationOverview planOverView = new PlanRecommendationOverview(driver);

					planOverView.clickOnSaveButton();
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
					//  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

					//  driver.close();
					String TEXT_GREEN = "\u001B[32m";
					String ANSI_RESET = "\u001B[0m";
					// Log.info(i+"st Row of Data Inserted"+TEXT_GREEN);
					System.out.println( TEXT_GREEN +i +" th Row of Data Inserted"+ ANSI_RESET);
					Log.info("**********************************************************************************");


				}
				catch(Exception e) {
					logInfo=test.createNode(new GherkinKeyword ("Given"), "Failed");
					testStepHandle(i+" ROW FAIL", driver, logInfo, e);
					Log.info(i+"st Row of Data is not Inserted");
					Log.info("**********************************************************************************");
					continue;

				}

			}//forloop end



			sassert.assertAll();



			// logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		} catch (AssertionError | Exception e) {
			testStepHandle("FAILED", driver, logInfo, e);

		}


	}

	@Given("user launches TC Url2")

	public void opentheURL2() throws Exception {

		ExtentTest logInfo = null;

		try {

			Properties properties = obj.getProperty();  

			test = extent.createTest(Feature.class, "TEST");
			//		Thread.currentThread().getStackTrace()[1].getMethodName().toString()

			test = test.createNode(Scenario.class ,Thread.currentThread().getStackTrace()[1].getMethodName(), "TRUSTY CARE AUTOMATION");

			logInfo = test.createNode(new GherkinKeyword("Given"), "Add Bene without plan");

			driver = BrowserUtility.OpenBrowser(driver, properties.getProperty("browser"),
					

					properties.getProperty("URL"),properties.getProperty("HeadLess"));
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;



			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));

		} 

		catch (AssertionError | Exception e) {

			testStepHandle("FAIL", driver, logInfo, e);

		}

	}

	@And("user selects batch processing link")

	public void clickOnBatchProcessing () throws Exception {

		ExtentTest logInfo = null;
		beneficiarylistview = new BeneficiaryListView(driver);

		try {
			logInfo=test.createNode(new GherkinKeyword ("And"), "user selects batch processing link");
			beneficiarylistview.ClickOnBatchProcessingBtn();

			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}  catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}

	}



	@When("user clicks select all")



	public void clickSelectAll () throws Exception {

		ExtentTest logInfo = null;
		instantReviewRxPlan = new InstantReviewRXPlan(driver);
		try {
			instantReviewRxPlan.clickOnSelectAll();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "user clicks select all");
			
			driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
			
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}
	
	@When("user clicks start plan comparison batch button")



	public void clickStartPlanComparisonBatch () throws Exception {

		ExtentTest logInfo = null;
		instantReviewRxPlan = new InstantReviewRXPlan(driver);
		try {
			instantReviewRxPlan.startPlanComparisonBatch();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "user clicks start plan comparison batch button");
			
			
			
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}


	@When("the user clicks continue to start a plan comparison batch")

	public void clickContinue () throws Exception {

		ExtentTest logInfo = null;
		instantReviewRxPlan = new InstantReviewRXPlan(driver);
		try {
			instantReviewRxPlan.clickContinue();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "the user clicks continue to start a plan comparison batch");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

		@And("the user clicks the close button on the window")
	
		public void clickClose () throws Exception {
			
			ExtentTest logInfo = null;
			instantReviewRxPlan = new InstantReviewRXPlan(driver);
		try {
			instantReviewRxPlan.clickClose();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "the user clicks the close button on the window");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}

		@When("the user clicks view batch details button")
		
		public void clickViewBatchDetails () throws Exception {
			
			ExtentTest logInfo = null;
			instantReviewRxPlan = new InstantReviewRXPlan(driver);
			try {
			instantReviewRxPlan.clickViewBatchDetails();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "the user clicks view batch details button");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);

		}



	}
		
	
		
		@Then("the batch processing details are displayed")
		
		public void detailsDisplayed () throws Exception {
			
			ExtentTest logInfo = null;
			instantReviewRxPlan = new InstantReviewRXPlan(driver);
			try {
			instantReviewRxPlan.verifyBatchDetails();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "the batch processing details are displayed");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
			
			
			
			

		}
			
			

	}
		
		@And("Close the browser")
		public void closeTheBrowser () throws Exception {
			ExtentTest logInfo = null; 
			
			commonmethod = new CommonMethod(driver);
			
			 try {
				  
				 commonmethod.closeBrowser();
				  
				 driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				  
				 
				  logInfo=test.createNode(new GherkinKeyword ("And"), "Close Browser");
				  
				  
				  
				  logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			  } catch(AssertionError | Exception e) {
				  testStepHandle("FAIL", driver, logInfo, e);
				  
			  }
			
		}
		
		
		@When("the user clicks the dashboard icon")
				
				public void ClickDashboard () throws Exception {
					
					ExtentTest logInfo = null;
					beneficiarylistview = new BeneficiaryListView(driver);
					try {
						beneficiarylistview.ClickDashboard();
					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
					logInfo=test.createNode(new GherkinKeyword ("When"), "the user clicks the dashboard icon");
					logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
				}   catch (AssertionError | Exception e) {
					testStepHandle("FAIL", driver, logInfo, e);
					
					
					
		
				}
					
					
		
			}
		
		
		@And("the user selects the lead source filter icon")
		
		public void clickFilter () throws Exception {
			
			ExtentTest logInfo = null;
			producerdashboard = new ProducerDashboard(driver);
			try {
				producerdashboard.clickFilter();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			logInfo=test.createNode(new GherkinKeyword ("And"), "the user selects the lead source filter icon");
			logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
		}   catch (AssertionError | Exception e) {
			testStepHandle("FAIL", driver, logInfo, e);
				
			}
			
		}
		
			
			
			@When("the user selects lead builder")
			
			public void clickleadBuilder () throws Exception {
				
				ExtentTest logInfo = null;
				producerdashboard = new ProducerDashboard(driver);
				try {
					producerdashboard.clickleadBuilder();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logInfo=test.createNode(new GherkinKeyword ("When"), "the user selects lead builder");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}   catch (AssertionError | Exception e) {
				testStepHandle("FAIL", driver, logInfo, e);
					

			}
			

	}
			
			@When("the user selects upline")
						
						public void clickUpline () throws Exception {
							
							ExtentTest logInfo = null;
							producerdashboard = new ProducerDashboard(driver);
							try {
								producerdashboard.clickUpline();
							driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
							logInfo=test.createNode(new GherkinKeyword ("When"), "the user selects upline");
							logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
						}   catch (AssertionError | Exception e) {
							testStepHandle("FAIL", driver, logInfo, e);
								
			
						}
						
			
				}
			
					@When("the user selects self generated")
					
					public void clickSelfGenerated () throws Exception {
						
						ExtentTest logInfo = null;
						producerdashboard = new ProducerDashboard(driver);
						try {
							producerdashboard.clickSelfGenerated();
						driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
						logInfo=test.createNode(new GherkinKeyword ("When"), "the user selects self generated");
						logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
					}   catch (AssertionError | Exception e) {
						testStepHandle("FAIL", driver, logInfo, e);
							
		
					}
					
		
			}
					
			@And("the user selects a beneficiary")
								
								public void clickSingleBene () throws Exception {
									
									ExtentTest logInfo = null;
									producerdashboard = new ProducerDashboard(driver);
									try {
										producerdashboard.clickSingleBene();
									driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
									logInfo=test.createNode(new GherkinKeyword ("And"), "the user selects a beneficiary");
									logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
								}   catch (AssertionError | Exception e) {
									testStepHandle("FAIL", driver, logInfo, e);
										
					
								}
								
					
						}
			
			@When("the user clicks the back button")
			
			public void clickBackButton () throws Exception {
				
				ExtentTest logInfo = null;
				producerdashboard = new ProducerDashboard(driver);
				try {
					producerdashboard.clickBackButton();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				logInfo=test.createNode(new GherkinKeyword ("When"), "the user clicks the back button");
				logInfo.addScreenCaptureFromPath(captureScreenShot(driver));
			}   catch (AssertionError | Exception e) {
				testStepHandle("FAIL", driver, logInfo, e);
					

			}
			

	}
			
			
		
		
		
		
		
}
		
	




