package contactsTests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import ObjectRepositary.ContactPage;
import ObjectRepositary.CreateNewContactPage;
import ObjectRepositary.HomePage;
import ObjectRepositary.createNeworganizationPage;
import genericUtilities.BaseClass;

public class Createcontact extends BaseClass{
	String LASTNAME=eUtil.readDataFromEXcel("Contacts", 1, 2);
	@Test
	public void createcontact() {
		HomePage hp=new HomePage(driver);
		hp.clickoncontactsLink();
		
		ContactPage cp=new ContactPage(driver);
		cp.clickoncreateLookupimage();
		
		CreateNewContactPage cncp=new CreateNewContactPage(driver);
		cncp.createNewContact(LASTNAME);
	}
	

}
