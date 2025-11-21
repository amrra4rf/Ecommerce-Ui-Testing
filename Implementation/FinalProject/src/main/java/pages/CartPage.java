package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends PageBase {

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public @FindBy(css = "table#cart_info_table tbody tr:first-of-type td.cart_description a")
    WebElement cartRow;

    public @FindBy(css="#product-4 > td.cart_description > h4 > a")
    WebElement FourthProduct;
    public @FindBy(linkText ="Proceed To Checkout")WebElement proccedToCheckout;
    @FindBy(css=".cart_quantity_delete")
    WebElement deleteBtn;
    public @FindBy(css="#checkoutModal > div > div > div.modal-body > p:nth-child(2) > a > u")
    WebElement RegisterandLogin;
	public @FindBy(id="susbscribe_email")WebElement subscrptionEmail;
	public @FindBy(id="subscribe")WebElement subscrptionBtn;
	public @FindBy(css="#success-subscribe > div")WebElement successMessage;
	public @FindBy(css="#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2")WebElement subscription;
    public void deleteProduct() {
        deleteBtn.click();
    }
    
    public void UserCanProccedToCheckOut()
    {WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(proccedToCheckout));
        wait.until(ExpectedConditions.elementToBeClickable(proccedToCheckout));

        
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", proccedToCheckout);
   }
    
    public void UserCanProccedtToRegister()
    {
    	RegisterandLogin.click();
    }
}
