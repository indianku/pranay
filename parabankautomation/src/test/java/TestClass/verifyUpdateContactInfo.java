package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.Loginpage;
import pomClasses.UpdateContactInf;

public class verifyUpdateContactInfo {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(7000,TimeUnit.MILLISECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
        
		Loginpage loginpage=new Loginpage(driver);
		loginpage.ragisterUser();

		
		loginpage.enteruserName();
		loginpage.enterPassword();
		loginpage.enterlogin();
		
		String url=driver.getCurrentUrl();
		String title=driver.getTitle();
		System.out.println(url);
		System.out.println(title);
	if(url.equals("https://parabank.parasoft.com/parabank/overview.htm")&& title.equals("ParaBank | Accounts Overview"))
		{
			System.out.println("pass");
		}else
		{
			System.out.println("fail");
		}
		HomePage homepage=new HomePage(driver);
		homepage.updateContactInf();
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		if(url1.equals("https://parabank.parasoft.com/parabank/billpay.htm")&& title1.equals("ParaBank | Bill Pay"))
		{
			System.out.println("pass");
		}else 
		{
		   System.out.println("fail");
		}
		UpdateContactInf  updatecontactinfo= new UpdateContactInf (driver);
		updatecontactinfo.enterName();
		updatecontactinfo.enterLname();
		updatecontactinfo.enterAddress();
		updatecontactinfo.entercity();
		updatecontactinfo.enterState();
		updatecontactinfo.enterZipCode();
		updatecontactinfo.enterphNo();
		updatecontactinfo.enterUpdate();
	}

}
