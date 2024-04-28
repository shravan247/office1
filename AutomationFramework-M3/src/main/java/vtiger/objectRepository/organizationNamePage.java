package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationNamePage {

	public organizationNamePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='javascript:window.close();']")
	private WebElement organizationNames;

	public WebElement getOrganizationNames() {
		return organizationNames;
	}

}
