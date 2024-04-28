package practice1;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class DemoScript2Organization {

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
		// String lastName =
		// book.getSheet("Contacts").getRow(1).getCell(2).getStringCellValue();
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

		// Step1: Launch the browser
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(url);

		// Step2: Login with valid credentials
		driver.findElement(By.name("user_name")).sendKeys(username);
		driver.findElement(By.name("user_password")).sendKeys(password);
		driver.findElement(By.id("submitButton")).click();

		// Step 3: navigate to organization links
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4 : Click on create organization look up page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// to create random number
		Random r = new Random();
		int random = r.nextInt(1000);

		// Step 5: create organization with mandatory field
		driver.findElement(By.name("accountname")).sendKeys(orgName + random);

		// Step 6:Save and verify
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains(orgName + random)) {
			System.out.println(name + " - Testcase passed");
		} else {
			System.out.println("Test Case failed");
		}

		// Logout
		WebElement logout = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		Actions act = new Actions(driver);
		act.moveToElement(logout).perform();
		driver.findElement(By.linkText("Sign Out")).click();
	}
}
