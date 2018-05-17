package testBaseLibrary;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.testng.annotations.Parameters;

public class TestBase {

	public static final Logger log = Logger.getLogger(TestBase.class.getName());
	public WebDriver driver;
	
	
	public void initializeTest(String browser, String url)
	{
		String log4jpath="log4jproperties";
		PropertyConfigurator.configure(log4jpath);
		launchBrowser(browser);
		log.info("Opened the browser: "+browser);
		getURL(url);
		log.info("Navigated to the URL: "+url);
	}
	public void launchBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver = new ChromeDriver();	
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			File pathBinary = new File("C:\\Users\\VD57\\AppData\\Local\\Mozilla Firefox\\firefox.exe");
			FirefoxBinary firefoxBinary = new FirefoxBinary(pathBinary);
			FirefoxProfile firefoxProfile = new FirefoxProfile();       
			driver = new FirefoxDriver(firefoxBinary, firefoxProfile);
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public void getURL(String url)
	{
		driver.get(url);
	}
	
	public void closeBrowser()
	{
		driver.close();
	}
}
