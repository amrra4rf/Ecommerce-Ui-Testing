package tests;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.Test;

import pages.HomePage;
import pages.PageDetails;
import pages.ProductPage;

public class TC21_ReviewOnProduct extends TestBase {
	
	HomePage home ;
	ProductPage product;
	PageDetails pagedetailsObject;
  @Test
  public void ReviewOnProductHappyScenario() throws InterruptedException {
	  home=new HomePage(driver);
	  product=new ProductPage(driver);
	  pagedetailsObject= new PageDetails(driver);
	  home.OpenProducts();
	  assertEquals(home.Products.getCssValue("color"), "rgb(255, 165, 0)");
	  product.ViewFirstProduct();
	  pagedetailsObject.userCanMakeReview("amrrrrr", "amr200001551@gmail.com", "I really like this product it might be one of the best on the website");
	  assertEquals(pagedetailsObject.SuccessMessage.getText(), "Thank you for your review.");
	  
	  
  }
}
