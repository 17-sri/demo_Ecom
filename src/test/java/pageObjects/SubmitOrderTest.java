package pageObjects;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//lecture 152
public class SubmitOrderTest {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		String productName = "ZARA COAT 3";
		System.setProperty("webdriver.chrome.driver", "C:\\selenium\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		//WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		LandingPage landingPage = new LandingPage(driver);
		landingPage.goTo();
		ProductCatalogue productCatalogue = landingPage.loginApllication("srikanthv1709@gmail.com", "Selenium@123");
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);//if item is present, then match is true, then assertion is true
	    CheckoutPage checkoutPage = cartPage.goToCheckout();
	    checkoutPage.countrySelect("India");
	    ConfirmationPage confirmationPage = checkoutPage.submitOrder();
	    String confirmMessage = confirmationPage.getConfirmationMesage();
	    Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	    driver.quit();		
	}
}











