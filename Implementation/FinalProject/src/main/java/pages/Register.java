package pages;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.Zip;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Register extends PageBase
{

	public Register(WebDriver driver) {
		super(driver);
		
	}

	
	@FindBy (name="name")WebElement NameTxt;
	@FindBy (name="email")List<WebElement>EmailTxt;//0 for the login and 1 for the register
	public @FindBy (xpath ="//*[@id=\"form\"]/div/div/div[3]/div/h2")WebElement SuccessRegister;
	public@FindBy (css ="#form > div > div > div > div.login-form > h2 > b")WebElement SuccessRegisterForm;
	public @FindBy (xpath ="//*[@id=\"form\"]/div/div/div/h2/b")WebElement AccountMade;
	public @FindBy (linkText  ="Logout")WebElement Logout;
	public @FindBy (css  ="#form > div > div > div > h2 > b")WebElement AccountDeleted;
	public @FindBy (css  ="#form > div > div > div:nth-child(3) > div > form > p")WebElement AccountExist;
	@FindBy (css ="#form > div > div > div:nth-child(3) > div > form > button")WebElement SumbitBtn;
	@FindBy (id ="id_gender1")WebElement MrBtn;
	@FindBy (id ="id_gender2")WebElement MrsBtn;
	@FindBy (id ="password")WebElement Password;
	@FindBy (id ="days")WebElement Days;
	@FindBy (id ="months")WebElement Months;
	@FindBy (id ="years")WebElement Years;
	@FindBy (id ="newsletter")WebElement NewSletter;
	@FindBy (id ="optin")WebElement SpecialOffers;
	@FindBy (id ="first_name")WebElement FirstName;
	@FindBy (id ="last_name")WebElement LastName;
	@FindBy (id ="company")WebElement Company;
	@FindBy (id ="address1")WebElement Address1;
	@FindBy (id ="address2")WebElement Address2;
	@FindBy (id ="country")WebElement Country;
	@FindBy (id ="state")WebElement State;
	@FindBy (id ="city")WebElement City;
	@FindBy (id ="zipcode")WebElement ZipCode;
	@FindBy (id ="mobile_number")WebElement MobNumber;
	@FindBy (xpath ="//*[@id=\"form\"]/div/div/div/div[1]/form/button")WebElement CreateAccBtn;
	@FindBy (linkText  ="Continue")WebElement ContinueBtn;
	public @FindBy (css  ="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(5) > a")WebElement DeleteBtn;
	public @FindBy(css="#header > div > div > div > div.col-sm-8 > div > ul > li:nth-child(10) > a")
	WebElement username;
	
	public@FindBy(css="#form > div > div > div.col-sm-4.col-sm-offset-1 > div > h2")
	WebElement loginMessage;
	
	public @FindBy(css="#form > div > div > div:nth-child(3) > div > h2")
	WebElement SignupTxt;
	public @FindBy(css="#form > div > div > div:nth-child(3) > div > form > p")
	WebElement EmailExistsTxt;
	
	
	
	
    @FindBy(name="email")
    WebElement emailTxt;

    @FindBy(name="password")
    WebElement passTxt;

    @FindBy(css="#form button")
    WebElement loginBtn;

    @FindBy(xpath="//*[@id=\"form\"]/div/div/div[1]/div/form/p")
    public WebElement errorMessage;

    @FindBy(linkText="Logout")
    public WebElement logoutBtn;

    public void login(String email, String pass){
        emailTxt.sendKeys(email);
        passTxt.sendKeys(pass);
        loginBtn.click();
    }

    public void logout(){
        logoutBtn.click();
    }
	public void UserSignUpNewUser(String name,String Email)
	{
		NameTxt.sendKeys(name);
		EmailTxt.get(1).sendKeys(Email);
		SumbitBtn.click();

	}
	
	
	public void UserInfo(String pass, String bday, String bmonth, String bYear,
            String Fname, String Lname,
            String address1, String address2,
            String country, String state, String city,
            String Zipcode, String mobNumber, String comp)
	{
		
		MrBtn.click();
		Password.sendKeys(pass);
		Select DaysDropDown=new Select(Days);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", Days);

		DaysDropDown.selectByVisibleText(bday);
		
		
		Select MonthsDropDown=new Select(Months);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", MonthsDropDown);
		MonthsDropDown.selectByVisibleText(bmonth);
		
		
		Select YearsDropDown=new Select(Years);
		YearsDropDown.selectByVisibleText(bYear);
		
		NewSletter.click();
		SpecialOffers.click();
		
		FirstName.sendKeys(Fname);
		LastName.sendKeys(Lname);
		Company.sendKeys(comp);
		Address1.sendKeys(address1);
		Address2.sendKeys(address2);
		
		Select CountryList =new Select(Country);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", CountryList);
		CountryList.selectByVisibleText(country);
		
		State.sendKeys(state);
		City.sendKeys(city);
		ZipCode.sendKeys(Zipcode);
		MobNumber.sendKeys(mobNumber);
		
		CreateAccBtn.click();
		
		
	
	}
	
	public void UserCanContinueAccount()
	{
		ContinueBtn.click();
	}
	
	
	public void UserCanDeleteAccount()
	{
		DeleteBtn.click();
	}
	
	public void UsercanLogout()
	{
		Logout.click();
	}
}
