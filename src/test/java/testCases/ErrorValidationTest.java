package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;
import testComponents.Retry;;

public class ErrorValidationTest extends BaseClass {
	String productName = getProductNameFromProperties();
	@Test(groups ={"ErrorHandling"},retryAnalyzer=Retry.class)   //error validation with invalid password     
	public void LoginErrorValidation() throws IOException {
		landingPage.loginAplication("srikanthv1709@gmail.com", "S..elenium@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
	
	@Test(groups ={"ErrorHandling"})
	public void ProductErrorValidation() {
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay("ZARA ZARA");//error validation with invalid productName
		Assert.assertTrue(match);
	}
}