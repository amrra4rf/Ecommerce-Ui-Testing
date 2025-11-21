package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProductPage;
import pages.CartPage;

public class TC12_AddProduct extends TestBase {
	HomePage home ;
	ProductPage product;
    @Test
    public void addProductToCart() throws InterruptedException {
         home = new HomePage(driver);
         product = new ProductPage(driver);

         assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
        home.OpenProducts();
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", product.firstProduct);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(product.firstProduct));
        wait.until(ExpectedConditions.elementToBeClickable(product.firstProduct));
        
        

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.addToCartBtnFirst);

  
        wait.until(ExpectedConditions.visibilityOf(product.ContinueShopping));
        wait.until(ExpectedConditions.elementToBeClickable(product.ContinueShopping));

        // Click Continue Shopping with JS to avoid animation issues
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.ContinueShopping);

        product.addToCartBtnSecond.click();
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.viewCartBtn);
        
        //wait product 1
        wait.until(ExpectedConditions.visibilityOf(product.FirstItemCart));
        wait.until(ExpectedConditions.elementToBeClickable(product.FirstItemCart));
        
        
        //wait product 2
        wait.until(ExpectedConditions.visibilityOf(product.SecondItemCart));
        wait.until(ExpectedConditions.elementToBeClickable(product.SecondItemCart));
        
        
        assertEquals(product.FirstItemCart.getText(), "Blue Top");
        assertEquals(product.SecondItemCart.getText(),"Men Tshirt");
        
        assertEquals(product.firstItemPrice.getText(), "Rs. 500");
        assertEquals(product.secondItemPrice.getText(), "Rs. 400");
      
        assertEquals(product.firstItemQuantity.getText(), "1");
        assertEquals(product.secondItemQuantity.getText(), "1");
        
        assertEquals(product.firstItemTotal.getText(), "Rs. 500");
        assertEquals(product.secondItemTotal.getText(), "Rs. 400");

    }
}
