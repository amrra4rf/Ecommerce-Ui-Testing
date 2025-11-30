package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TestCassesPage extends PageBase {

	public TestCassesPage(WebDriver driver) {
		super(driver);
	}

public @FindBy(css="#form > div > div.row > div > h2 > b")WebElement testCaseMeassege;
	
	

}
