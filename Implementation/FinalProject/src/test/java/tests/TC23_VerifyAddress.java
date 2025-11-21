package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Register;
import pages.CartPage;
import pages.CheckoutPage;

public class TC23_VerifyAddress extends TestBase {
	 HomePage home;
	 CheckoutPage checkout;
	 Register regobject;
	 CartPage cartObject;
	 CheckoutPage ChekoutObject;
	 
    @Test
    public void verifyAddress() {
         home = new HomePage(driver);
         checkout = new CheckoutPage(driver);
         regobject=new Register(driver);
         cartObject=new CartPage(driver);
         ChekoutObject=new CheckoutPage(driver);
         
         home.OpenRegister();
         regobject.UserSignUpNewUser("amr", "amr2e213s2csa3e@gmail.com");
         regobject.UserInfo("12345678",     // pass
	        	    "15",           // day
	        	    "July",           // month
	        	    "2002",         // year
	        	    "Guest",        // first name
	        	    "User",         // last name
	        	    "Cairo",        // address 1
	        	    "Street 5",     // address 2
	        	    "United States",// country
	        	    "Texas",        // state
	        	    "Dallas",       // city
	        	    "9000",         // zip
	        	    "0123444555",   // mobile
	        	    "uni"       );    // company);
         
         assertEquals(regobject.AccountMade.getText(), "ACCOUNT CREATED!");
         regobject.UserCanContinueAccount();
         
         assertEquals(regobject.username.getText(), "Logged in as amr");
         
         assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
         home.UserAddsTwoItemsToCart();
         home.OpenCart();
         assertEquals(home.Cart.getCssValue("color"), "rgb(255, 165, 0)");
         cartObject.UserCanProccedToCheckOut();
         
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
         
         regobject.UserCanDeleteAccount();
         
         assertEquals(home.deleteSuccess.getText(), "ACCOUNT DELETED!");
         
         
    }
}
