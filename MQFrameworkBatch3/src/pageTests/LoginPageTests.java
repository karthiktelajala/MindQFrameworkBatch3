package pageTests;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import genericActionsLibrary.ExcelFile;
import genericActionsLibrary.Screenshot;
import pageActionsLibrary.LoginPageActions;
import testBaseLibrary.TestBase;

public class LoginPageTests extends TestBase
{
	public static final Logger log = Logger.getLogger(LoginPageTests.class.getName());
	LoginPageActions lpa;
	@Parameters(value="browser")
	@BeforeMethod
	public void testIniatialize(String browser)
	{
		initializeTest(browser, "http://opensource.demo.orangehrmlive.com/");
		Screenshot.captureScreenshot(driver, "LoginPage");
	}
	@Test(priority=1)
	public void loginWithValidCredentials() throws IOException
	{
		lpa = new LoginPageActions(driver);
		String username = ExcelFile.readExcel(0, 1, 0);
		String password = ExcelFile.readExcel(0,1,1);
		System.out.println(username + " -- "+password);
		lpa.enterUsername(username);
		log.info("Entered username: "+username);
		lpa.enterPassword(password);
		log.info("Entered password: "+password);
		Screenshot.captureScreenshot(driver, "LoginPageWithDetails");
		lpa.clickLogin();
		log.info("clicked login button");
		Screenshot.captureScreenshot(driver, "HomePage");
		String expTitle = "OrangeHRM";
		String actTitle = driver.getTitle();
		log.info("Captured the Title of Home page: "+ actTitle);
		Assert.assertEquals(actTitle, expTitle);
	}
	@Test(priority=2)
	public void loginWithInalidCredentials() throws IOException
	{
		lpa = new LoginPageActions(driver);
		String username = ExcelFile.readExcel(0, 2, 0);
		String password = ExcelFile.readExcel(0,2,1);
		System.out.println(username + " -- "+password);
		lpa.enterUsername(username);
		log.info("Entered username: "+username);
		lpa.enterPassword(password);
		log.info("Entered password: "+password);
		lpa.clickLogin();
		log.info("clicked login button");
		Screenshot.captureScreenshot(driver, "ErrorLoginPage");
		String expMsg = "Invalid credentials";
		String actMsg = lpa.getErrorLoginMessage();
		log.info("Captured the Error Login Message: "+ actMsg);
		Assert.assertEquals(actMsg, expMsg);
	}
	@AfterMethod
	public void testClosure()
	{
		closeBrowser();
	}
}
