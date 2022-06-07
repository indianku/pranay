package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomClasses.ByShirt;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class VerifyByShirt {
	private WebDriver driver;
	private HomePage homepage;
	private LoginPage loginpage;
	@BeforeClass
	public void openBrowser()
	{	System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
	 driver=new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	driver.get("https://www.flipkart.com/");
	    loginpage=new LoginPage(driver);
		}
		@BeforeMethod
		public void loginToApplication()
		{
			
			loginpage.enterUser();
			loginpage.enterPassword();
			loginpage.selectLogin();
			
		homepage=new HomePage(driver);
		}
				
			
				@Test
				public void test() throws InterruptedException
				{String a=driver.getCurrentUrl();
				System.out.println(a);
				Thread.sleep(2000);
				homepage.enterserch();
				Thread.sleep(2000);
				homepage.selectSearch();
				 ByShirt byshirt=new ByShirt(driver);
			
				 byshirt.selectRelevance();
				 byshirt.selcetPopularity();
				 Thread.sleep(2000);
				 byshirt.selectShirt();
				 Thread.sleep(4000);
				 byshirt.selectSize();
				 Thread.sleep(2000);
				 byshirt.enterInCart();
				 byshirt.selcetCart();}
				
		@AfterMethod
		public void afterMethod()
		{
			System.out.println("k");
		}
		@AfterClass
		public void afterClass()
		{
			System.out.println("k");
		}
}
