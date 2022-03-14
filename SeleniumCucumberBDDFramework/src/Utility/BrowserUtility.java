package Utility;


import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Hashtable;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.github.bonigarcia.wdm.WebDriverManager;



public class BrowserUtility
{
	public final static String PROJECT_DIRECTORY = System.getProperty("user.dir");
	
	public static WebDriver OpenBrowser(WebDriver driver,String browserName,String url,String Headless) throws Exception
	{
		PropertiesFileReader obj = new PropertiesFileReader();
		Properties properties = obj.getProperty();
		if(browserName.equalsIgnoreCase("Chrome"))
		{
			//WebDriverManager.chromedriver().setup();
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver");
			//System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+ "drivers/chromedriver");
			
			//  driver = new ChromeDriver();
			 	
		//	System.setProperty("webdriver.chrome.driver", PROJECT_DIRECTORY+"\\drivers\\chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if(Headless.equalsIgnoreCase("YES"))
			{
			options.addArguments("headless");
			}
			try {
							
			driver=new ChromeDriver(options);
		}catch(Exception e)
		{
			System.out.println(e);
		}
			Map<String, Object> chromePrefs = new Hashtable<String, Object>();
			
			chromePrefs.put("download.default_directory", System.getProperty("user.dir")+"\\"+properties.getProperty("DownloadFolderName"));
			chromePrefs.put("download.prompt_for_download", false);
			chromePrefs.put("plugins.always_open_pdf_externally", true);
			options.setExperimentalOption("prefs", chromePrefs);
			chromePrefs.put("plugins.plugins_disabled", new String[] {"Chrome PDF Viewer"});
			Log.info("Open browser");
			driver.manage().window().maximize();
			Log.info("Maximize browser");
			driver.get(url);
			Log.info("Navigate to URL"+url);
			Thread.sleep(5000);
			return driver;	
		}else 
		if(browserName.equalsIgnoreCase("IE"))
		{
			System.setProperty("webdriver.ie.driver", PROJECT_DIRECTORY+"\\drivers\\IEDriverServer.exe");
			DesiredCapabilities capabilities=new DesiredCapabilities();
			capabilities.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, "accept");
			capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
			capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
			capabilities.setCapability("ignoreZoomSetting", true);
			capabilities.setCapability("requireWindowFocus", true);//to move mouse manually			
			driver=new InternetExplorerDriver();
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		} else
			if(browserName.equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", PROJECT_DIRECTORY+"\\drivers\\geckodriver.exe");
			FirefoxOptions options = new FirefoxOptions();
			if(Headless.equalsIgnoreCase("YES"))
			{
				options.setHeadless(true);
			}
			FirefoxProfile firefoxProfile = new FirefoxProfile();
			 firefoxProfile.setPreference("browser.download.folderList",1);
		        firefoxProfile.setPreference("browser.download.manager.showWhenStarting",false);
		        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk","text/csv,application/java-archive, application/x-msexcel,application/excel,application/vnd.openxmlformats-officedocument.wordprocessingml.document,application/x-excel,application/vnd.ms-excel,image/png,image/jpeg,text/html,text/plain,application/msword,application/xml,application/vnd.microsoft.portable-executable");
		        firefoxProfile.setPreference("browser.download.dir",System.getProperty("user.dir")+"\\"+properties.getProperty("DownloadFolderName"));
		        firefoxProfile.setPreference("browser.helperApps.alwaysAsk.force", false);
		        firefoxProfile.setPreference("browser.download.manager.alertOnEXEOpen", false);
		        firefoxProfile.setPreference("browser.download.manager.showWhenStarting", false);
		        firefoxProfile.setPreference("browser.download.manager.focusWhenStarting", false);
		        firefoxProfile.setPreference("browser.download.manager.useWindow", false);
		        firefoxProfile.setPreference("browser.download.manager.showAlertOnComplete", false);
		        firefoxProfile.setPreference("browser.download.manager.closeWhenDone", false);
		        firefoxProfile.setPreference("download.prompt_for_download", false);

		        firefoxProfile.setPreference("plugin.disable_full_page_plugin_for_types", "application/pdf");
		        firefoxProfile.setPreference("pdfjs.disabled", true);
		        firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/pdf");
		        firefoxProfile.setPreference("pdfjs.migrationVersion", 1);

			
			
			
			driver=new FirefoxDriver(options);
			driver.manage().window().maximize();
			driver.get(url);
			return driver;	
		}
			return null;			
	}

}
