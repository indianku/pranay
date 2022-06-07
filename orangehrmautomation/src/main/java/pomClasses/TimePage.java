package pomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TimePage {

	@FindBy (xpath="//input[@id='employee']")private WebElement empName;

@FindBy(xpath="//input[@id='btnView']")private WebElement view;

public TimePage(WebDriver driver)
{
	PageFactory.initElements(driver, this);
}
public void selectEmp ()
{
	empName.click();
}

public void selectView()
{
	view.click();
}
}
