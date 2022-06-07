package testClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClass.Homepage;
import pomClass.LoginPage;
import pomClass.SendMessage;

public class VerifySendMeasage {

	public static void main(String[] args) throws InterruptedException {
	
		System.setProperty("webdriver.chrome.driver", "F:\\selenium\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
	   driver.manage().timeouts().implicitlyWait(5000 ,TimeUnit.MILLISECONDS);
		driver.get("https://www.instagram.com/accounts/login/?hl=en");
		
		LoginPage loginpage=new LoginPage(driver);
		loginpage.selectloginas();
		loginpage.enterUser();
		loginpage.selectPassword();
		loginpage.selectlogin();
		Thread.sleep(2000);
		
		
		Homepage homepage=new Homepage(driver);
		homepage.selectNotas();
		String a=driver.getCurrentUrl();
		String b=driver.getTitle();
		System.out.println(a);
		System.out.println(b);
		if(a.equals("https://www.instagram.com/")&&  b.equals("Instagram"))
		{
			System.out.println("pass");
		}else {System.out.println("fail");}
		
		homepage.selectMessanger();
		String aa=driver.getCurrentUrl();
		String bb=driver.getTitle();
		System.out.println(aa);
		System.out.println(bb);
		if(aa.equals("https://www.instagram.com/direct/inbox/")&& bb.equals("Inbox • Chats"))
		{
			System.out.println("pass");
		}else {System.out.println("fail");}
		
	SendMessage sendmessage=new SendMessage(driver);
		sendmessage.entersendMessage();
		sendmessage.enterSearch();
		sendmessage.enterMessage();
		homepage.selectAccountUser();
		homepage.selectLogout();        
	
		
		
		
		
		
	}

}
