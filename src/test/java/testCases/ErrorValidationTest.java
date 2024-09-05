package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class ErrorValidationTest extends BaseClass {
String productName = "ZARA COAT 3";//lecture 167
	@Test(groups ={"ErrorHandling"})   //error validation with invalid password     
	public void LoginErrorValidation() throws IOException {
		landingPage.loginAplication("srikanthv1709@gmail.com", "S..elenium@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	@Test(groups ={"ErrorHandling"})
	public void ProductErrorValidation() {
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		@SuppressWarnings("unused")// this is just a warning
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA ZARA");//error validation with invalid productName
		Assert.assertFalse(match);
	}
}