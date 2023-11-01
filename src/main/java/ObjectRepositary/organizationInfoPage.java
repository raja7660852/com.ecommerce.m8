package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInfoPage {
	
	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement orgHeaderText;
	
	public  organizationInfoPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getOrgHeaderText() {
		return orgHeaderText;
	}
	//business library
	public String getHeaderText()
	{
		
		return orgHeaderText.getText();
		
	}

	public void clickOnOrganizationLookUpImg() {
		// TODO Auto-generated method stub
		
	}

}
