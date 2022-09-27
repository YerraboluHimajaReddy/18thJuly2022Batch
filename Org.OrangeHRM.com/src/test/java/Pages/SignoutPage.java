package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class SignoutPage {

	WebDriver driver;

	public SignoutPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//a[text()='About']")
	public WebElement aboutButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Support']")
	public WebElement supportButton;

	@FindBy(how = How.XPATH, using = "//a[text()='Change Password']")
	public WebElement changePasswordButton;

	@CacheLookup
	@FindBy(how = How.XPATH, using = "//a[text()='Logout']")
	public WebElement logoutButton;

	public void clickAbout() {

		aboutButton.click();
	}

	public void clickSupport() {

		supportButton.click();
	}

	public void clickChangePassword() {

		changePasswordButton.click();
	}

	public void clickLogout() {

		logoutButton.click();
	}

}
