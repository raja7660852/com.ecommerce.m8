package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactPage {
	@FindBy(xpath = "//img[@alt='Create Contact...']")
	private WebElement createcontactlookupBtn;
	
	public ContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getCreatecontactlookupBtn() {
		return createcontactlookupBtn;
	}
	//genric method
	public void clickoncreateLookupimage()
	{
		createcontactlookupBtn.click();
	}

}
