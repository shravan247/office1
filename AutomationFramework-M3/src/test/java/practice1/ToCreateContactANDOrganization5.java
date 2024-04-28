package practice1;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToCreateContactANDOrganization5 {
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

		// Step 3: navigate to contact links
		driver.findElement(By.linkText("Contacts")).click();

		// Step4 4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		// Step5: Create contact with mandatory fields
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("shetty");

		// Step 6: Select the organization look up image
		driver.findElement(By.xpath(
				"//input[@name='account_name']/parent::td[@class='dvtCellInfo']//img[@style='cursor:hand;cursor:pointer']"))
				.click();
		// switch to child window
		String parentId = driver.getWindowHandle();
		Set<String> allIds = driver.getWindowHandles();

		for (String childId : allIds) {
			if (!(parentId.equals(childId))) {
				driver.switchTo().window(childId);
			}
		}

		String orgName = "wiprooo";
		driver.findElement(By.xpath("//a[contains(text(),'" + orgName + "')]")).click();

		// switch back to parent window
		driver.switchTo().window(parentId);

		// Step 7: Save and verify
		driver.findElement(By.cssSelector("[class='crmButton small save']")).click();
		String name = driver.findElement(By.cssSelector("[class='dvHeaderText']")).getText();
		if (name.contains("shetty")) {
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
