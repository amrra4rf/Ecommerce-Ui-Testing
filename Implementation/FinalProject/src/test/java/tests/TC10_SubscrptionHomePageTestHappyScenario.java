package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.HomePage;


public class TC10_SubscrptionHomePageTestHappyScenario extends TestBase{
	HomePage homeObject;

  @Test
  public void TestSubscrptionWithValidEmail() throws Exception {
	  
	  homeObject=new HomePage(driver);
	  
	  homeObject.homebtn.click();
	  assertEquals(homeObject.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
	  ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", homeObject.subscrptionEmail);
	  assertEquals(homeObject.subscription.getText(), "SUBSCRIPTION");//made sure subscription appears correctly
	  homeObject.subscrptionEmail.sendKeys("amrAshraf@gmail.com");
	  homeObject.subscrptionBtn.click();
	  assertEquals(homeObject.successMessage.getText(), "You have been successfully subscribed!");//make sure subscription is done successfully
	  
	  
  }
}
