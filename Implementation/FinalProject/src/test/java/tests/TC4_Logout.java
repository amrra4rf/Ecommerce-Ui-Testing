package tests;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.Register;

public class TC4_Logout extends TestBase{
	HomePage homeObject;
	Register loginObject;
  @Test
  public void testLogin_corrcetUserNameAndPassword() throws InterruptedException {
	  homeObject = new HomePage(driver);
	  loginObject = new Register(driver);
	  
	  assertEquals(homeObject.homebtn.getCssValue("color"), "rgb(255, 165, 0)");
	  homeObject.OpenRegister();
	  assertEquals(loginObject.loginMessage.getText(), "Login to your account");	  
	  loginObject.login("ashtj122@gmail.com","1234598");
	  assertEquals(homeObject.LoggedInAs.getText(),"Logged in as ahmed");	  
	  loginObject.logout();
	  assertEquals(homeObject.Signupbtn.getCssValue("color"), "rgb(255, 165, 0)");
	  
	  

	  
  }
  
  
}
