package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.CartPage;
import pageObjects.CheckoutPage;
import pageObjects.ConfirmationPage;
import pageObjects.OrdersPage;
import pageObjects.ProductCatalogue;
import testComponents.BaseClass;

public class SubmitOrderTest extends BaseClass {
	
	@Test
	public void submitOrder() throws IOException {
		String productName = getProductNameFromProperties();
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		productCatalogue.getProductList();
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
		String productName = getProductNameFromProperties();
		ProductCatalogue productCatalogue = landingPage.loginAplication("srikanthv1709@gmail.com", "Selenium@123");
		OrdersPage ordersPage = productCatalogue.goToOrdersPage();
		Assert.assertTrue(ordersPage.VerifyOrderDisplay(productName));
	}
}