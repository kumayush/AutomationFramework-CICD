
package stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import TestComponents.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageOjects.CartPage;
import pageOjects.CheckoutPage;
import pageOjects.ConfirmationPage;
import pageOjects.LandingPage;
import pageOjects.ProductCatalogue;

public class StepDefinitionImpl extends BaseTest {

	public LandingPage landingpage;
	public ProductCatalogue productCatalogue;
	public ConfirmationPage confirmationPage;
	@Given("I landed on the ecommerce page")
	
	public void I_landed_on_the_ecommerce_page() throws IOException
	{
		landingpage=launchApplication();
	}
	
	@Given ("^Logged in with username(.+) and password (.+)$")
	public void logged_in_username_and_password(String username,String password ) 
	{
	 productCatalogue=landingpage.loginApplication(username,password);
	}
	
	@When("^I add the product(.+) to cart$")
	public void i_add_product_to_cart(String productName) throws InterruptedException
	{
		List<WebElement> products=productCatalogue.getProductList();
		productCatalogue.addProductToCart(productName);	
	}
	
	@When("^checkout (.+) and submit the order$")
	public void checkout_submit_order(String productname) throws InterruptedException 
	{
		CartPage cartpage=productCatalogue.goToCartPage();
		Boolean match= cartpage.VerifyProductDisplay(productname);
       Assert.assertTrue(match);
       CheckoutPage checkoutPage =cartpage.goToCheckout();
       checkoutPage.selectCountry("india");
       confirmationPage=checkoutPage.submitOrder();
	}
	
	@Then("{string} message is displayed on the confirmation page")
	public void message_is_displayed_confirmation_page(String string)
	{
		String confirmMessage=   confirmationPage.getConfirmationMessage();
		Assert.assertTrue(confirmMessage.equalsIgnoreCase(string));
		driver.close();
	}
	
	
}
