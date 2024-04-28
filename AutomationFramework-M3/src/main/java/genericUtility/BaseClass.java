package genericUtility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import vtiger.objectRepository.homePage;
import vtiger.objectRepository.loginPage;

public class BaseClass {

	public propertyFileUtility pUtil = new propertyFileUtility();
	public webDriverUtility wUtil = new webDriverUtility();
	public WebDriver driver = null;
	// for listeners we have to only static web driver, since all the there are not static methods its a rule
	public static WebDriver sDriver;

	@BeforeSuite(groups = { "smoke", "regression" })
	public void beforeSuiteConfiguration() {
		Reporter.log("---Database connection established---", true);
	}

	// @Parameters("browser")
	// @BeforeTest
	@BeforeClass(groups = { "smoke", "regression" })
	public void beforeClassConfiguration(/* String browser */) throws Exception {
		String browser = pUtil.toReadDataFromPropertyFile("browser");
		String url = pUtil.toReadDataFromPropertyFile("url");
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}
		sDriver = driver;//listeners
		wUtil.maximizeWindow(driver);
		wUtil.implicitlyWait(driver);
		driver.get(url);
	}

	@BeforeMethod(groups = { "smoke", "regression" })
	public void beforeMethodConfiguration() throws Exception {
		String username = pUtil.toReadDataFromPropertyFile("username");
		String password = pUtil.toReadDataFromPropertyFile("password");
		loginPage lp = new loginPage(driver);
		// we can use business library or call username and password separately
		lp.toLogin(username, password);
	}

	@AfterMethod(groups = { "smoke", "regression" })
	public void afterMethodConfiguration() {
		homePage hp = new homePage(driver);
		wUtil.toMouseHover(driver, hp.getLogoutAdministratorButton());
		hp.getSignoutButton().click();
	}

	@AfterClass(groups = { "smoke", "regression" })
	public void afterClassConfiguration() throws Exception {
		Thread.sleep(1000);
		driver.quit();

	}

	@AfterSuite(groups = { "smoke", "regression" })
	public void afterSuiteConfiguration() {
		Reporter.log("---Disconnecting from DataBase---", true);
	}
}
