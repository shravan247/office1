package vtiger.objectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import genericUtility.webDriverUtility;

public class loginPage {

	public loginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);

	}

	@FindBy(name = "user_name")
	private WebElement userNameTextField;

	@FindAll({ @FindBy(name = "user_password"), @FindBy(xpath = "//input[@type='password']") })
	private WebElement passwordTextField;

	@FindBy(id = "submitButton")
	private WebElement submitButton;

	public WebElement getUserNameTextField() {
		return userNameTextField;
	}

	public WebElement getPasswordTextField() {
		return passwordTextField;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	// we can also make use of "Business library"
	public void toLogin(String username, String password) {
		userNameTextField.sendKeys(username);
		passwordTextField.sendKeys(password);
		submitButton.click();
	}

}
