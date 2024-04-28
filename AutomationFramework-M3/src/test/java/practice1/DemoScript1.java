package practice1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScript1 {

	public static void main(String[] args) throws Exception {
		// to read data from properties file
		FileInputStream f = new FileInputStream(".\\src\\test\\resources\\commonData.properties");
		Properties p = new Properties();
		p.load(f);
		String url = p.getProperty("url");
		String browser = p.getProperty("browser");
		String username = p.getProperty("username");
		String password = p.getProperty("password");

		// to read data from excel
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\testData.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		String lastName = book.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
		String orgName = book.getSheet("Organization").getRow(1).getCell(2).getStringCellValue();

		// Step1: Launch the browser
		WebDriver driver = null;
		if (browser.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		// Step2: Login with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: navigate to contact links
		driver.findElement(By.linkText("Contacts")).click();

		// Step4 4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step5: Create contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

		// Step 6: Save and verify
		driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
		String name = driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		if (name.contains(lastName)) {
			System.out.println(name + " - Test case Passed");
		} else {
			System.out.println("Test case failed");
		}

		// Logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
