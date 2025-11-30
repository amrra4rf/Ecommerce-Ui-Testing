package tests;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.ContactUsPage;
import pages.HomePage;
import pages.TestCassesPage;

public class TC7_TestCassesOpens extends TestBase{
	 HomePage homeObject;
	 TestCassesPage testCases;
	 @Test
		public void testTestCasesTEsts() throws InterruptedException {
		homeObject=new HomePage(driver);
		testCases =new TestCassesPage(driver);
		assertEquals(homeObject.homebtn.getCssValue("color"), "rgb(255, 165, 0)"); 
		homeObject.OpenTestCases();
		assertEquals(homeObject.TestCases.getCssValue("color"), "rgb(255, 165, 0)");
		Assert.assertEquals(testCases.testCaseMeassege.getText(), "TEST CASES");		  
		 
		
		 
	 

}
}
