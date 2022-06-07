package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath="//input[@class='_2IX_2- VJZDxU'] ")WebElement user;
	@FindBy(xpath="//input[contains(@class,'_2IX_2- _3mctLh VJ')]")WebElement password;
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")WebElement login;
	public LoginPage(WebDriver driver) {PageFactory.initElements(driver, this);}
	public void enterUser() {user.sendKeys("7709395679");}
	public void enterPassword() {password.sendKeys("pra13nay");}
	public void selectLogin() {login.click();}
	public void enterUs() {user.sendKeys("7709395679");}
	
	
	
	
	
	
	
}
