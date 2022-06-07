package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	private WebDriver driver;
	@FindBy(xpath="//input[@name='q']")WebElement search;
	@FindBy(xpath="//button[@class='L0Z3Pu']")WebElement  searchbutton;
	@FindBy(xpath="//div[@class='_28p97w']")WebElement user;
	@FindBy(xpath="//div[text()='Logout'] ")WebElement logout;
	@FindBy(xpath=" //div[text()='Top Offers']")WebElement topoffer;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void topoffer()
	{topoffer.click();}
	
	public void enterserch()
	
	{ WebDriverWait wait=new WebDriverWait(driver,50);
     wait.until(ExpectedConditions.visibilityOf(search));
		search.sendKeys("KETCH Men Slim Fit Checkered Cut Away Collar Casual Shirt");
	}
     public void selectSearch()
     { WebDriverWait wait=new WebDriverWait(driver,40);
      wait.until(ExpectedConditions.visibilityOf(searchbutton));
            searchbutton.click();}
     
      public void selectlogout()
	{
		 Actions as=new Actions(driver);
		 as.moveToElement(user).perform();
		as.moveToElement(logout).perform();
		as.click().build().perform();
	}
	
	
	
	
	}

