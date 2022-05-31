package pomClasses;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class Directory {
	
		@FindBy(xpath="//input[@id='searchDirectory_emp_name_empName']")private WebElement name; 
		@FindBy(xpath="//select[@id='searchDirectory_job_title']")private WebElement job;
		@FindBy(xpath="//select[@id='searchDirectory_location'] ")private WebElement location;
		@FindBy(xpath="//input[@id='searchBtn'] ")private WebElement search;
	
		public Directory(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
		
	public  void enterName()
	{
	name.sendKeys("Peter Mac Anderson");	
	}
	public void selectJobTitle()
	{
		Select s=new  Select(job);
		s.selectByVisibleText("Chief Financial Officer");
		
	}
	public void enterLocation()
	{
		Select as=new Select(location);
		
		as.selectByVisibleText("New York Sales Office");
	}
	public void selectSearch()
	{
		search.click();
	}
			
	}

	

