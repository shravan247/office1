package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationPage {

	public organizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createOrganizationButton;

	@FindBy(xpath = "//img[@title='Search in Organizations...']")
	private WebElement searchOrganizationButton;

	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchforTextfield;

	@FindBy(xpath = "//td[@class='small']//select[@name='search_field']")
	private WebElement inTextField;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchNowButton;

	public WebElement getCreateOrganizationButton() {
		return createOrganizationButton;
	}

	public WebElement getSearchOrganizationButton() {
		return searchOrganizationButton;
	}

	public WebElement getSearchforTextfield() {
		return searchforTextfield;
	}

	public WebElement getInTextField() {
		return inTextField;
	}

	public WebElement getSearchNowButton() {
		return searchNowButton;
	}

}
