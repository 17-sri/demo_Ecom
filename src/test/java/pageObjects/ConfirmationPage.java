package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ConfirmationPage extends AbstractComponents {

	public ConfirmationPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = ".hero-primary")
	WebElement confirmMsg;
	
	public String getConfirmationMesage() {
		return confirmMsg.getText();
	}
	
	
	

}
