package vtiger.contactTests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

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

//scenario 5
public class toCreateContact5Test extends BaseClass {
	@Test (groups = "regression")
	public void tocreateContact_005() throws Exception {
		//we are using all the login logout in base class

		excelFileUtility eUtil = new excelFileUtility();

		// Step 1: Navigate to contacts link
		homePage hp = new homePage(driver);
		hp.getContactsButton().click();
		Reporter.log("Contacts page is displayed successfully", true);

		// Step 2: click on Create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.getCreateContactButton().click();
		Reporter.log("Create contacts page is displayed successfully", true);

		String lastname = eUtil.toReadDataFromExcelFile("Contacts", 1, 2);
		String organization = eUtil.toReadDataFromExcelFile("Organization", 1, 2);
		// Step 3: Create contacts with mandatory fields
		createContactPage ccp = new createContactPage(driver);
		wUtil.handleDropdown(ccp.getFirstNameDropdown(), "Mr.");
		ccp.getLastNameTextField().sendKeys(lastname);

		// Step 4: Select organization from organization look up image
		ccp.getCreateOrganizationNameButton().click();
		// switch driver control
		wUtil.toSwitchWindowTOChild(driver, "Accounts");

		// to click on child window orgname
		String ORG = "wipro";
		driver.findElement(By.xpath("//a[contains(text(),'" + ORG + "')]")).click();
		// switch back
		wUtil.toSwitchWindowTOChild(driver, "Contacts");
		ccp.getSaveButton().click();
		Reporter.log("Contacts info page displayed successfully", true);

		// Step 5: Save and verify
		contactsInfoPage cip = new contactsInfoPage(driver);
		String a = cip.getContactsInformation().getText();
		assertTrue(a.contains(lastname));
		Reporter.log("Contact created successfully", true);

	}
}
