package pomClasses;

import java.util.ArrayList;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ByShirt {
private WebDriver driver;
private WebDriverWait wait;
	@FindBy(xpath="//div[text()='Relevance']")WebElement relevance;
	@FindBy(xpath="//div[text()='Popularity']")WebElement popularity;
	
	@FindBy(xpath="//a[contains(@class,'IRpwTa')]")WebElement shirt;
	
	@FindBy(xpath="//li[@id='swatch-1-size']")WebElement size;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")WebElement addtocart;
	
	@FindBy(xpath="//div[@class='KK-o3G']")WebElement cart;
	
	public ByShirt(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
		wait=new WebDriverWait(driver,70);
	}
	public void selectRelevance() { relevance.click();}
	public void selcetPopularity() {popularity.click();}
	public void selectShirt() {
		
		wait.until(ExpectedConditions.visibilityOf(shirt));
		shirt.click();
	
	ArrayList<String>addr=new ArrayList<String>(driver.getWindowHandles());
	String l=addr.get(1);
	driver.switchTo().window(l);
	}
	
	public void selectSize()  {  
		wait.until(ExpectedConditions.visibilityOf(size));
		JavascriptExecutor js=(JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView(true);",size);

	js.executeScript("window.scrollBy(0,-2000)");
	size.click();}
	
	public void enterInCart() throws InterruptedException  { JavascriptExecutor jsl=(JavascriptExecutor)driver;
	wait=new WebDriverWait(driver,40);
	wait.until(ExpectedConditions.visibilityOf(addtocart));
	  jsl.executeScript("arguments[0].scrollIntoView(true);",addtocart);
	 Thread.sleep(2000);
		jsl.executeScript("window.scrollBy(0,2000)");
		addtocart.click();}
	public void  selcetCart()
	{cart.click();}
	
	
	
	
	
	
	
	
	
}
