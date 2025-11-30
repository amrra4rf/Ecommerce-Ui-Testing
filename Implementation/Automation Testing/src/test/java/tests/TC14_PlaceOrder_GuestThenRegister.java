package tests;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.PaymentPage;
import pages.ProductPage;
import pages.Register;


public class TC14_PlaceOrder_GuestThenRegister extends TestBase {

    @Test
    public void testPlaceOrderAsGuestThenRegister() {

        HomePage home = new HomePage(driver);
        ProductPage products = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        Register reg = new Register(driver);
        PaymentPage pay = new PaymentPage(driver);

       
        home.OpenProducts();;
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", products.addToCartBtnFirst);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(products.firstProduct));
        wait.until(ExpectedConditions.elementToBeClickable(products.firstProduct));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", products.addToCartBtnFirst);
        wait.until(ExpectedConditions.visibilityOf(products.viewCartBtn));
        wait.until(ExpectedConditions.elementToBeClickable(products.viewCartBtn));

        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", products.viewCartBtn);
        wait.until(ExpectedConditions.visibilityOf(cart.proccedToCheckout));
        wait.until(ExpectedConditions.elementToBeClickable(cart.proccedToCheckout));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", cart.proccedToCheckout);
      
        cart.UserCanProccedtToRegister();

        reg.UserSignUpNewUser("GuestUser", "guest7999cacmascscv66"+random.nextInt(999999999)+"csacsacascascac4999@test.com");
        reg.UserInfo(
        	    "12345678",     // pass
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
        	    "uni"           // company
        	);
        reg.UserCanContinueAccount();
        home.OpenCart();
        cart.UserCanProccedToCheckOut();
        pay.PlaceOrder1();
        pay.userCanFillPaymentDetaisl("GuestUser", "1111222233334444", "333", "11", "2027");
        pay.userCanPayAndConfirmOrder();
        pay.SucessPayment();
        Assert.assertEquals(pay.SucessPayment.getText(), "ORDER PLACED!");
    }
}


