package pageObjects;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CartPage extends AbstractComponents {

	public CartPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	@FindBy(css = ".cartSection h3")
	private List<WebElement> cartProducts;
	
	public Boolean verifyProductDisplay(String productName) {
		Boolean match = cartProducts.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	
	public CheckoutPage goToCheckout() {
		checkoutEle.sendKeys(Keys.PAGE_DOWN);
		checkoutEle.click();
		return new CheckoutPage(driver);
	}	
}
