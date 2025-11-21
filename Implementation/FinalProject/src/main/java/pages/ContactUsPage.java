package pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

import javax.xml.xpath.XPath;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends PageBase {

	public ContactUsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(name="name")WebElement nameTxt;
	@FindBy(name="email")WebElement emailTxt;
	@FindBy(name="subject")WebElement SubjectTxt;	
	@FindBy(id="message")WebElement MessageTxt;	
	@FindBy(name="upload_file")WebElement UploadBtn;	
	@FindBy(css="#contact-us-form > div:nth-child(7) > input")WebElement SumbitBtn;
	public @FindBy(css="#contact-page > div.row > div.col-sm-8 > div > h2") WebElement getintouchMessage;
	public @FindBy(css="#contact-page > div.row > div.col-sm-8 > div > div.status.alert.alert-success")WebElement ContactUSSuccessMessage;
	
	
	public void UserCanMakeContactUs(String name,String email,String subject,
			String message) throws AWTException, InterruptedException
	{
		nameTxt.sendKeys(name);
		emailTxt.sendKeys(email);
		SubjectTxt.sendKeys(subject);
		MessageTxt.sendKeys(message);
		
		String filePath= System.getProperty("user.dir")+"\\Images\\photo.jpg";	
		UploadBtn.sendKeys(filePath);
//		StringSelection s=new StringSelection(filePath);
//		Actions builder=new Actions(driver);
//		builder.click(UploadBtn).build().perform();
//
//		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(s, null);
//		Robot robot=new Robot();
//		robot.delay(2000);
//		robot.keyPress(KeyEvent.VK_CONTROL);
//		robot.keyPress(KeyEvent.VK_V);
//		robot.keyRelease(KeyEvent.VK_CONTROL);
//		robot.keyRelease(KeyEvent.VK_V);
//		
//		robot.keyPress(KeyEvent.VK_ENTER);
//		robot.keyRelease(KeyEvent.VK_ENTER);
//		robot.delay(2000);
		
		SumbitBtn.click();
		
		
	}

}
