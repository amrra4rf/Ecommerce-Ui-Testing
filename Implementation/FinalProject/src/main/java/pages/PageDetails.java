package pages;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageDetails extends PageBase {

	public PageDetails(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	public @FindBy(css="body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > h2")
	WebElement ThirdProductName;
	
	public @FindBy(id="quantity")WebElement quantityThirdItem;
	
	public @FindBy(css="body > section > div > div > div.col-sm-9.padding-right > div.product-details > div.col-sm-7 > div > span > button")
	WebElement addToCartThirdItem;
	
	
    public @FindBy(css ="#cartModal > div > div > div.modal-body > p:nth-child(2) > a")
    WebElement viewCartBtn;
    
    public @FindBy(css="#product-3 > td.cart_quantity")
    WebElement quantityCartThirdItem;
    
    public @FindBy(id="name")WebElement name;
    public @FindBy(id="email")WebElement email;
    public @FindBy(id="review")WebElement ReviewTxt;
    public @FindBy(id="button-review") WebElement SumbitBtn;
    public @FindBy(css="#review-section > div > div > span")WebElement SuccessMessage;
    
    public void userCanMakeReview(String name ,String email,String Review)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    	wait.until(ExpectedConditions.visibilityOf(this.name));
        wait.until(ExpectedConditions.elementToBeClickable(this.name));
 	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", this.name);
 	   this.name.sendKeys(name);
 	   this.email.sendKeys(email);
 	   this.ReviewTxt.sendKeys(Review);
 	   SumbitBtn.click();

}
    
}
