package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
//https://github.com/DebugDemon1709/demo_Ecom.git
public class BasePage {
	WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
