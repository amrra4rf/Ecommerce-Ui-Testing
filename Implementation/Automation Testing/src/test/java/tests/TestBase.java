package tests;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;

public class TestBase {
	 protected WebDriver driver;
	 protected String baseurl="https://automationexercise.com/";
	 public Random random = new Random();
  @BeforeTest
  public void OpenBrowser() {
	  driver=new FirefoxDriver();
	  driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	  driver.manage().window().maximize();
	  driver.navigate().to(baseurl);
  }

  //tc23  tc14 tc15 tc24
  @AfterTest
  public void CloseBrowser() {
	  driver.quit();
  }

}
