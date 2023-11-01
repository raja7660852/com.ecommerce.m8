package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtilities.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText ="Organizations")
	private WebElement orgLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	@FindBy(linkText = "Products")
	private WebElement productsLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement administratorimg;
	
	@FindBy(linkText = "Sign Out")
	private WebElement signOutLink;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	public WebElement getClickonorgLink() {
		return orgLink;
	}


	public WebElement getContactsLink() {
		return contactsLink;
	}

	public WebElement getProductsLink() {
		return productsLink;
	}

	public WebElement getAdministratorimg() {
		return administratorimg;
	}

	public WebElement getSignOutLink() {
		return signOutLink;
	}
	//genric method
	
	public void clickonorgnationLink()
	{
		orgLink.click();
	}
	public void clickoncontactsLink()
	{
		contactsLink.click();
	}
	public void clickonproductLink()
	{
		productsLink.click();
	}
	public void clickonadminstrLink()
	{
	administratorimg.click();
	}
	public void clickonsignoutLink()
	{
		signOutLink.click();
	}
	public void logoutofApp(WebDriver driver) throws Exception
	{ 
		mouseHoverAction(driver, administratorimg);
		Thread.sleep(3000);
		signOutLink.click();
	}
	
	

}
