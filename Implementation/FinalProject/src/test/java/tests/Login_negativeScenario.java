package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Register;

public class Login_negativeScenario extends TestBase {
//working but needs to do like the test cassess  T3
    @Test
    public void testLoginIncorrect() {

        HomePage home = new HomePage(driver);
        Register login = new Register(driver);

        home.OpenRegister();;
        login.login("wrongemail@gmail.com", "111222");

        Assert.assertEquals(login.errorMessage.getText(),"Your email or password is incorrect!");
    }
}