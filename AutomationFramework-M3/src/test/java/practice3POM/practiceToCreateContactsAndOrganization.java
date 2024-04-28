package practice3POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;
import vtiger.objectRepository.loginPage;

public class practiceToCreateContactsAndOrganization {

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
		loginPage lp = new loginPage(driver);
		lp.getUserNameTextField().sendKeys(username);
		lp.getPasswordTextField().sendKeys(password);
		lp.getSubmitButton().click();

	}

}
