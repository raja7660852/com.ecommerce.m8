package ObjectRepositary;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
//declaration
public class LoginPage {
	@FindBy(name="user_name")
	private WebElement userNameEdt;
	
	@FindBy(name="user_password")
	private WebElement passWordEdt;
	
	@FindAll({@FindBy(id="submitButton"),@FindBy(xpath = "//input[@type='submit']")})
	private WebElement loginBtn;
	
	//instalization
	public LoginPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
//utilization
	public WebElement getUserNameEdt() {
		return userNameEdt;
	}

	public WebElement getPassWordEdt() {
		return passWordEdt;
	}

	public WebElement getLoginBtn() {
		return loginBtn;
	}
//	business library
	public void LogintoApp(String USERNAME,String PASSWORD)
	{
		userNameEdt.sendKeys(USERNAME);
		passWordEdt.sendKeys(PASSWORD);
		loginBtn.click();
	}
	
	
	
	
	

}
