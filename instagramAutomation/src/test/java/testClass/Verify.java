package testClass;

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

import pomClass.Homepage;
import pomClass.LoginPage;
import pomClass.SendMessage;

public class Verify {
	WebDriver driver;
	LoginPage loginpage;
	Homepage homepage;
	SendMessage sendmessage;
	
	
	
	@BeforeClass
	public void openBrowser()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
	 driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(5000 ,TimeUnit.MILLISECONDS);
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
	 loginpage=new LoginPage(driver);
	 
	 
	}
		@BeforeMethod
		public void loginApplication() throws InterruptedException
		{
			loginpage.selectloginas();
			loginpage.enterUser();
			loginpage.selectPassword();
			loginpage.selectlogin();
			Thread.sleep(2000);
			homepage=new Homepage(driver);
		}
		@Test
		public void test()
		{  
			homepage.selectNotas();
			SoftAssert soft=new SoftAssert();
			String a=driver.getCurrentUrl();
			String b=driver.getTitle();
			System.out.println(a);
			System.out.println(b);
			Assert.assertEquals(a,"https://www.instagram.com/" );
			soft.assertEquals(a,"Instagram" );
//			if(a.equals("https://www.instagram.com/")&&  b.equals("Instagram"))
//			{
//				System.out.println("pass");
//			}else {System.out.println("fail");}
//			
			homepage.selectMessanger();
			String aa=driver.getCurrentUrl();
			String bb=driver.getTitle();
			System.out.println(aa);
			System.out.println(bb);
			Assert.assertEquals("https://www.instagram.com/direct/inbox/", aa);
			
			soft.assertEquals("Inbox • Chats", bb);
//			if(aa.equals("https://www.instagram.com/direct/inbox/")&& bb.equals("Inbox • Chats"))
//			{
//				System.out.println("pass");
//			}else {System.out.println("fail");}
//			
		sendmessage=new SendMessage(driver);
			sendmessage.entersendMessage();
			sendmessage.enterSearch();
			sendmessage.enterMessage();
			homepage.selectAccountUser();
		}
		
						
		@AfterMethod
		public void logoutAppliocation()
		{
			homepage.selectLogout();        
		}
		@AfterClass
		public void closeBrowser()
		{
			driver.close();
		}
				
}
