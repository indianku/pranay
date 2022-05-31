package pomClasses;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class RecruitmentPage {

	@FindBy(xpath="//select[@id='candidateSearch_jobTitle']")
	private WebElement job;
	
	@FindBy(xpath="//input[@id='candidateSearch_candidateName']")
	private WebElement candidateName;
	
	@FindBy(xpath="//select[@id='candidateSearch_jobVacancy'] ")
	private WebElement vacancy;
	
	@FindBy(xpath="//input[@id='candidateSearch_keywords']")
	private WebElement keyword;
	@FindBy(xpath="//select[@id='candidateSearch_hiringManager'] ")
	private WebElement hiringManager;
	@FindBy(xpath="//select[@id='candidateSearch_status'] ")
	private WebElement status;
	@FindBy(xpath="//input[@id='candidateSearch_fromDate'] ")
	private WebElement from;
	@FindBy(xpath="//select[@class='ui-datepicker-month']")
	private WebElement month;
	@FindBy(xpath="//select[@class='ui-datepicker-year'] ")
	private WebElement year;
	@FindBy(xpath="//a[text()='8']")
	private WebElement date;
	@FindBy(xpath="//input[@id='candidateSearch_toDate']")
	private WebElement to;
	@FindBy(xpath="//div[@class='ui-datepicker-title']//select[1]")
	private WebElement months;
	@FindBy(xpath=" //select[@class='ui-datepicker-year']")
	private WebElement years;
	@FindBy(xpath="//table[@class='ui-datepicker-calendar']//tr[4]//td[5] ")
	private WebElement dates;
	@FindBy(xpath=" //input[@id='btnSrch']")
	private WebElement search;
	
	public RecruitmentPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void selectJob()
	{
		Select s= new Select(job);
	    s.selectByVisibleText("Software Engineer");
	}
	public void selectCandidatename()
	{
		candidateName.sendKeys("Jennifer Clinton");
	}
	public void selectVacancy()
	{
		Select sa=new Select(vacancy);
	    
	    sa.selectByVisibleText("Software Engineer");
	}
	public void selectKeyword()
	{
		keyword.sendKeys("Jen");
	}
	public void selectHiringManager()
	{
		Select sb= new Select(hiringManager);
	   sb.selectByVisibleText("Odis Adalwin");
		
	}
	public void selectstatus()
	{
		Select sc=new Select(status);
	   sc.selectByVisibleText("Shortlisted");
	}
	public void selectFrom()
	{
		from.click();
		 Select sd=new Select(month);
		 sd.selectByVisibleText("Oct");
		 Select se=new  Select(year);
		 se.selectByVisibleText("2020");
		 date.click();
	}
	
	public void selectTo()
	{
		   to.click();
		    Select sf=new Select(months);
		    sf.selectByVisibleText("Nov");
		    Select sg=new Select(years);
		    sg.selectByVisibleText("2022"); 
		    dates.click();
	}
	public void selectSearch()
	{
		search.click();
	}
	
	
	
	
	
}
