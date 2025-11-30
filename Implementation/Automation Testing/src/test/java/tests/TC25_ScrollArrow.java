package tests;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;

public class TC25_ScrollArrow extends TestBase {

	HomePage home;
    @Test
    public void positiveScenario()  throws InterruptedException {

    	home=new HomePage(driver);
        assertTrue(driver.getTitle().contains("Automation Exercise"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");
        Thread.sleep(2000);
       assertTrue(home.subscriptionText.isDisplayed());
        home.scrollUpBtn.click();
        Thread.sleep(2000);
        assertTrue(home.topText.isDisplayed());
    }
}
