package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;


public class TC18_CategoryProductTests extends TestBase {

    HomePage homeObj;
    ProductPage productsObj;

    @BeforeClass
    public void setupPages() {
        homeObj = new HomePage(driver);
        productsObj = new ProductPage(driver);
    }

    @Test(priority = 1)
    public void UserCanViewCategoryProducts() {
    	homeObj.OpenProducts();
    	assertEquals(productsObj.category.getText(), "CATEGORY");
    	productsObj.women.click();
    	productsObj.dress.click();
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productsObj.womenDressProducts));
        wait.until(ExpectedConditions.elementToBeClickable(productsObj.womenDressProducts));
    	assertEquals(productsObj.womenDressProducts.getText(), "WOMEN - DRESS PRODUCTS");
    	productsObj.Men.click();
    	productsObj.Tshirts.click();;
        Assert.assertEquals(productsObj.MenTshirts.getText(),"MEN - TSHIRTS PRODUCTS");
    
    }
}