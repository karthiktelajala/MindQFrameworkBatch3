package genericActionsLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitStatement 
{
	public static void implicitWait(WebDriver driver,int numOfSeconds)
	{
		driver.manage().timeouts().implicitlyWait(numOfSeconds, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver,int numOfSeconds, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver,numOfSeconds);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

}
