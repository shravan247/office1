package vtiger.contactTests;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import dev.failsafe.internal.util.Assert;
import genericUtility.BaseClass;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;
import vtiger.objectRepository.contactsInfoPage;
import vtiger.objectRepository.contactsPage;
import vtiger.objectRepository.createContactPage;
import vtiger.objectRepository.homePage;
import vtiger.objectRepository.loginPage;

@Listeners(genericUtility.listenerImplementation.class)
//Scenario 1
public class toCreateContact1Test extends BaseClass {

	@Test(groups = "smoke")
	public void toCreateContactTest_001() throws Exception {
		// we are using all the login logout in base class
		excelFileUtility eUtil = new excelFileUtility();
		// Step 1: Navigate to contacts link
		homePage hp = new homePage(driver);
		hp.getContactsButton().click();
		Reporter.log("Contacts page displayed successfully", true);

		// Step 2: click on Create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.getCreateContactButton().click();
		Reporter.log("Create contacts page displayed successfully", true);

		String lastname = eUtil.toReadDataFromExcelFile("Contacts", 1, 2);
		// Step 3: Create contacts with mandatory fields
		createContactPage ccp = new createContactPage(driver);
		wUtil.handleDropdown(ccp.getFirstNameDropdown(), "Mr.");
		ccp.getLastNameTextField().sendKeys(lastname);
		ccp.getSaveButton().click();
		Reporter.log("Contacts info page displayed successfully", true);

		// Step 4: Save and verify
		contactsInfoPage cip = new contactsInfoPage(driver);
		String a = cip.getContactsInformation().getText();
		assertTrue(a.contains(lastname));
		Reporter.log("Contacts created successfully --- Testcase Passed", true);
		assertFalse(true);
	}
}
