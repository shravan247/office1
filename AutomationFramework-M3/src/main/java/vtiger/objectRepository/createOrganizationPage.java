package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class createOrganizationPage {

	public createOrganizationPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "accountname")
	private WebElement organizationTextField;

	@FindBy(name = "website")
	private WebElement websiteTextfield;

	@FindBy(name = "tickersymbol")
	private WebElement tickersymbolTextField;

	@FindBy(name = "account_name")
	private WebElement memberOfTextfield;

	@FindBy(xpath = "//td[@class='dvtCellInfo']//img[@style='cursor:hand;cursor:pointer']")
	private WebElement membweOfCreateIcon;

	@FindBy(name = "employees")
	private WebElement employeesTextField;

	@FindBy(name = "email2")
	private WebElement email2TextField;

	@FindBy(name = "phone")
	private WebElement phoneTextField;

	@FindBy(name = "email1")
	private WebElement email1TextField;

	@FindBy(name = "ownership")
	private WebElement ownershipTextField;

	@FindBy(name = "accounttype")
	private WebElement typeDropdown;

	@FindBy(name = "industry")
	private WebElement industryDropdown;

	@FindBy(xpath = "//input[@class='crmbutton small save']")
	private WebElement saveButton;

	@FindBy(xpath = "//input[@class='crmbutton small cancel']")
	private WebElement cancelButton;

	public WebElement getOrganizationTextField() {
		return organizationTextField;
	}

	public WebElement getWebsiteTextfield() {
		return websiteTextfield;
	}

	public WebElement getTickersymbolTextField() {
		return tickersymbolTextField;
	}

	public WebElement getMemberOfTextfield() {
		return memberOfTextfield;
	}

	public WebElement getMembweOfCreateIcon() {
		return membweOfCreateIcon;
	}

	public WebElement getEmployeesTextField() {
		return employeesTextField;
	}

	public WebElement getEmail2TextField() {
		return email2TextField;
	}

	public WebElement getPhoneTextField() {
		return phoneTextField;
	}

	public WebElement getEmail1TextField() {
		return email1TextField;
	}

	public WebElement getOwnershipTextField() {
		return ownershipTextField;
	}

	public WebElement getTypeDropdown() {
		return typeDropdown;
	}

	public WebElement getIndustryDropdown() {
		return industryDropdown;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}

	public WebElement getCancelButton() {
		return cancelButton;
	}

}
