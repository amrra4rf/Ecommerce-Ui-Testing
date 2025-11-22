package tests;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class TC19_BrandProductTests extends TestBase {

    HomePage homeObj;
    ProductPage productsObj;

    private final String BRAND_A = "Polo";
    private final String BRAND_B = "H&M";

 

    @Test(priority = 1)
    public void UserCanViewAndSwitchBrandProducts() throws InterruptedException {
    	homeObj = new HomePage(driver);
    	productsObj=new ProductPage(driver);
        homeObj.OpenProducts();

       
        assertEquals(productsObj.productContainers.getText(),"BRANDS");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", productsObj.polo);

        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsObj.polo);
        Thread.sleep(2000);
        assertEquals(productsObj.ClassnameProducts.getText(),"BRAND - POLO PRODUCTS");
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsObj.Hm);
        Thread.sleep(2000);
        assertEquals(productsObj.ClassnameProducts.getText(),"BRAND - H&M PRODUCTS");

       
       

        
        
 
        
    }
}