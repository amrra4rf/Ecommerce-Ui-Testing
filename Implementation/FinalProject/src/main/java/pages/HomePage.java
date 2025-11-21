package pages;


import java.nio.file.WatchEvent;
import java.time.Duration;

import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase
{

	public HomePage(WebDriver driver) {
		super(driver);
	}
	public @FindBy(css="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(4) > a")
	WebElement Signupbtn;//find the element with name  Signup / Login and store it into signupbtn
	public @FindBy (linkText = "Home")
	WebElement homebtn;
	public @FindBy(css="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(2) > a")
	WebElement Products;
	public @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a")
	WebElement Cart;
	public @FindBy(xpath = "//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a")
	WebElement ContactUs;
	public @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[7]/a")
	WebElement VideoTutorials;
	public @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[6]/a")
	WebElement ApiTesting;
	public @FindBy(xpath="//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a")
	WebElement TestCases;
	public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(5) > div > div.choose > ul > li > a")
	WebElement ViewThirdProduct;
	public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(6) > div > div.single-products")
	WebElement FourthProduct;
	public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(6) > div > div.single-products > div.productinfo.text-center > p")
	WebElement FourthEProductName;
	public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(7) > div > div.single-products > div.productinfo.text-center > a")
	WebElement 	fifthProductAddToCart;
	public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div.features_items > div:nth-child(6) > div > div.single-products > div.productinfo.text-center > a")
	WebElement forthProductAddtoCart;
	
	public@FindBy(css="#cartModal > div > div > div.modal-footer > button")
	WebElement ContinueShopping;
	
	 public @FindBy(css ="#cartModal > div > div > div.modal-body > p:nth-child(2) > a")
	    WebElement viewCartBtn;
	 public @FindBy(css="#form > div > div > div > h2 > b")
	 WebElement deleteSuccess;
		public @FindBy(css="#footer > div.footer-widget > div > div > div.col-sm-3.col-sm-offset-1 > div > h2")WebElement subscription;
		public @FindBy(id="susbscribe_email")WebElement subscrptionEmail;
		public @FindBy(id="subscribe")WebElement subscrptionBtn;
		public @FindBy(css="#success-subscribe > div")WebElement successMessage;
		
		
		public @FindBy(xpath="//h2[text()='Subscription']")WebElement subscriptionText;
		public @FindBy(id="scrollUp")WebElement scrollUpBtn;
		public @FindBy(xpath="//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]")WebElement topText;
		public void userCanSubscribe(String email)
		{
			subscrptionEmail.sendKeys(email);
			subscrptionBtn.click();
		}
	 public String FourthProductname=FourthEProductName.getText();
	 
	 public void UserAddsTwoItemsToCart()
	 {
         WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
         
        
         
         ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", FourthProduct);
       
         wait.until(ExpectedConditions.visibilityOf(FourthProduct));
         wait.until(ExpectedConditions.elementToBeClickable(FourthProduct));
         
         
         forthProductAddtoCart.click();

   
         wait.until(ExpectedConditions.visibilityOf(ContinueShopping));
         wait.until(ExpectedConditions.elementToBeClickable(ContinueShopping));

     
	      ContinueShopping.click();
	    
	     
         fifthProductAddToCart.click();
         wait.until(ExpectedConditions.visibilityOf(ContinueShopping));
         wait.until(ExpectedConditions.elementToBeClickable(ContinueShopping));
         ((JavascriptExecutor) driver).executeScript("arguments[0].click();", ContinueShopping);
	 }
	public void OpenRegister()
	{
		Signupbtn.click();
	}
	public void OpenHome()
	{
		homebtn.click();
	}
	public void OpenProducts()
	{
		Products.click();
	}
	
	public void OpenCart()
	{
		Cart.click();
	}
	public void OpenVideoTutorials()
	{
		VideoTutorials.click();
	}
	public void ContactUs()
	{
		ContactUs.click();
	}
	public void OpenApiTesting()
	{
		ApiTesting.click();
	}
	public void OpenTestCases()
	{
		TestCases.click();
	}
}
