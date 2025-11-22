package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;

public class TC22_RecommendedItems extends TestBase{
	
	HomePage homeObj;
    CartPage cartObj;
    @BeforeClass
    public void setupPages() {
        homeObj = new HomePage(driver);
        cartObj = new CartPage(driver);
    }
  @Test
  public void UserCanAddRecommendedItemToCart() throws InterruptedException {
      
      homeObj.ScrollToRecommended();
      
      
      Thread.sleep(1000); 

    
      assertEquals(homeObj.recomended.getText(),"RECOMMENDED ITEMS");

      homeObj.AddFirstRecommended();
     
      homeObj.OpenCart();
      for (WebElement row : cartObj.rows) {
    	    WebElement nameElement = row.findElement(By.cssSelector(".cart_description h4 a"));
    	    assertEquals(nameElement.getText(),homeObj.productName);  
    	}

     
    
      
      
  }
}

