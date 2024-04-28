package practice3POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;
import vtiger.objectRepository.contactsInfoPage;
import vtiger.objectRepository.contactsPage;
import vtiger.objectRepository.createContactPage;
import vtiger.objectRepository.homePage;
import vtiger.objectRepository.loginPage;

//Scenario 1 end to end
public class practice1 {

	public static void main(String[] args) throws Exception {

		excelFileUtility eUtil = new excelFileUtility();
		propertyFileUtility pUtil = new propertyFileUtility();
		webDriverUtility wUtil = new webDriverUtility();

		String url = pUtil.toReadDataFromPropertyFile("url");
		String browser = pUtil.toReadDataFromPropertyFile("browser");
		String username = pUtil.toReadDataFromPropertyFile("username");
		String password = pUtil.toReadDataFromPropertyFile("password");

		// Step 1: To launch the browser
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		wUtil.maximizeWindow(driver);
		wUtil.implicitlyWait(driver);
		// we are accessing using java-script executor
		wUtil.toAccessTheApplication(driver, url);

		// To login we have to make use of POM scripts
		// Step 2: login with valid credentials
		loginPage lp = new loginPage(driver);
		lp.getUserNameTextField().sendKeys(username);
		lp.getPasswordTextField().sendKeys(password);
		lp.getSubmitButton().click();

		// Step 3: Navigate to contacts link
		homePage hp = new homePage(driver);
		hp.getContactsButton().click();

		// Step 4: click on Create contact look up image
		contactsPage cp = new contactsPage(driver);
		cp.getCreateContactButton().click();

		String lastname = eUtil.toReadDataFromExcelFile("Contacts", 1, 2);
		// Step 5: Create contacts with mandatory fields
		createContactPage ccp = new createContactPage(driver);
		wUtil.handleDropdown(ccp.getFirstNameDropdown(), "Mr.");
		ccp.getLastNameTextField().sendKeys(lastname);
		ccp.getSaveButton().click();

		// Step 6: Save and verify
		contactsInfoPage cip = new contactsInfoPage(driver);
		String a = cip.getContactsInformation().getText();
		if (a.contains(lastname)) {
			System.out.println("Conatcts created -- Test case Passed");
		} else {
			System.out.println("Test case failed");
		}
		// Step 7: Logout of application
		wUtil.toMouseHover(driver, hp.getLogoutAdministratorButton());
		hp.getSignoutButton().click();
	}

}
