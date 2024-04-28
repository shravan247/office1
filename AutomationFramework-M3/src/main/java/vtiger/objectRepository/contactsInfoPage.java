package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsInfoPage {

	public contactsInfoPage(WebDriver driver) {
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
