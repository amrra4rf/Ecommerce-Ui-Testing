package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.Register;

public class TC16_PlaceOrderLoginThenCheckout  extends TestBase{
    HomePage home ;
    Register login;
    ProductPage products;
    CartPage cart;
    PaymentPage pay;
    CheckoutPage checkout;
    
    
  @Test
  public void LoginBeforeCheckout() {
	  home = new HomePage(driver);
	  login = new Register(driver);
	  products =new ProductPage(driver);
	  cart=new CartPage(driver);
	  checkout=new CheckoutPage(driver);
	  pay=new PaymentPage(driver);
	  assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");
	  home.OpenRegister();
	  login.login("amr2000000000004@gmail.com", "12345678");
	  assertEquals(home.LoggedInAs.getText(),"Logged in as amr"); 
	  products.add3Items();
	  home.OpenCart();
	  assertEquals(home.Cart.getCssValue("color"), "rgb(255, 165, 0)");
	  cart.UserCanProccedToCheckOut();
	 
      WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      wait.until(ExpectedConditions.visibilityOf(checkout.Add1Billing));
      wait.until(ExpectedConditions.elementToBeClickable(checkout.Add1Billing));
      assertEquals(checkout.Add1Billing.getText(), "Cairo");
      assertEquals(checkout.Add1delivery.getText(), "Cairo");
      
      assertEquals(checkout.add2billing.getText(), "Street 5");
      assertEquals(checkout.add2delivery.getText(), "Street 5");
      
      assertEquals(checkout.Cntrybilling.getText(), "United States");
      assertEquals(checkout.Cntrydelviery.getText(), "United States");
      
      assertEquals(checkout.CityStateZipbilling.getText(), "Dallas Texas 9000");
      assertEquals(checkout.CityStateZipdelivery.getText(), "Dallas Texas 9000");
      
      checkout.makeComment("This order is amazing");
      checkout.usercanPlaceOrder();
      pay.userCanFillPaymentDetaisl("amr ashraf", "5151515210515151", "454", "07", "2027");
      pay.userCanPayAndConfirmOrder();
      wait.until(ExpectedConditions.visibilityOf(pay.SucessPayment));
      wait.until(ExpectedConditions.elementToBeClickable(pay.SucessPayment));
      
      assertEquals(pay.SucessPayment.getText(), "ORDER PLACED!");
      login.UserCanDeleteAccount();
      assertEquals(login.AccountDeleted.getText(), "ACCOUNT DELETED!");
	  
	  
  }
}
