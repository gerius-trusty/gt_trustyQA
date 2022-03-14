package CommonMethods;

import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.UnreachableBrowserException;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import Utility.Log;

public class CommonMethod {

	WebDriver driver;

	public CommonMethod(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public  void uploadAutoIT(String fileName){
		try {

			String currentDirectory = System.getProperty("user.dir");
			System.out.println(currentDirectory);
			Process p = Runtime.getRuntime().exec(""+currentDirectory+"\\AutoIt\\cUpload.exe"+" "+currentDirectory+"\\ToUpload\\"+fileName);
			System.out.println(p);
			p.waitFor();  

		}catch (IOException e) {
			Log.error("Unable upload file" + e.toString());
		} catch (InterruptedException e) {
			Log.error("Unable upload file" + e.toString());
		}
	}
	public String getPageSource() {
		String pageSource = null;
		try {
					pageSource = driver.getPageSource();
		
	} catch (Exception e) {
		Log.error("Unable get source page" + e.toString());
	}
		return pageSource;
	}
	
	public void verifyPageTitle(String partialTitle) {

		String actualPageTitle = getPageTitle();
		if (actualPageTitle.contains(partialTitle)) {
			Log.info("Page title is verified");
		} else {
			Log.info("Page title is not verified");
		}

	}

	public String getPageTitle() {
		String pageTitle = null;
		try {
		pageTitle = driver.getTitle();
		
	} catch (Exception e) {
		Log.error("Unable to get page title" + e.toString());
	}
		return pageTitle;
	}
	
	public void switchToWindow(String pageTitle) {
		try {
			Set<String> windowHandles = driver.getWindowHandles();
			for (String windowHandle : windowHandles) {
				driver.switchTo().window(windowHandle);
				wait(2);
				String getTitle = getPageTitle();
				if (getTitle.contains(pageTitle)) {
					Log.info("Window is switched");
					break;
				}
			}
		} catch (Exception e) {
			Log.error("Unable to switch the window" + e.toString());
		}
	}
	
	public void switchToDefaultFrame() {
		try {
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			Log.error("Unable to switch to frame" + e.toString());
		}
	}
	
	
	
	
	
	
	public String getAlertText() {
		String alertText = null;
		try {
					Alert alert = driver.switchTo().alert();
					alertText = alert.getText();
					Log.error( "Alert text ["+alertText+"] is retrieved successfully ");
		} catch (Exception e) {
			Log.error("Unable to get text" + e.toString());
		}
		return alertText;
	}
	
	public boolean isAlertWindowPresent() {
		try {
			driver.switchTo().alert();
			return true;
		}
		catch (Exception E) {
			return false;
		}
	}	
	
	
	
	
	
	
	public void alertOk() {
		try {
					Alert alert = driver.switchTo().alert();
					alert.accept();
					Log.info("Click on Alert OK button");
		} catch (Exception e) {
			Log.error("Click on OK button on alert" + e.toString());
		}

	}
	
	
	public void alertCancel() {
		try {
					Alert alert = driver.switchTo().alert();
					alert.dismiss();
					Log.info("Click on Alert Cancel button");
		} catch (Exception e) {
			Log.error("Click on alert cancel button" + e.toString());
		}
		}
	
	public void clickOnForwardButton() {
		try {
					driver.navigate().forward();
					Log.info( "Sucessfully moved to 'Forward' page");
		} catch (Exception e) {
			Log.error("Click on forward button" + e.toString());
		}

	}
	public void refreshPage() {

		try{
					driver.navigate().refresh();
					Log.info( "Sucessfully Refreshed browser");
		} catch (Exception e) {
			Log.error("Unable to refresh the browser" + e.toString());
		}
	}
	public void clickOnBackButton() {

		try{
					driver.navigate().back();
					Log.info("Sucessfully moved to 'Back' page");
		}
	 catch (Exception e) {
		Log.error("Click on back button" + e.toString());
	}
	}
	
	
	public void closeBrowser() {
		try {
			Log.info("INFO Closing Browser...");
			
				driver.quit();
			
				Log.info("Browser closed");
		} catch (Exception e) {
			Log.error("Browser close failure" + e.toString());
		}
	}
	public static void delete(String filePath) {
		File directory = new File(filePath);
		
		File file1 = new File(filePath);
		
		file1.delete();
		if (directory.isDirectory()) {

			String files[] = directory.list();
			for (String temp : files) {
				File fileDelete = new File(directory, temp);
				fileDelete.delete();
			}
			if (directory.list().length == 0) {
				directory.delete();

			} else {

			}
		}
		
		directory.delete();
	}

	
	 public WebElement findElement(By locator) {
	        try {
	            WebElement element = driver.findElement(locator);
	            return element;
	            
	        } catch (NoSuchElementException e) {
	        	Log.error(e.getLocalizedMessage());
	        	throw e;
	        }
	    }
	 public Boolean isElementPresent(By targetElement) throws InterruptedException {
	        Boolean isPresent = driver.findElements(targetElement).size() > 0;
	        return isPresent;
	    }
	public void wait(int seconds) {
		try {
			for (int i = 1; i <= seconds; i++) {
				Thread.sleep((seconds - seconds) + 1 * 1000);

			}
			Log.info("Waiting for " + seconds + " Seconds");
		} catch (InterruptedException e) {
			Log.error(e.getLocalizedMessage());
		}
	}

	public void doubleClick(WebElement element) {
		Actions action = new Actions(driver);
		action.doubleClick(element);
		Log.info(element + " is clicked");

	}

	public void click(WebElement element) {
		try {
			element.click();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickByXPTH(String elementXpath) {
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));
			element.click();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickByAction(WebElement element) {
		try {
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().perform();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void clickActionByXpath(String elementXpath) {
		try {
			WebElement element = driver.findElement(By.xpath(elementXpath));
			Actions actions = new Actions(driver);
			actions.moveToElement(element).click().build().perform();
			Log.info(element + " is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void type(WebElement element, String data) {
		try {
			element.sendKeys(data);
			Log.info("on " + element + " " + data + " is entered");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public void selectFromDropdownByValue(WebElement element, String value) {
		try {
			Select s = new Select(element);
			s.selectByValue(value);
			Log.info(value + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void selectFromDropdownByindex(WebElement element, int index) {

		try {
			Select s = new Select(element);
			s.selectByIndex(index);
			Log.info(index + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void selectFromDropdownVisibleText(WebElement element, String VisibleText) {

		try {
			Select s = new Select(element);
			s.selectByVisibleText(VisibleText);
			Log.info(VisibleText + " is selected");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}

	}

	public void clickOnTab(WebElement element) {
		try {
			element.sendKeys(Keys.TAB);
			Log.info(element + " tab is clicked");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

	public String getText(WebElement element) {

		String value = element.getText();
		return value;

	}

	public int createRandomNumber() {
		int randomnumb = 0;
		try {
			Random rand = new Random();
			randomnumb = rand.nextInt(10000);
			Log.info(randomnumb + " Random number is created");
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
		}
		return randomnumb;

	}

	public void mouseHover(WebElement target) {
		try {
			Actions action = new Actions(driver);
			action.moveToElement(target).build().perform();
		} catch (Exception e) {
			Log.error(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}

}
