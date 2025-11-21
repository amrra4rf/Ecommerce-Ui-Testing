package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class InvoicePage extends PageBase {

    public InvoicePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css="a.btn.btn-primary")
    WebElement downloadInvoiceBtn;

    public void downloadInvoice() {
        downloadInvoiceBtn.click();
    }
}
