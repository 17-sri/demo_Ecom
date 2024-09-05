package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrdersPage extends AbstractComponents {
//lecture 169
	public OrdersPage(WebDriver driver) {
		super(driver);
	}
	@FindBy(css = ".totalRow button")
	WebElement checkoutEle;
	@FindBy(css = "tr td:nth-child(3)")
	private List<WebElement> productNames;
	
	public Boolean VerifyOrderDisplay(String productName) {
		Boolean match = productNames.stream().anyMatch(product->product.getText().equalsIgnoreCase(productName));
		return match;
	}
	

}
