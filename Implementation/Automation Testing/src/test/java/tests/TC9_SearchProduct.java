package tests;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;

public class TC9_SearchProduct extends TestBase{
	 HomePage homeObject;
	 ProductPage searchObject;
	 @Test
		public void testSearchProduct() throws InterruptedException {
		homeObject=new HomePage(driver);
		searchObject = new ProductPage(driver);
	

		assertEquals(homeObject.homebtn.getCssValue("color"), "rgb(255, 165, 0)");
		homeObject.OpenProducts();
		assertEquals(searchObject.AllProducts.getText() ,"ALL PRODUCTS");
		 searchObject.userCanSearch("dress");
		 Assert.assertEquals(searchObject.SearchedProducts.getText(), "SEARCHED PRODUCTS");
		 

		 
		 
		 
		 
		 

		
		
		

}
}
