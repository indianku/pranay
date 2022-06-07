package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.ByShirt;
import pomClasses.HomePage;
import pomClasses.LoginPage;

public class TestCLass {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		 WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
		driver.get("https://www.flipkart.com/");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.enterUser();
		loginpage.enterPassword();
		loginpage.selectLogin();
		
		HomePage homepage=new HomePage(driver);
		 Thread.sleep(2000);
	String a=driver.getCurrentUrl();
	System.out.println(a);
		homepage.enterserch();
		
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
		 byshirt.selcetCart();
		 
		 homepage.selectlogout();
	}

}
