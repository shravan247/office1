package vtiger.organizationTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import genericUtility.excelFileUtility;
import genericUtility.javaUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;
import vtiger.objectRepository.createOrganizationPage;
import vtiger.objectRepository.homePage;
import vtiger.objectRepository.loginPage;
import vtiger.objectRepository.organizationInfoPage;
import vtiger.objectRepository.organizationPage;
@Listeners(genericUtility.listenerImplementation.class)

//scenario4
public class toCreateOrganization4Test extends BaseClass {
	@Test
	public void toCrateOrganization_004() throws Exception {
		// we are using all the login logout in base class
		excelFileUtility eUtil = new excelFileUtility();
		javaUtility jUtil = new javaUtility();

		// Step 1: Navigate to organization link
		homePage hp = new homePage(driver);
		hp.getOrganizationButton().click();
		Reporter.log("Organization page displayed successfully", true);

		// Step 2: Click on organization look up image
		organizationPage op = new organizationPage(driver);
		op.getCreateOrganizationButton().click();
		Reporter.log("Create organization page displayed successfully", true);

		String orgName = eUtil.toReadDataFromExcelFile("Organization", 1, 2);
		int random = jUtil.toGetRandomNumber();
		// Step 3: Create organization with mandatory fields
		createOrganizationPage cop = new createOrganizationPage(driver);

		cop.getOrganizationTextField().sendKeys(orgName + random);

		// Step 4: Select "Chemicals" in the industry drop down
		wUtil.handleDropdown(cop.getIndustryDropdown(), "Energy");
		// Step 5: Select "Customer" in the type drop down
		wUtil.handleDropdown(cop.getTypeDropdown(), "Customer");
		cop.getSaveButton().click();
		Reporter.log("Organization info page displayed successfully", true);

		// Step 6: Save and verify
		organizationInfoPage oip = new organizationInfoPage(driver);
		String info = oip.getContactsInformation().getText();
		assertTrue(info.contains(orgName));
		Reporter.log("Organization created successfully", true);

	}
}
