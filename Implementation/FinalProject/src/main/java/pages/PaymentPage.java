package pages;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends PageBase {

	public PaymentPage(WebDriver driver) {
		super(driver);
	}
public @FindBy(name="name_on_card")WebElement NameOnCard;
public @FindBy(name="card_number")WebElement CardNumber;
public @FindBy(css="#payment-form > div:nth-child(4) > div.col-sm-4.form-group.cvc > input")WebElement Cvc;
public @FindBy(name="expiry_month")WebElement ExpiryMonth;
public @FindBy(name="expiry_year")WebElement ExpiryYear;
public @FindBy(css ="#submit")WebElement sumbitBtn;
public @FindBy(css="#form > div > div > div > h2 > b")WebElement SucessPayment;
public @FindBy(css="#form > div > div > div > a")WebElement DownloadInvoice;

public @FindBy(css="#form > div > div > div > div > a")WebElement Continue;

public @FindBy(css="#cart_items > div > div:nth-child(8) > a")WebElement PlaceOrder;

public void userCanFillPaymentDetaisl(String name,String Cardnumber,String cvc,
		String expiryM,String expiryY)
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(NameOnCard));
    wait.until(ExpectedConditions.elementToBeClickable(NameOnCard));
	NameOnCard.sendKeys(name);
	CardNumber.sendKeys(Cardnumber);
	Cvc.sendKeys(cvc);
	ExpiryMonth.sendKeys(expiryM);
	ExpiryYear.sendKeys(expiryY);
}

public void SucessPayment()
{
	SucessPayment.click();
}
public void PlaceOrder1()
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(PlaceOrder));
    wait.until(ExpectedConditions.elementToBeClickable(PlaceOrder));
    ((JavascriptExecutor) driver).executeScript("arguments[0].click();", PlaceOrder);
}

public void userCanPayAndConfirmOrder()
{
	sumbitBtn.click();
}

public void UserCanDownloadInvoices()
{
	DownloadInvoice.click();
}

public void UserCanContinue()
{
	Continue.click();
}

public boolean isFileDownloaded(String downloadPath, String fileName) {
    File dir = new File(downloadPath);
    File[] files = dir.listFiles();

    if (files == null || files.length == 0) {
        return false;
    }

    for (File file : files) {
        if (file.getName().equals(fileName)) {
            return true;
        }
    }
    return false;
}



}
