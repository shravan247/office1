package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {

	public homePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	private WebElement contactsButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Organizations')]")
	private WebElement organizationButton;

	@FindBy(xpath = "//a[contains(text(),'Calendar')]")
	private WebElement calenderButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Leads')]")
	private WebElement leadsButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Products')]")
	private WebElement productsButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Documents')]")
	private WebElement documentsButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Email')]")
	private WebElement emailButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Trouble Tickets')]")
	private WebElement troubleTicketsButton;

	@FindBy(xpath = "//td[@class='tabUnSelected']//a[contains(text(),'Dashboard')]")
	private WebElement dashboardButton;

	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement logoutAdministratorButton;

	@FindBy(xpath = "//a[contains(text(),'Sign Out')]")
	private WebElement signoutButton;

	public WebElement getContactsButton() {
		return contactsButton;
	}

	public WebElement getOrganizationButton() {
		return organizationButton;
	}

	public WebElement getLogoutAdministratorButton() {
		return logoutAdministratorButton;
	}

	public WebElement getSignoutButton() {
		return signoutButton;
	}

	public WebElement getCalenderButton() {
		return calenderButton;
	}

	public WebElement getLeadsButton() {
		return leadsButton;
	}

	public WebElement getProductsButton() {
		return productsButton;
	}

	public WebElement getDocumentsButton() {
		return documentsButton;
	}

	public WebElement getEmailButton() {
		return emailButton;
	}

	public WebElement getTroubleTicketsButton() {
		return troubleTicketsButton;
	}

	public WebElement getDashboardButton() {
		return dashboardButton;
	}

}
