package contactsTests;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;


@Listeners(genericUtilities.ListenersImplementationClass.class)
public class CreateContactTest extends BaseClass{

	@Test(groups = {"SmokeSuite","ReggressionSuite"})
	public void createContact() throws Exception {
		
		String LASTNAME = eUtil.readDataFromEXcel("Contacts", 1, 2);
		
		// Step 10: Click On Contacts Link
		ObjectRepositary.HomePage hp = new ObjectRepositary.HomePage(driver);
		hp.clickOnContactsLink();
		Reporter.log("Clicked on Contacts Link");

		// Step 11: Click on Create contact Look Up Image
		ObjectRepositary.ContactsPage cp = new ObjectRepositary.ContactsPage(driver);
		cp.clickOnCreateContactLookUpImg();
		Reporter.log("clicked create contact look up image");

		
		// Step 12: Create Contact with Organization
		ObjectRepositary.CreateNewContactPage cncp = new ObjectRepositary.CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
		Reporter.log("Contact created successfully");

		// Step 13: Validation
		ObjectRepositary.ContactInfoPage cip = new ObjectRepositary.ContactInfoPage(driver);
		String contactHeader = cip.getHeaderText();
		Reporter.log("Header captured");
		
		Assert.assertTrue(contactHeader.contains(LASTNAME));
		Reporter.log("Header valiadated");
		
		System.out.println(contactHeader);
	}
	
	@Test
	public void demo()
	{
		System.out.println("demo");
	}
	
	

}
