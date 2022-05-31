package testClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.RecruitmentPage;
import util.Utility;

public class VerifyOrangeHRMHeads {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
		 System.setProperty("webdriver.chrome.driver","F:\\selenium\\chromedriver.exe");
	     WebDriver driver = new ChromeDriver();
	     driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	     driver.get("https://opensource-demo.orangehrmlive.com/");

	    LoginPage loginpage=new LoginPage( driver);
	    String user= Utility.getexclesheetdata("star", 1,0 );
	    loginpage.sendUserName(user);
	    String pass= Utility.getexclesheetdata("star", 1,1);
	    loginpage.sendPassword(pass);
	    loginpage.login();
	    String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    if(url.equals("https://opensource-demo.orangehrmlive.com/index.php/dashboard")&& title.equals("OrangeHRM"))
	    {
	    	System.out.println("pass");
	    }else 
	    {
	    	System.out.println("fail");
	    }
	    HomePage homepage=new HomePage(driver);
	    homepage.openrecruitment();
	    String urls=driver.getCurrentUrl();
	    String titles=driver.getTitle();
	    
	    if(urls.equals("https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates")&& title.equals("OrangeHRM"))
	    {
	    	System.out.println("pass");
	    }else 
	    {
	    	System.out.println("fail");
	    }
	    
	  
	    RecruitmentPage recruitmentpage=new RecruitmentPage(driver);
	    
	    recruitmentpage.selectJob();
	    recruitmentpage.selectCandidatename();
	    Thread.sleep(1000);
	    recruitmentpage.selectVacancy();
	  //  recruitmentpage.selectKeyword();
	    Thread.sleep(1000);
	    recruitmentpage.selectHiringManager();
	    Thread.sleep(1000);
	    recruitmentpage.selectstatus();
	    Thread.sleep(2000);
	    recruitmentpage.selectFrom();
	    Thread.sleep(1000);
	    recruitmentpage.selectTo();
	    Thread.sleep(2000);
	    recruitmentpage.selectSearch();
	   
	  
	   
	     homepage.selectwelcome();
	     
	     homepage.selectlogout();
	    
	    
	    
	}

}
