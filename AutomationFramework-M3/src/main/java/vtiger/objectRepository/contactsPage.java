package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class contactsPage {

	public contactsPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createContactButton;

	@FindBy(xpath = "//img[@title='Search in Contacts...']")
	private WebElement searchContactsButton;

	@FindBy(xpath = "//input[@class='txtBox']")
	private WebElement searchforTextfield;

	@FindBy(xpath = "//td[@class='small']//select[@name='search_field']")
	private WebElement inTextField;

	@FindBy(xpath = "//input[@name='submit']")
	private WebElement searchNowButton;

	public WebElement getCreateContactButton() {
		return createContactButton;
	}

	public WebElement getSearchContactsButton() {
		return searchContactsButton;
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
