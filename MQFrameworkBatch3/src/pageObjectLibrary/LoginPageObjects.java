package pageObjectLibrary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageObjects 
{
	@FindBy(id="txtUsername")
	public WebElement txtUserName;
	
	@FindBy(id="txtPassword")
	public WebElement txtPassWord;
	
	@FindBy(id="btnLogin")
	public WebElement btnLoginButton;
	
	@FindBy(id="spanMessage")
	public WebElement msgLoginError;
	
	public LoginPageObjects(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
}
