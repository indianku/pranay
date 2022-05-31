package testClass;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Base.Base;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.RecruitmentPage;
import util.Utility;

public class VerifyOrange {
	
	WebDriver driver;
	RecruitmentPage recruitmentpage;
	LoginPage loginpage;
    HomePage homepage;
    int row=1;
    
    
        @Parameters("browserName")
        @BeforeTest
		public void openBrowser(String browser) throws InterruptedException
		{

		 if(browser.equals("chrom"))
			{ 
			 driver = Base.openChromeBrowser();
			}
		 if(browser.equals("firefox"))
			{
			 driver = Base.openFirefoxBrowser();
			}
		if(browser.equals("edge"))
			{driver = Base.openEdgeBrowser();}
			
		     driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		   	 driver.manage().window().maximize();
		     }
        @BeforeClass
         public void creatObjectOfPOMclass()
        {
	 
	      loginpage=new LoginPage(driver);
          homepage=new HomePage(driver); 
          recruitmentpage=new RecruitmentPage(driver);
          
        }
		//@BeforeMethod
//		public void loginToApplication()
//		{
//			loginpage.sendUserName();
//		    loginpage.sendPassword();
//		    loginpage.login();
//		}
        
		@BeforeMethod
		public void loginToApplication() throws EncryptedDocumentException, IOException, InterruptedException 
		{  
			driver.get("https://opensource-demo.orangehrmlive.com/");
		    Thread.sleep(2000);
			String data=Utility.getexclesheetdata("star", row, 0);
			//Thread.sleep(2000);
	        loginpage.sendUserName(data);
	        
			data=Utility.getexclesheetdata("star", row, 1);
		    loginpage.sendPassword(data);
		    loginpage.login();
             
		}
		@Test
		public void test()
		{   
		String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    SoftAssert soft=new SoftAssert();
	    Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    soft.assertEquals(title,"OrangeHRM");	
	    
	    // homepage=new HomePage(driver);
	    homepage.openrecruitment();
	    String urls=driver.getCurrentUrl();
	    String titles=driver.getTitle();
	    Assert.assertEquals(urls,"https://opensource-demo.orangehrmlive.com/index.php/recruitment/viewCandidates");
	    soft.assertEquals(titles,"OrangeHRM");
	    
	   // recruitmentpage=new RecruitmentPage(driver);
	    recruitmentpage.selectJob();
	    recruitmentpage.selectCandidatename();
	    recruitmentpage.selectVacancy();
	    recruitmentpage.selectKeyword();
	    recruitmentpage.selectHiringManager();
	    recruitmentpage.selectstatus();
	    recruitmentpage.selectFrom();
	    recruitmentpage.selectTo();
	    recruitmentpage.selectSearch();
	   
	    soft.assertAll();
	   // row++;
	    }
		
		@AfterMethod
		public void logOutFromApplication(ITestResult result) throws IOException
		{
			if(ITestResult.FAILURE==result.getStatus())
		   {
			  Utility.captureScreeenshot( driver,result.getName());
		   }
			 homepage.selectwelcome();
			 homepage.selectlogout();
		}

		@AfterClass
		public void closebrowser ()
		{
			 recruitmentpage =null;
			 loginpage=null;
		     homepage=null;
		}
       @AfterTest
         public void closeBrowser()
         {
    	    driver.close();
            driver=null;
            System.gc();
         }


}		

	