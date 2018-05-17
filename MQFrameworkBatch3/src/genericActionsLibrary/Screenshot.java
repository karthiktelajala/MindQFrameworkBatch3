package genericActionsLibrary;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Screenshot {
	
	public static void captureScreenshot(WebDriver driver,String screenName)
	{
		try
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			File srcFile = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(srcFile, new File("./Screenshots/"+screenName+".jpg"));
		}
		catch(Exception e)
		{
			System.out.println("Exception while capturing Screenshot: "+e.getMessage());
		}
	}

}
