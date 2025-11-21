package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Register;

public class Login_happyScenario extends TestBase {
	//working but needs to do like the test cassess  T2
    @Test
    public void testLoginCorrect() {

        HomePage home = new HomePage(driver);
        Register login = new Register(driver);

        home.OpenRegister();;
        login.login("randocamacsccsca5c67@test.com", "12345678");//no such account

        Assert.assertTrue(login.logoutBtn.isDisplayed());
    }
}



