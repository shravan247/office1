package practice2Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import genericUtility.excelFileUtility;
import genericUtility.propertyFileUtility;
import genericUtility.webDriverUtility;

public class TocreateContactWithOrganization {

	public static void main(String[] args) throws Exception {

		excelFileUtility eUtility = new excelFileUtility();
		propertyFileUtility putiFileUtility = new propertyFileUtility();
		webDriverUtility wUtility = new webDriverUtility();

		String url = putiFileUtility.toReadDataFromPropertyFile("url");
		String browser = putiFileUtility.toReadDataFromPropertyFile("browser");
		String username = putiFileUtility.toReadDataFromPropertyFile("username");
		String password = putiFileUtility.toReadDataFromPropertyFile("password");

		// Step 1: To launch the browser
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		}

		wUtility.maximizeWindow(driver);
		wUtility.implicitlyWait(driver);
		// we are accessing using java-script executor
		wUtility.toAccessTheApplication(driver, url);

		// Step2: Login with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: navigate to contact links
		driver.findElement(By.linkText("Contacts")).click();

		// Step4 4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step5: Create contact with mandatory fields
		String lastName = eUtility.toReadDataFromExcelFile("Contacts", 1, 2);
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

		// Step 6: Select the organization look up image
		driver.findElement(By.xpath(
				"//input[@name='account_name']/parent::td[@class='dvtCellInfo']//img[@style='cursor:hand;cursor:pointer']"))
				.click();
		// switch to child window >>>>> we have built in method
		wUtility.toSwitchWindowTOChild(driver, "Accounts");
		// below lines to click on the organization name present in the child window

		String orgName = "wiprooo";
		driver.findElement(By.xpath("//a[contains(text(),'" + orgName + "')]")).click();

		// switch back to parent window
		wUtility.toSwitchWindowTOChild(driver, "Contacts");

		// Step 7: Save and verify
		driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
		String name = driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		if (name.contains(lastName)) {
			System.out.println(name + " - Test case Passed");
		} else {
			System.out.println("Test case failed");
		}

		// Logout we can use our utility method
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		wUtility.toMouseHover(driver, logout);
		driver.findElement(By.linkText("Sign Out")).click();

		// lets flash the text field using java-script executor
		WebElement usernamee = driver.findElement(By.name("user_name"));
		wUtility.toFlashTheWebelement(driver, usernamee);
	}
}
