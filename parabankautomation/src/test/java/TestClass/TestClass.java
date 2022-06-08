package TestClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import pomClasses.BillPay;
import pomClasses.HomePage;
import pomClasses.Loginpage;
import pomClasses.UpdateContactInf;

public class TestClass {
WebDriver driver;
HomePage homepage;
SoftAssert soft;
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		 driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10000,TimeUnit.MILLISECONDS);
		driver.get("https://parabank.parasoft.com/parabank/index.htm");
		driver.manage().window().maximize();
	}
	
	@BeforeMethod
	public void logInToApplicatin() throws InterruptedException
	{
		Loginpage loginpage=new Loginpage(driver);
		loginpage.ragisterUser();
		Thread.sleep(3000);
		loginpage.enteruserName();
		loginpage.enterPassword();
		loginpage.enterlogin();
		 homepage=new HomePage(driver);
		 soft =new SoftAssert();
		
	}
	@Test
	public void verifyBillPay() throws InterruptedException
	{
		Thread.sleep(2000);
        homepage.billPay();
		
		String url1=driver.getCurrentUrl();
		String title1=driver.getTitle();
		System.out.println(url1);
		System.out.println(title1);
	soft.assertEquals("https://parabank.parasoft.com/parabank/billpay.htm", url1);
	soft.assertEquals("ParaBank | Bill Pay", title1);
//		if(url1.equals("https://parabank.parasoft.com/parabank/billpay.htm")&& title1.equals("ParaBank | Bill Pay"))
//	{
//			System.out.println("pass");
//		}else 
//		{
//	   System.out.println("fail");
//	}
		BillPay billpay=new BillPay(driver);
		billpay.enterpayee();
		billpay.enterAddress();
		billpay.entercity();
		billpay.enterstate();
		billpay.enterpinCode();
		billpay.enterphoneNo();
		billpay.enteraccount();
		billpay.enterverifyAccount();
		billpay.enterbillAmmount();
		billpay.enteraccountID();
		billpay.enterpayBill();
		soft.assertAll();
	}
	@Test
public void verifyUpdateContctInfo()
{homepage.updateContactInf();
String url2=driver.getCurrentUrl();
String title2=driver.getTitle();
//System.out.println(url1);
//System.out.println(title1);
soft.assertEquals("https://parabank.parasoft.com/parabank/updateprofile.htm", url2);
soft.assertEquals("ParaBank | Update Profile", title2);
//if(url2.equals("https://parabank.parasoft.com/parabank/updateprofile.htm")&& title2.equals("ParaBank | Update Profile"))
//{
//	System.out.println("pass");
//}else 
//{
//   System.out.println("fail");
//}
UpdateContactInf  updatecontactinfo= new UpdateContactInf (driver);
updatecontactinfo.enterName();
updatecontactinfo.enterLname();
updatecontactinfo.enterAddress();
updatecontactinfo.entercity();
updatecontactinfo.enterState();
updatecontactinfo.enterZipCode();
updatecontactinfo.enterphNo();
updatecontactinfo.enterUpdate();
soft.assertAll();
}
	@AfterMethod
	public void logOutApplication() throws InterruptedException
	{ Thread.sleep(2000);
		homepage.logOut();    	
	}
	@AfterClass
	public void closeBrowser()
	{
		driver.close();
	}
	
	
	
	
	
	
	
	
}
