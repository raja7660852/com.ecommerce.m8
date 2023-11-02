package contactsTests;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;
import genericUtilities.ExcelFileUtility;
import genericUtilities.JavaUtility;
import genericUtilities.PropertyFileUtility;
import genericUtilities.WebDriverUtility;
import io.github.bonigarcia.wdm.WebDriverManager;


public class CreateContactWithOrganizationTest extends BaseClass {

	
	@Test(groups = "ReggressionSuite")
	public void createContactWithOrgTest() throws Exception
	{

		String ORGNAME = eUtil.readDataFromEXcel("Contacts", 7, 3) + jUtil.getRandomNumber();
		String LASTNAME = eUtil.readDataFromEXcel("Contacts", 7, 2);

		//Step 6: click on Organization
		ObjectRepositary.HomePage hp = new ObjectRepositary.HomePage(driver);
		hp.clickOnOrganizationLink();
		
		//Step 7: Click on Create Organization look Up Image
		ObjectRepositary.OrganizationsPage op = new ObjectRepositary.OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();
		
		//Step 8: Create new Organization with Mandatory fields
		ObjectRepositary.CreateNewOrganizationPage cnop = new ObjectRepositary.CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		
		//Step 9: Validate for Organization
		ObjectRepositary.OrganizationInfoPage oip = new ObjectRepositary.OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);
		
		//Step 10: Click On Contacts Link
		hp.clickOnContactsLink();
		
		//Step 11: Click on Create contact Look Up Image
		ObjectRepositary.ContactsPage cp = new ObjectRepositary.ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		
		//Step 12: Create Contact with Organization
		ObjectRepositary.CreateNewContactPage cncp = new ObjectRepositary.CreateNewContactPage(driver);
		cncp.createNewContact(driver, LASTNAME, ORGNAME);
		
		//Step 13: Validation
		ObjectRepositary.ContactInfoPage cip = new ObjectRepositary.ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		System.out.println(contactHeader);
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}

}
