package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {


	@FindBy(xpath=" //button[text()='Not Now']")private WebElement notas;
	@FindBy(xpath="(//div[@class='XrOey']//a)[2]")private WebElement messanger;
	
	@FindBy(xpath="//div[@class='EforU']")private WebElement accountUser;
	@FindBy(xpath="//div[text()='Log Out']")private WebElement logout;
	
	public Homepage(WebDriver driver) {PageFactory.initElements(driver, this);}
	public void selectNotas() {notas.click();}
	public void selectMessanger() {messanger.click();}
	public void selectAccountUser() {accountUser.click();}
	public void selectLogout() {logout.click();}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
