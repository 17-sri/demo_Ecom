package testCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class SubmitOrderTest extends BaseClass {
	String productName = "ZARA COAT 3";
	@Test
	public void submitOrder() throws IOException {
		
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		@SuppressWarnings("unused")// this is just a warning
		List<WebElement> products = productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);
		CartPage cartPage = productCatalogue.goToCartPage();
		Boolean match = cartPage.verifyProductDisplay(productName);
		Assert.assertTrue(match);
		CheckoutPage checkoutPage = cartPage.goToCheckout();
		checkoutPage.countrySelect("India");
		ConfirmationPage confirmationPage = checkoutPage.submitOrder();
		String confirmMessage = confirmationPage.getConfirmationMesage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase("Thankyou for the order."));
	}
	@Test(dependsOnMethods = {"submitOrder"})
	public void OrderHistory() {
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
}