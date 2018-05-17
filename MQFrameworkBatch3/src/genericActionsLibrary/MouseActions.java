package genericActionsLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class MouseActions {
	
	public static void mouseHover(WebDriver driver,WebElement element)
	{
		Actions act = new Actions(driver);
		//moving to an element and mouse hovering
		act.moveToElement(element).build().perform();
	}
	
	public static void rightMouseClick(WebDriver driver, WebElement rmcElement)
	{
		Actions act = new Actions(driver);
		//to Right click on any element
		act.contextClick(rmcElement).build().perform();
	}
	
	public static void dragAndDrop(WebDriver driver, WebElement dragSource, WebElement dropDest)
	{
		Actions act = new Actions(driver);
		//to drag and drop an element
		//first way
//		act.dragAndDrop(dragSource, dropDest).build().perform();
		//second way
		act.moveToElement(dragSource).clickAndHold().moveToElement(dropDest).release().build().perform();
	}

}
