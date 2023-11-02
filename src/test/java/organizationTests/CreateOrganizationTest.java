package organizationTests;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericUtilities.BaseClass;

public class CreateOrganizationTest extends BaseClass {

	@Test
	public void createOrg() throws Exception {
		
		String ORGNAME = eUtil.readDataFromEXcel("Organizations", 1, 2)+jUtil.getRandomNumber();
		
		// Step 6: click on Organization
		ObjectRepositary.HomePage hp = new ObjectRepositary.HomePage(driver);
		hp.clickOnOrganizationLink();

		// Step 7: Click on Create Organization look Up Image
		ObjectRepositary.OrganizationsPage op = new ObjectRepositary.OrganizationsPage(driver);
		op.clickOnOrganizationLookUpImg();

		// Step 8: Create new Organization with Mandatory fields
		ObjectRepositary.CreateNewOrganizationPage cnop = new ObjectRepositary.CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);

		// Step 9: Validate for Organization
		ObjectRepositary.OrganizationInfoPage oip = new ObjectRepositary.OrganizationInfoPage(driver);
		String orgHeader = oip.getHeaderText();
		Assert.assertTrue(orgHeader.contains(ORGNAME));
		System.out.println(orgHeader);

	}

}
