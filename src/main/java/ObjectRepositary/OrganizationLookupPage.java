package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationLookupPage {
	@FindBy(xpath ="//img[@alt='Create Organization...']")
	private WebElement OrganizationLookupImg;
	
	public OrganizationLookupPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrganizationLookupImg() {
		return OrganizationLookupImg;
	}
	public void clickonorgLookupimg()
	{
		OrganizationLookupImg.click();
	}

}
