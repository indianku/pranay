package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	@FindBy(xpath="//a[@id='menu_pim_viewMyDetails']")
	private WebElement myinfo;
	
	@FindBy(xpath="//a[@id='menu_dashboard_index'] ")
	private WebElement dashboard;
	
	@FindBy(xpath="//b[text()='Recruitment']")
	private WebElement recruitment;
	
	@FindBy(xpath="//a[@id='welcome']")
	private WebElement welcome;

	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logout;
	
	@FindBy(xpath="//a[@id='menu_directory_viewDirectory']")
	private WebElement directory;

	@FindBy(xpath="//a[@id='menu_time_viewTimeModule']")
	private WebElement time;
	
	
	
	public  HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void openmyinfo()
	{
		myinfo.click();
	}
	public void opendashboard()
	{
		dashboard.click();
	}
	
	public void openrecruitment()
	{
		recruitment.click();
	}
	public void openDirectory()
	{
		directory.click();
	}
	public void selectTime()
	{
		time.click();
	}
public void selectwelcome()
{
	welcome.click();
	
}
public void selectlogout()
{
	logout.click();	
}
	
	
}


