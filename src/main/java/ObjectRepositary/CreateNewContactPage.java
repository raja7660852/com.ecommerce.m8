package ObjectRepositary;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility {
	
	@FindBy(name="lastname")
	private WebElement LastEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement SaveBtn;
	
	@FindBy(xpath = "(//img[@alt='Select'][1])")
	private WebElement ContactOrgLookUpImg;
	
	@FindBy(name="search_text")
	private WebElement ContactOrgSearchEdt;
	
	@FindBy(name="search")
	private WebElement ContactOrgSearchBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}

	public WebElement getLastEdt() {
		return LastEdt;
	}

	public WebElement getSaveBtn() {
		return SaveBtn;
	}

	public WebElement getContactOrgLookUpImg() {
		return ContactOrgLookUpImg;
	}

	public WebElement getContactOrgSearchEdt() {
		return ContactOrgSearchEdt;
	}

	public WebElement getContactOrgSearchBtn() {
		return ContactOrgSearchBtn;
	}
	public void createNewContact(WebDriver driver,String LASTNAME)
	{
		LastEdt.sendKeys(LASTNAME);
		SaveBtn.click();
	}
	public void createNewContact(WebDriver driver,String LASTNAME,String ORGNAME)
	{
		LastEdt.sendKeys(LASTNAME);
		ContactOrgLookUpImg.click();
		switchToWindow(driver, "Accounts");
		ContactOrgSearchEdt.sendKeys(ORGNAME);
		ContactOrgSearchBtn.click();
		driver.findElement(By.xpath("//a[.='"+ORGNAME+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();
		
		
	
		
	}

	public void createNewContact(String lASTNAME) {
		// TODO Auto-generated method stub
		
	}

}
