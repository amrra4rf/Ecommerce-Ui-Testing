package pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductPage extends PageBase {

    public ProductPage(WebDriver driver) {
        super(driver);
    }

   public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(3) > div > div.choose > ul > li > a")
    WebElement firstProduct;

   public   @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-3 > div > div.brands_products > h2")
   WebElement productContainers;
   
    public@FindBy(css ="a[data-product-id='1']")
    WebElement addToCartBtnFirst;
    public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(4) > div > div.single-products > div.productinfo.text-center > a")
    WebElement addToCartBtnSecond;
    public @FindBy(css="#cartModal > div > div > div.modal-footer > button")
    WebElement ContinueShopping;
    public @FindBy(css ="#cartModal > div > div > div.modal-body > p:nth-child(2) > a")
    WebElement viewCartBtn;

    public @FindBy(css="#product-1 > td.cart_description > h4 > a")
    WebElement FirstItemCart;
    public@FindBy(css="#product-2 > td.cart_description > h4 > a")
    WebElement SecondItemCart;
    public@FindBy(css="#product-1 > td.cart_price > p")
    WebElement firstItemPrice;
    
   public  @FindBy(xpath = "/html/body/section/div/div[2]/div[2]/div/h2")
    WebElement brandProductsHeader;
    
    public@FindBy(css="#product-2 > td.cart_price > p")
    WebElement secondItemPrice;
    
    public@FindBy(css="#product-1 > td.cart_quantity > button")
    WebElement firstItemQuantity;
    public@FindBy(css="#product-2 > td.cart_quantity > button")
    WebElement secondItemQuantity;
    
    public @FindBy(css="#product-1 > td.cart_total > p")
    WebElement firstItemTotal;
    public @FindBy(css="#product-2 > td.cart_total > p")
    WebElement secondItemTotal;
    
   public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > div:nth-child(6) > div > div.single-products > div.productinfo.text-center > a")
   WebElement AwayItem;
    
   public @FindBy(css="ins > span > svg > path")
   WebElement press;
   
   public @FindBy(css="body > section > div > div.row > div.col-sm-3 > div > div.brands_products > div > ul > li:nth-child(1) > a")
   WebElement polo;
   public @FindBy(css="body > section > div > div.row > div.col-sm-3 > div > div.brands_products > div > ul > li:nth-child(2) > a")
   WebElement Hm;
   
   
   public @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
   WebElement ClassnameProducts;

   
   
   @FindBy(xpath = "/html/body/section[2]/div/div/div[1]/div/div[2]/h2")
   WebElement brandsHeader;
   
   public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-3 > div > h2")
   WebElement category;
   public @FindBy(css="#accordian > div:nth-child(1) > div.panel-heading > h4 > a")
   WebElement women;
   
   public @FindBy(css="#Women > div > ul > li:nth-child(1) > a")
   WebElement dress;
   
   public @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
   WebElement womenDressProducts;
   
   public @FindBy(css="#accordian > div:nth-child(2) > div.panel-heading > h4 > a")
   WebElement Men;
   
   public @FindBy(css="#Men > div > ul > li:nth-child(1) > a")
   WebElement Tshirts;
   
   public @FindBy(css="body > section > div > div.row > div.col-sm-9.padding-right > div > h2")
   WebElement MenTshirts;
   
   
   public @FindBy(id="search_product")
   WebElement SearchProducts;
   
   public @FindBy(id="submit_search")
   WebElement SumbitSearch;
   
   public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
   WebElement AllProducts;
   public @FindBy(css="body > section:nth-child(3) > div > div > div.col-sm-9.padding-right > div > h2")
   WebElement SearchedProducts;
   
   public @FindBy(css=".features_items") WebElement ProductsContainer;
   public @FindBy(css="a.add-to-cart") List<WebElement> addToCartButtons;
   
   
   public void add3Items()
   {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   int i=0;
	   for (WebElement button : addToCartButtons) {
		   i++;

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));

		    WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
		            By.cssSelector(".close-modal")
		    ));
		    closeBtn.click();

		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
		    if(i==3)break;
		}
   }
   public void addAllSearchedProducts()
   {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	   for (WebElement button : addToCartButtons) {

		    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", button);

		    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", button);

		    wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("cartModal")));

		    WebElement closeBtn = wait.until(ExpectedConditions.elementToBeClickable(
		            By.cssSelector(".close-modal")
		    ));
		    closeBtn.click();

		    wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cartModal")));
		}
   }
   public void userCanSearch(String product)
   {
	   SearchProducts.sendKeys(product);
	   SumbitSearch.click();
   }
   public void AddFirstandGoCart()
   {
	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", addToCartBtnFirst);
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.visibilityOf(firstProduct));
       wait.until(ExpectedConditions.elementToBeClickable(firstProduct));
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addToCartBtnFirst);
       wait.until(ExpectedConditions.visibilityOf(viewCartBtn));
       wait.until(ExpectedConditions.elementToBeClickable(viewCartBtn));

       
       ((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
   }
   public void ViewFirstProduct()
   {
		 

	   ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView({ behavior: 'smooth', block: 'center' });", firstProduct);
	   ((JavascriptExecutor) driver).executeScript("arguments[0].click();", firstProduct);
	 
   }
    public void openFirstProduct() {
        addToCartBtnFirst.click();
    }

    public void viewCart() {
    	((JavascriptExecutor) driver).executeScript("arguments[0].click();", viewCartBtn);
    }
    
    public boolean isBrandsSidebarVisible() {
        return brandsHeader.isDisplayed();
    }
    public String getCurrentBrandHeader() {
        
        return brandProductsHeader.getText().toUpperCase().trim();
    }
    public boolean isProductListDisplayed() {
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(productContainers));
        wait.until(ExpectedConditions.elementToBeClickable(productContainers));
        return productContainers.isDisplayed();
    }
    
    public void  ClickPolo()
    {
    	polo.click();
    }
    public void  ClickHM()
    {
    	Hm.click();
    }
}
