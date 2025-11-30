package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends PageBase {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public @FindBy(css="#address_invoice > li:nth-child(4)")
    WebElement Add1Billing;

    public @FindBy(css="#address_invoice > li:nth-child(5)")
    WebElement add2billing;
    
    public @FindBy(css="#address_invoice > li.address_country_name")
    WebElement Cntrybilling;
   public @FindBy(css="#address_invoice > li.address_city.address_state_name.address_postcode")
    WebElement CityStateZipbilling;
   
   
   
   
   public @FindBy(css="#address_delivery > li:nth-child(4)")
   WebElement Add1delivery;

   public @FindBy(css="#address_delivery > li:nth-child(5)")
   WebElement add2delivery;
   
   public @FindBy(css="#address_invoice > li.address_country_name")
   WebElement Cntrydelviery;
  public @FindBy(css="#address_delivery > li.address_city.address_state_name.address_postcode")
   WebElement CityStateZipdelivery;

  public @FindBy(css="#cart_items > div > div:nth-child(4) > h2")
  WebElement ReviewOrder;
  public @FindBy(css="#ordermsg > textarea")
  WebElement Commenttxt;
  public @FindBy(css="#cart_items > div > div:nth-child(8) > a")
  WebElement PlaceOrder;
  
public void makeComment(String comment)
{
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(Commenttxt));
     wait.until(ExpectedConditions.elementToBeClickable(Commenttxt));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", Commenttxt);
	Commenttxt.sendKeys(comment);
}
public void usercanPlaceOrder()
{
	 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
     wait.until(ExpectedConditions.visibilityOf(PlaceOrder));
     wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", PlaceOrder);
	PlaceOrder.click();
}
   
}
