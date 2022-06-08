package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {

	@FindBy (xpath="//a[text()='Register']")
	private WebElement ragister;
	
	@FindBy(xpath="//input[@id='customer.firstName']")
	private WebElement fname;
	@FindBy(xpath="//input[@id='customer.lastName']")
	private WebElement lname;
	
	@FindBy(xpath="//input[@id='customer.address.street']")
	private WebElement address;
	@FindBy(xpath="//input[@id='customer.address.city']")
	private WebElement city ;
	
	@FindBy(xpath="//input[@id='customer.address.state']")
	private WebElement state;

	@FindBy(xpath="//input[@id='customer.address.zipCode']")
	private WebElement zipcode ;
	@FindBy(xpath="//input[@id='customer.phoneNumber']")
	private WebElement phoneNumber ;
	@FindBy(xpath="//input[@id='customer.ssn']")
	private WebElement ssn ;
	@FindBy(xpath="//input[@id='customer.username']")
	private WebElement userName;
	@FindBy(xpath="//input[@id='customer.password']")
	private WebElement password;
	@FindBy(xpath="//input[@id='repeatedPassword']")
	private WebElement conformPassword;
	@FindBy(xpath="//input[@value='Register']")
	private WebElement proced;
	
	@FindBy(xpath="//input[@name='username']")
	private WebElement userName1;
	@FindBy(xpath="//input[@name='password']")
	private WebElement password1;
	@FindBy(xpath="//input[@value='Log In']")
	private WebElement login;
	
	public Loginpage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectragister()
	{
		ragister.click();	
	}
	public void enterFirstName()
	{
		fname.sendKeys("ram");
	}
	public void enterLastName()
	{
		lname.sendKeys("dhok");
	}
	
	public void enterAddress()
	{
		address.sendKeys("abcd");
	}
	public void entercity()
	{
		city.sendKeys("pune");
	}
	
	public void enterStsteName()
	{
		lname.sendKeys("dhok");
	}
	
	public void enterzipcode()
	{
		address.sendKeys("abcd");
	}
	public void enterPhoneNumber()
	{
	phoneNumber.sendKeys("8823455675");
	}
	public void enterssn()
	{
		ssn.sendKeys("456");
	}
	public void creatUserName()
	{
		userName.sendKeys("raju");
	}
	public void creatpassword()
	{
		password.sendKeys("raju123");
	}

	public void enterconformPassword()
	{
		conformPassword.sendKeys("raju123");	
	}
	public void selectProcead()
	{
		proced.click();
	}
	public void ragisterUser()
	{
		ragister.click();
		fname.sendKeys("ram");
		lname.sendKeys("dhok");
		address.sendKeys("abcd");
		city.sendKeys("pune");
		state.sendKeys("Maharashra");
		zipcode.sendKeys("456");
		phoneNumber.sendKeys("8823455675");
		ssn.sendKeys("456");
		userName.sendKeys("Raju");
		password.sendKeys("Raju123");
		conformPassword.sendKeys("Raju123");
		proced.click();
	}
	public void enteruserName()
	{
		userName1.sendKeys("Raju");
	}
	public void enterPassword()
	{  password1.sendKeys("Raju123");
	}
	public void enterlogin()
	{
	    login.click();
	}
	
}
