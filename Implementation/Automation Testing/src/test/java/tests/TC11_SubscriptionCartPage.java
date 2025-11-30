package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TC11_SubscriptionCartPage extends TestBase {
	HomePage homeObject;
	CartPage cartObject;
  @Test
  public void TestSubscrptionCartWithValidEmail() {
	  homeObject=new HomePage(driver);
	  cartObject=new CartPage(driver);
	  homeObject.OpenCart();
	  assertEquals(homeObject.Cart.getCssValue("color"), "rgb(255, 165, 0)");
	  
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", cartObject.subscrptionEmail);
	  assertEquals(cartObject.subscription.getText(), "SUBSCRIPTION");//made sure subscription appears correctly
	  cartObject.subscrptionEmail.sendKeys("amrAshraf@gmail.com");
	  cartObject.subscrptionBtn.click();
	  assertEquals(cartObject.successMessage.getText(), "You have been successfully subscribed!");//make sure subscription is done successfully
	  
  }
}
