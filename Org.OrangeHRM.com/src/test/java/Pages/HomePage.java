package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

	WebDriver driver;
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
	}
	
	@FindBy(xpath = "//p[@class='oxd-userdropdown-name']")
	WebElement paulsamButton;
	
	public void clickPaulsam() {
		
		paulsamButton.click();
	}
}
