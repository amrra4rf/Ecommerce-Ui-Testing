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
import pages.HomePage;
import pages.PageDetails;
import pages.ProductPage;

public class TC8_ProductDetailsTests extends TestBase {

    HomePage homeObj;
    ProductPage productsObj;
    PageDetails detailsObj;

    @Test(priority = 1)
    public void VerifyProductDetailsPage() {
    	homeObj = new HomePage(driver);
        productsObj = new ProductPage(driver);
        detailsObj = new PageDetails(driver);

        assertEquals(homeObj.homebtn.getCssValue("color"), "rgb(255, 165, 0)");
        homeObj.OpenProducts();

      
        assertEquals(productsObj.AllProducts.getText(), "ALL PRODUCTS");

        productsObj.ViewFirstProduct();
        
        
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(detailsObj.ProductNamee));
        wait.until(ExpectedConditions.elementToBeClickable(detailsObj.ProductNamee));
     assertEquals(detailsObj.ProductNamee.getText(), "Blue Top");
       assertEquals(detailsObj.brand.getText(), "Brand:");
       assertEquals(detailsObj.condtion.getText(), "Condition:");
        assertEquals(detailsObj.price.getText(), "Rs. 500");
       assertEquals(detailsObj.categ.getText(), "Category: Women > Tops");
        assertEquals(detailsObj.avalability.getText(), "Availability:");
      
      
    }
}
