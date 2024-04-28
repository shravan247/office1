package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class organizationInfoPage {

	public organizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//span[@class='dvHeaderText']")
	private WebElement contactsInformation;

	@FindBy(name = "Edit")
	private WebElement editButton;

	@FindBy(name = "Duplicate")
	private WebElement duplicateButton;

	@FindBy(name = "Delete")
	private WebElement deleteButton;
	
	@FindBy(xpath = "(//td[@class='dvtCellInfo'])[1]")
	private WebElement organizationName;

	public WebElement getOrganizationName() {
		return organizationName;
	}

	public WebElement getContactsInformation() {
		return contactsInformation;
	}

	public WebElement getEditButton() {
		return editButton;
	}

	public WebElement getDuplicateButton() {
		return duplicateButton;
	}

	public WebElement getDeleteButton() {
		return deleteButton;
	}
}
