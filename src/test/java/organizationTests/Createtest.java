package organizationTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepositary.HomePage;
import ObjectRepositary.LoginPage;
import ObjectRepositary.OrganizationLookupPage;
import ObjectRepositary.createNeworganizationPage;
import ObjectRepositary.organizationInfoPage;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Createtest extends WebDriverUtility{

	ExcelFileUtility eUtil = new ExcelFileUtility();
	PropertyFileUtility pUtil = new PropertyFileUtility();
	WebDriverUtility wUtil = new WebDriverUtility();
	JavaUtility jUtil = new JavaUtility();

	@Test(dataProvider = "getData")
	public void createMultipleOrg(String ORG, String INDUSTRY) throws Exception  {
		
		WebDriver driver = null;
		
		// Step 2: Read The Required Data
		String BROWSER = pUtil.readDataFromPropertyFile("browser");
		String URL = pUtil.readDataFromPropertyFile("url");
		String USERNAME = pUtil.readDataFromPropertyFile("username");
		String PASSWORD = pUtil.readDataFromPropertyFile("password");
        String ORGNAME = ORG+jUtil.getRandomNumber();

		// Step 3: Launch the browser
		if (BROWSER.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			System.out.println(BROWSER + " launched");
		} else if (BROWSER.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			System.out.println(BROWSER + " launched");
		} else {
			System.out.println("Invalid Browser Name");
		}

		wUtil.maximizeWindow(driver);
		wUtil.waitForPageLoad(driver);

		// Step 4: Load the URL
		driver.get(URL);

		// Step 5: Login To Application
		LoginPage lp = new LoginPage(driver);
		lp.LogintoApp(USERNAME, PASSWORD);

		// Step 6: click on Organization
		HomePage hp = new HomePage(driver);
		hp.clickonorgnationLink();

		// Step 7: Click on Create Organization look Up Image
		OrganizationLookupPage op = new OrganizationLookupPage(driver);
		op.clickonorgLookupimg();

		// Step 8: Create new Organization with Mandatory fields
		createNeworganizationPage cnop = new createNeworganizationPage(driver);
		cnop.createNewOrganization(ORGNAME, INDUSTRY);
	    // wUtil.captureScreenShot(driver, ORGNAME);

		// Step 9: Validate for Organization
		organizationInfoPage oip = new organizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		if (orgHeader.contains(ORGNAME)) {
			System.out.println(orgHeader);
			System.out.println("Organization Created");
		} else {
			System.out.println("FAIL");
		}
		
		//Step 10: Logout
		hp.logoutofApp(driver);
	}

	@DataProvider
	public Object[][] getData() throws Exception {
		return eUtil.readMultipleData("MultipleOrganizations");
	}

}
