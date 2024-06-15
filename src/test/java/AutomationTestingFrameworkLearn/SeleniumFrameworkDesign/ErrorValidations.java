package AutomationTestingFrameworkLearn.SeleniumFrameworkDesign;

import io.github.bonigarcia.wdm.WebDriverManager;
import pageOjects.CartPage;
import pageOjects.CheckoutPage;
import pageOjects.ConfirmationPage;
import pageOjects.LandingPage;
import pageOjects.ProductCatalogue;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import TestComponents.BaseTest;

public class ErrorValidations extends BaseTest {

	
	@Test(groups= {"ErrorHandling"},retryAnalyzer=TestComponents.Retry.class)
	public void LoginErrorValidation() throws IOException, InterruptedException{
		//we can download webdriverManager dependency to automatically invoke browser without 
//setting up the property
		//String productName = "ZARA COAT 3";
		landingpage.loginApplication("INvalid@invalid.com", "Iamki000");
		Assert.assertEquals("Incorrect email  password.", landingpage.getErrorMessage());
		
	}
		
		@Test
		public void ProductErrorValidation() throws IOException, InterruptedException
		{

			String productName = "ZARA COAT 3";
			ProductCatalogue productCatalogue = landingpage.loginApplication("lid@invalid.com","Test@1234");
			List<WebElement> products = productCatalogue.getProductList();
			productCatalogue.addProductToCart(productName);
			CartPage cartPage = productCatalogue.goToCartPage();
			Boolean match = cartPage.VerifyProductDisplay("ZARA COAT 33");
			Assert.assertFalse(match);
			
		

		}


	
	
		
	



	}


