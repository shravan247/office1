package practice1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ToCreateOrganization4 {
	public static void main(String[] args) {
		// Step1: Launch the browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");

		// Step2: Login with valid credentials
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("password");
		driver.findElement(By.id("submitButton")).click();

		// Step 3: navigate to organization links
		driver.findElement(By.linkText("Organizations")).click();

		// Step 4 : Click on create organization look up page
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		// Step 5: create organization with mandatory field
		driver.findElement(By.name("accountname")).sendKeys("wiprooo");

		// Step 6: Select "Chemicals" in the industry drop-down and select type=Customer 
		WebElement industryDropdown = driver.findElement(By.name("industry"));
		Select s = new Select(industryDropdown);
		s.selectByValue("Energy");
		WebElement typedropdown=driver.findElement(By.name("accounttype"));
		Select s1=new Select(typedropdown);
		s1.selectByValue("Customer");

		// Step 6:Save and verify
		driver.findElement(By.xpath("//input[@class='crmbutton small save']")).click();
		String name = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if (name.contains("wip")) {
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
