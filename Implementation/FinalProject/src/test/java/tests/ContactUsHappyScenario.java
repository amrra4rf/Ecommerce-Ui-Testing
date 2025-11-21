package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import pages.ContactUsPage;
import pages.HomePage;

public class ContactUsHappyScenario extends TestBase {
	
	HomePage homeobject;
	ContactUsPage contactObject;
  @Test
  public void TestContactUsWithAllValidFields() throws AWTException, InterruptedException {
  homeobject=new HomePage(driver);
  contactObject=new ContactUsPage(driver);
  
  homeobject.homebtn.click();
  homeobject.ContactUs.click();
  assertTrue(contactObject.getintouchMessage.isDisplayed());
  contactObject.UserCanMakeContactUs("amr", "amr200000004@gmail.com", "Enquiry", "i was asking if there is any customer service that can contact with me in the telephone");
  Alert alert=driver.switchTo().alert();
  assertEquals(alert.getText(), "Press OK to proceed!");
  alert.accept();
  assertEquals(contactObject.ContactUSSuccessMessage.getText(), "Success! Your details have been submitted successfully.");
 
  
  
  }
}
