package tests;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotEquals;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.CartPage;
import pages.HomePage;
import pages.PageDetails;

public class TC17_RemoveProduct extends TestBase {
	HomePage home ;
	CartPage cartObject;

    @Test
    public void removeProduct() throws InterruptedException {
    	 home = new HomePage(driver);
    	 cartObject=new CartPage(driver);
         home.OpenHome();
         assertEquals(home.homebtn.getCssValue("color"), "rgb(255, 165, 0)");//made sure we are in home page
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         home.UserAddsTwoItemsToCart();
         home.OpenCart();
         assertEquals(home.Cart.getCssValue("color"), "rgb(255, 165, 0)");//make sure we are in products page
         cartObject.deleteProduct();
         wait.until(ExpectedConditions.invisibilityOf(cartObject.FourthProduct));
         assertNotEquals(home.FourthProductname,cartObject.cartRow.getText() );

         
    }
}
