package genericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static PropertyFileUtility pUtil = new PropertyFileUtility();
	public static ExcelFileUtility eUtil = new ExcelFileUtility();
	public static JavaUtility jUtil = new JavaUtility();
	public static WebDriverUtility wUtil = new WebDriverUtility();
	public static WebDriver driver = null;
	public static WebDriver sdriver;

	@BeforeSuite
	public void bsConfig() {
		System.out.println("---- DB Connection Successful ----");
	}

	@BeforeClass
	public void bcConfig() throws Exception {
		
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + "---- launched ----");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);
    
		driver.get(URL);
	      driver=sdriver;
	}

	@BeforeMethod
	public void bmConfig() throws Exception {
		
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
		
		LoginPage lp = new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);
		System.out.println("---- Login Successful ----");
	}

	@AfterMethod
	public void amConfig() throws Exception {
		
		HomePage hp = new HomePage(driver);
		hp.logoutofApp(driver);
		
		System.out.println("---- Logout Successful ----");

	}

	@AfterClass
	public void acConfig() {
		
		driver.quit();
		System.out.println("---- Browser Closed ----");

	}

	@AfterSuite
	public void asConfig() {
		System.out.println("---- DB Connection Closed ----");
	}
}

