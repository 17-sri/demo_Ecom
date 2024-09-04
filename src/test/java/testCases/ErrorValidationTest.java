package testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import testComponents.BaseClass;

public class ErrorValidationTest extends BaseClass {
//lecture 167
	@Test          //error validation with wrong password
	public void submitOrder() throws IOException {
		landingPage.loginApllication("srikanthv1709@gmail.com", "S..elenium@123");
		Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
	}
}