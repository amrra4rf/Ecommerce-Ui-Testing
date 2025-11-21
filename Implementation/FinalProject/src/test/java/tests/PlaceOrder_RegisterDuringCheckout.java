package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;

public class PlaceOrder_RegisterDuringCheckout extends TestBase {

    @Test
    public void testPlaceOrderAfterRegister() {

        HomePage home = new HomePage(driver);
        ProductPage products = new ProductPage(driver);
        CartPage cart = new CartPage(driver);
        Register reg = new Register(driver);
        PaymentPage pay = new PaymentPage(driver);

      
        home.OpenRegister();
        reg.UserSignUpNewUser("Jomana", "randocamaccsccsca5c67@test.com");
        reg.UserInfo("12345678",     // pass
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
        reg.UserCanContinueAccount();
        
        home.OpenProducts();
        products.AddFirstandGoCart();
      
        cart.UserCanProccedToCheckOut();
        pay.PlaceOrder1();
       

        
        pay.userCanFillPaymentDetaisl("GuestUser", "1111222233334444", "333", "11", "2027");
        pay.userCanPayAndConfirmOrder();
        pay.SucessPayment();
        Assert.assertEquals(pay.SucessPayment.getText(), "ORDER PLACED!");

        
  
    }
}

