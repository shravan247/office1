package practice3POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.excelFileUtility;
import genericUtility.javaUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;
import vtiger.objectRepository.createOrganizationPage;
import vtiger.objectRepository.homePage;
import vtiger.objectRepository.loginPage;
import vtiger.objectRepository.organizationInfoPage;
import vtiger.objectRepository.organizationPage;

public class practice4 {

	//Scenario 4
	public static void main(String[] args) throws Exception {
		excelFileUtility eUtil = new excelFileUtility();
		propertyFileUtility pUtil = new propertyFileUtility();
		webDriverUtility wUtil = new webDriverUtility();
		javaUtility jUtil = new javaUtility();

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

		// Step 3: Navigate to organization link
		homePage hp = new homePage(driver);
		hp.getOrganizationButton().click();

		// Step 4: Click on organization look up image
		organizationPage op = new organizationPage(driver);
		op.getCreateOrganizationButton().click();

		String orgName = eUtil.toReadDataFromExcelFile("Organization", 1, 2);
		int random = jUtil.toGetRandomNumber();
		// Step 5: Create organization with mandatory fields
		createOrganizationPage cop = new createOrganizationPage(driver);

		cop.getOrganizationTextField().sendKeys(orgName + random);

		// Step 6: Select "Chemicals" in the industry drop down
		wUtil.handleDropdown(cop.getIndustryDropdown(), "Energy");
		// Step 7: Select "Customer" in the type drop down
		wUtil.handleDropdown(cop.getTypeDropdown(), "Customer");
		cop.getSaveButton().click();

		// Step 8: Save and verify
		organizationInfoPage oip = new organizationInfoPage(driver);
		String info = oip.getContactsInformation().getText();
		if (info.contains(orgName)) {
			System.out.println("Organization created -- Testcase Passed");
		} else {
			System.out.println("Test case failed");
		}
		
		

		// Step 9: Logout
		wUtil.toMouseHover(driver, hp.getLogoutAdministratorButton());
		hp.getSignoutButton().click();
	}
}
