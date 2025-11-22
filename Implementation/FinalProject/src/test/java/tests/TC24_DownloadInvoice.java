package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.CheckoutPage;
import pages.HomePage;
import pages.InvoicePage;
import pages.PaymentPage;
import pages.Register;

public class TC24_DownloadInvoice extends TestBase {

	 HomePage home;
	 CheckoutPage checkout;
	 Register regobject;
	 CartPage cartObject;
	 CheckoutPage ChekoutObject;
	 PaymentPage PayObject;
    @Test
    public void downloadInvoice() throws InterruptedException {
    	 home = new HomePage(driver);
         checkout = new CheckoutPage(driver);
         regobject=new Register(driver);
         cartObject=new CartPage(driver);
         ChekoutObject=new CheckoutPage(driver);
         PayObject=new PaymentPage(driver);
         
         assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
         home.UserAddsTwoItemsToCart();
         home.OpenCart();
         assertEquals(home.Cart.getCssValue("color"), "rgb(255, 165, 0)");
         cartObject.UserCanProccedToCheckOut();
         cartObject.UserCanProccedtToRegister();
         home.OpenRegister();
         regobject.UserSignUpNewUser("amr", "amrdddvcadcap88ooqodd@gmail.com");
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
         home.OpenCart();
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
         
         
         assertEquals(checkout.ReviewOrder.getText(), "Review Your Order");
         wait.until(ExpectedConditions.visibilityOf(checkout.PlaceOrder));
         wait.until(ExpectedConditions.elementToBeClickable(checkout.PlaceOrder));
         checkout.makeComment("This is a comment");
         checkout.usercanPlaceOrder();
         PayObject.userCanFillPaymentDetaisl("amr ashraf", "5151515210515151", "454", "07", "2027");
         PayObject.userCanPayAndConfirmOrder();
         wait.until(ExpectedConditions.visibilityOf(PayObject.SucessPayment));
         wait.until(ExpectedConditions.elementToBeClickable(PayObject.SucessPayment));
         
         assertEquals(PayObject.SucessPayment.getText(), "ORDER PLACED!");
         PayObject.UserCanDownloadInvoices();
         //Thread.sleep(1000);
        // assertTrue(PayObject.isFileDownloaded("C:\\Users\\SIGMA\\Downloads", "invoice (1)"));
         PayObject.UserCanContinue();
         regobject.UserCanDeleteAccount();
         assertEquals(home.deleteSuccess.getText(), "ACCOUNT DELETED!");
         
    }
}
