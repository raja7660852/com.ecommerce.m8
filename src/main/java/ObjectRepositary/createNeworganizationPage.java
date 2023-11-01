package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class createNeworganizationPage extends WebDriverUtility{
	
	//Declaration
	@FindBy(name="accountname")
	private WebElement orgNameEdt;
	
	@FindBy(name="industry")
	private WebElement industryDwn;
	
	@FindBy(name="accounttype")
	private WebElement typeDwn;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement saveBtn;
	
	public createNeworganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgEdt() {
		return orgNameEdt;
	}

	public WebElement getIndustryDwn() {
		return industryDwn;
	}

	public WebElement getSaveBtn() {
		return saveBtn;
	}
	//
	public void  createNewOrganization(String  ORGNAME)
	{
		orgNameEdt.sendKeys(ORGNAME);
	}
	public void createNewOrganization(String  ORGNAME,String INDUSTRY)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDwn,INDUSTRY);
		saveBtn.click();
	}
	public void createNewOrganization(String  ORGNAME,String INDUSTRY,String Type)
	{
		orgNameEdt.sendKeys(ORGNAME);
		handleDropDown(industryDwn,INDUSTRY);
		handleDropDown(typeDwn, Type);
		saveBtn.click();
	}

}
