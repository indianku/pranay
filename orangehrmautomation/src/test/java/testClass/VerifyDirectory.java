package testClass;

import static org.testng.Assert.fail;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
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
import pomClasses.Directory;
import pomClasses.HomePage;
import pomClasses.LoginPage;
import pomClasses.TimePage;
import util.Utility;


public class VerifyDirectory {

	WebDriver driver;
	Directory directory;
	LoginPage loginpage;
    HomePage homepage;
    int row=1;
    int cell=0;
    int cells=1;
    @Parameters("browserName")
 @BeforeTest
	public void openBrowser(String browser) throws InterruptedException
	{

	 if(browser.equals("chrom"))
		{ driver = Base.openChromeBrowser();}
	 
	 if(browser.equals("firefox"))
		{ driver = Base.openFirefoxBrowser();}
	 
	if(browser.equals("edge"))
		{driver = Base.openEdgeBrowser();}
		
	     driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	     driver.manage().window().maximize();
	   
	}
    @BeforeClass
    public void creatObjectOfPOMclass()
    {
	 directory=new  Directory(driver);
	 loginpage=new LoginPage(driver);
     homepage=new HomePage(driver); 
    	
    }
    
		@BeforeMethod
		public void loginToApplication( ) throws Exception, Exception 
		{	
		     driver.get("https://opensource-demo.orangehrmlive.com/");
		     Thread.sleep(2000);
		     String data=Utility.getexclesheetdata("star", row, cell);
			
			loginpage.sendUserName(data);
			data=Utility.getexclesheetdata("star", row, cells);
					
		    loginpage.sendPassword(data);
		    loginpage.login();
				    
		    
		}
		@Test
		public void verifydirectory() throws InterruptedException
		{   
		String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    
	    SoftAssert soft=new SoftAssert();
	    Assert.assertEquals(url,"https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	   
	    soft.assertEquals(title,"OrangeHRM");
	    homepage.openDirectory();
	    
	    String urls=driver.getCurrentUrl();
	    String titles=driver.getTitle();
	    Assert.assertEquals(urls,"https://opensource-demo.orangehrmlive.com/index.php/directory/viewDirectory/reset/1");
	    soft.assertEquals(titles,"OrangeHRM");
	  // directory=new Directory(driver);  
	   directory.enterName();
	   directory.selectJobTitle();
	   //Thread.sleep(2000);
	 // directory.enterLocation();
	   directory.selectSearch();
	   soft.assertAll();
	    }
		
		@Test()
		public void verifyTime()
		{
		 SoftAssert soft=new  SoftAssert();
	     homepage.selectTime();
		// String h= driver.getCurrentUrl();
		// String k=driver.getTitle(); 
		// Assert.assertEquals(h,"https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
		// soft.assertEquals(k,"OrangeHRM");
	     
	     Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/index.php/time/viewEmployeeTimesheet");
		 soft.assertEquals(driver.getTitle(), "OrangeHRM");
		 TimePage timePage=new TimePage(driver);
		 timePage.selectEmp();
		 timePage.selectView();
		 soft.assertAll();
		// Assert.fail();
			
		}
		@AfterMethod
		public void logOutFromApplication(ITestResult result) throws IOException
		{if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreeenshot( driver,result.getName());
		}
			 homepage.selectwelcome();
			 homepage.selectlogout();
		}

		@AfterClass
		public void closebrowser ()
		{
				
		     directory=null;
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
