package tests;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.ProductPage;

public class BrandProductTests extends TestBase {

    HomePage homeObj;
    ProductPage productsObj;

    private final String BRAND_A = "Polo";
    private final String BRAND_B = "H&M";

 

    @Test(priority = 1)
    public void UserCanViewAndSwitchBrandProducts() throws InterruptedException {
    	homeObj = new HomePage(driver);
    	productsObj=new ProductPage(driver);
        homeObj.OpenProducts();

       
        Assert.assertEquals(productsObj.productContainers.getText(),"BRANDS");
        Thread.sleep(3000);
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsObj.polo);
        

       
      
        Assert.assertEquals(productsObj.polo.getText(),"(6)\n"
        		+ "POLO");
            
       
        Assert.assertEquals(productsObj.Hm.getText(),"(5)\n"
        		+ "H&M");

       
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", productsObj.Hm);

        
        
 
        
    }
}