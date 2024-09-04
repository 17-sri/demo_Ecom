package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends AbstractComponents {
	Actions action = new Actions(driver);
	public CheckoutPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = "[placeholder='Select Country']")
	WebElement country;
	@FindBy(xpath = "(//button[@type='button'])[2]")
	WebElement selectCountry;
	@FindBy(xpath = "//a[normalize-space()='Place Order']")
	WebElement submit;
	By result = By.cssSelector(".ta-results");
	
	public void countrySelect(String countryName) {
		action.sendKeys(country, countryName).build().perform();
		waitForElementToAppear(result);
		selectCountry.click();
	}
	public ConfirmationPage submitOrder() {
		submit.click();
		return new ConfirmationPage(driver);
		
	}
	// WebElement checkout = driver.findElement(By.cssSelector(".totalRow button"));
    //checkout.sendKeys(Keys.PAGE_DOWN);checkout.click();
	

}
