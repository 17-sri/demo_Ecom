package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LandingPage extends AbstractComponents {
	
	public LandingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(id = "userEmail")//158
	WebElement userEmail;
	@FindBy(id = "userPassword")
	WebElement password;
	@FindBy(id = "login")
	WebElement btnSubmit;
	
	public ProductCatalogue loginApllication(String email, String pwd) {
		userEmail.sendKeys(email);
		password.sendKeys(pwd);
		btnSubmit.submit();
		ProductCatalogue productCatalogue = new ProductCatalogue(driver);
		return productCatalogue;
	}
	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	
	
	
	

}
