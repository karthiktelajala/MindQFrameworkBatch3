package pageActionsLibrary;

import org.openqa.selenium.WebDriver;

import pageObjectLibrary.LoginPageObjects;

public class LoginPageActions extends LoginPageObjects 
{	
	public LoginPageActions(WebDriver driver) 
	{
		super(driver);
	}

	public void enterUsername(String username)
	{
		txtUserName.sendKeys(username);
	}
	
	public void enterPassword(String password)
	{
		txtPassWord.sendKeys(password);
	}
	
	public void clickLogin()
	{
		btnLoginButton.click();
	}
	
	public String getErrorLoginMessage()
	{
		return msgLoginError.getText();
	}
}
