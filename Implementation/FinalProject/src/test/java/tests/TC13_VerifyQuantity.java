package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.PageDetails;
import pages.ProductPage;

public class TC13_VerifyQuantity extends TestBase {

	HomePage home ;
	PageDetails product;
    @Test
    public void verifyQty() throws InterruptedException {
        home = new HomePage(driver);
        product = new PageDetails(driver);
        home.OpenHome();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        
        assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", home.ViewThirdProduct);
        
        wait.until(ExpectedConditions.visibilityOf(home.ViewThirdProduct));
        wait.until(ExpectedConditions.elementToBeClickable(home.ViewThirdProduct));
        home.ViewThirdProduct.click();
        
        
        assertEquals(product.ThirdProductName.getText(), "Sleeveless Dress");
        
        product.quantityThirdItem.clear();
        wait.until(ExpectedConditions.visibilityOf(product.quantityThirdItem));
        wait.until(ExpectedConditions.elementToBeClickable(product.quantityThirdItem));
        product.quantityThirdItem.sendKeys("4");
        product.addToCartThirdItem.click();
        
        wait.until(ExpectedConditions.visibilityOf(product.viewCartBtn));
        wait.until(ExpectedConditions.elementToBeClickable(product.viewCartBtn));
        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", product.viewCartBtn);
        
        wait.until(ExpectedConditions.visibilityOf(product.quantityCartThirdItem));
        wait.until(ExpectedConditions.elementToBeClickable(product.quantityCartThirdItem));
        
        assertEquals(product.quantityCartThirdItem.getText(),"4");
        
        
      
       
    }
}
