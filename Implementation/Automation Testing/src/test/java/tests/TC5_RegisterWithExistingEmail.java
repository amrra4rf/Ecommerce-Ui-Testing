package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Register;

public class TC5_RegisterWithExistingEmail extends TestBase {
	  HomePage homeObject;
	Register registerObject;
	
  @Test
  public void testRegister_ValidFieldsWithExisistEmail() throws InterruptedException {
	   homeObject = new HomePage(driver);
	   registerObject = new Register(driver);
	   
	   assertEquals(homeObject.homebtn.getCssValue("color"), "rgb(255, 165, 0)");
	   
	   homeObject.OpenRegister();

	   Assert.assertEquals(registerObject.SignupTxt.getText(), "New User Signup!");
	   
	   registerObject.UserSignUpNewUser("ahmel","adgj2@gmail.com");
	   Assert.assertEquals(registerObject.EmailExistsTxt.getText(), "Email Address already exist!");

	  
  }
}
