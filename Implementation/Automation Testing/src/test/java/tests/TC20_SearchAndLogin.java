package tests;
 
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.ProductPage;
import pages.Register;
 
public class TC20_SearchAndLogin extends TestBase{
	HomePage homeObj;
    ProductPage productsObj;
    Register loginObj;
    CartPage cartObj;
    List<String> productNamesBeforeLogin;
    
    private final String EMAIL = "jomana1ccscsxa234@test.com";
    private final String PASSWORD = "12345678";

    @BeforeClass
    public void setupPages() {
        homeObj = new HomePage(driver);
        productsObj = new ProductPage(driver);
        loginObj = new Register(driver);
        cartObj = new CartPage(driver);
    }
  @Test(priority=1)
  public void SearchProductsAndVerifyCartAfterLogin() throws InterruptedException {

      
      homeObj.OpenProducts();

      assertEquals(productsObj.AllProducts.getText(), "ALL PRODUCTS");
      String search="Tshirt";
      productsObj.userCanSearch(search);
      assertEquals(productsObj.SearchedProducts.getText(), "SEARCHED PRODUCTS");
      productsObj.addAllSearchedProducts();

      homeObj.OpenCart();
      for (WebElement row : cartObj.rows) {
    	    WebElement nameElement = row.findElement(By.cssSelector(".cart_description h4 a"));
    	    assertTrue(nameElement.isDisplayed());  
    	}

 


    
      homeObj.OpenRegister(); 
      loginObj.UserSignUpNewUser(EMAIL, PASSWORD);
      homeObj.OpenCart();

      
      homeObj.OpenCart();
      for (WebElement row : cartObj.rows) {
  	    WebElement nameElement = row.findElement(By.cssSelector(".cart_description h4 a"));
  	    assertTrue(nameElement.isDisplayed());  
  	}

     
      
  }
}