package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createContactPage {

	public createContactPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='lastname']")
	private WebElement lastNameTextField;

	@FindBy(name = "salutationtype")
	private WebElement firstNameDropdown;

	@FindBy(name = "firstname")
	private WebElement firstNameTextField;

	@FindBy(name = "account_name")
	private WebElement organizationNameTextField;

	@FindBy(xpath = "//input[@name='account_name']/parent::td[@class='dvtCellInfo']//img[@style='cursor:hand;cursor:pointer']")
	private WebElement createOrganizationNameButton;

	@FindBy(name = "leadsource")
	private WebElement leadSourceDropdown;

	@FindBy(name = "title")
	private WebElement titleTextField;

	@FindBy(name = "department")
	private WebElement departmentTextField;

	@FindBy(name = "email")
	private WebElement emailTextField;

	@FindBy(name = "assistant")
	private WebElement assistantTextField;

	@FindBy(name = "assistantphone")
	private WebElement assistantphoneTextField;

	@FindBy(xpath = "//input[@class='crmButton small save']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelButton;

	public WebElement getLastNameTextField() {
		return lastNameTextField;
	}

	public WebElement getFirstNameDropdown() {
		return firstNameDropdown;
	}

	public WebElement getFirstNameTextField() {
		return firstNameTextField;
	}

	public WebElement getOrganizationNameTextField() {
		return organizationNameTextField;
	}

	public WebElement getCreateOrganizationNameButton() {
		return createOrganizationNameButton;
	}

	public WebElement getLeadSourceDropdown() {
		return leadSourceDropdown;
	}

	public WebElement getTitleTextField() {
		return titleTextField;
	}

	public WebElement getDepartmentTextField() {
		return departmentTextField;
	}

	public WebElement getEmailTextField() {
		return emailTextField;
	}

	public WebElement getAssistantTextField() {
		return assistantTextField;
	}

	public WebElement getAssistantphoneTextField() {
		return assistantphoneTextField;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

}
