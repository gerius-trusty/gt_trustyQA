package StepDefinition;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testsel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//WebDriverManager.chromedriver().setup();
		System.setProperty("webdriver.chrome.driver", "/Users/asifshohel/Documents/Framework/TrustyCare/drivers/WebDriver");
		                                               
		
		 WebDriver driver = new ChromeDriver();
		 	
		 driver.get("https://www.saucedemo.com");
		
			}
	}

