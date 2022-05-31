package pomClasses;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import util.Utility;

public class LoginPage {
	
	@FindBy(xpath="//input[@id='txtUsername']")
	private WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	private WebElement password;
	
	@FindBy(xpath="//input[@id='btnLogin']")
	private WebElement login;
	
	public LoginPage(WebDriver driver) 
	{
		PageFactory.initElements(driver, this);
		
	}
	public void sendUserName(String pra) 
	{ 
		//username.sendKeys("Admin");
		username.sendKeys(pra);
	}
	public void sendPassword(String vel) 
	{
		//password.sendKeys("admin123");
		password.sendKeys(vel);
	}
	
	public void login()
	{
		login.click();
	}
	
	
	
}
