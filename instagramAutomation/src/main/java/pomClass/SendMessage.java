package pomClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SendMessage {
	@FindBy(xpath="//button[@class='sqdOP  L3NKy   y3zKF     ']")private WebElement sendMessage;
	@FindBy(xpath="//input[@name='queryBox']")private WebElement search;
	@FindBy(xpath="//button[@class='wpO6b  ']")private WebElement nilay;
	@FindBy(xpath="//div[@class='rIacr']")private WebElement next;
	@FindBy(xpath="//textarea[@placeholder='Message...']")private WebElement message ;
	@FindBy(xpath="(//button[@class='sqdOP yWX7d    y3zKF     '])[3] ")private WebElement send;
	
	public SendMessage(WebDriver driver) {PageFactory.initElements(driver,this );}
	public void entersendMessage() {sendMessage.click();}
	public void enterSearch() {	search.sendKeys("nilay_mahure");nilay.click();next.click();};
	public void enterMessage() {message.sendKeys("hi ha automation cha message ahe");send.click();}
	
	
	
	
	
	
	
	
	
}
