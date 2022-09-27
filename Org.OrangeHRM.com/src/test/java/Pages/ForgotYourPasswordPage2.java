package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgotYourPasswordPage2 {

	WebDriver driver;

	public ForgotYourPasswordPage2(WebDriver driver) {

		this.driver = driver;
	}

	// 2nd way

	private By username_Textbox = By.xpath("//input[@name='username']");

	private By cancel_Button = By.xpath("//button[@type='button']");

	private By submit_Button = By.xpath("//button[@type='submit']");

	public void enterUserName() {

		driver.findElement(username_Textbox).sendKeys("Saag");
	}

	public void clickCancel() {

		driver.findElement(cancel_Button).click();
	}

	public void clickSubmit() {

		driver.findElement(submit_Button).click();
	}

}
