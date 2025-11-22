package tests;

	import org.testng.Assert;
	import org.testng.annotations.Test;
	import pages.HomePage;
import pages.Register;


	public class TC1_Register_happyScenario extends TestBase {

	    @Test
	    public void testRegisterNewUser() {

	        HomePage home = new HomePage(driver);
	        Register register = new Register(driver);

	        home.OpenRegister();

	        register.UserSignUpNewUser("amr","amr2000000000004@gmail.com");
	        register.UserInfo("12345678",     // pass
	        	    "15",           // day
	        	    "July",           // month
	        	    "2002",         // year
	        	    "Guest",        // first name
	        	    "User",         // last name
	        	    "Cairo",        // address 1
	        	    "Street 5",     // address 2
	        	    "United States",// country
	        	    "Texas",        // state
	        	    "Dallas",       // city
	        	    "9000",         // zip
	        	    "0123444555",   // mobile
	        	    "uni"       );    // company);
	        
	        
	        Assert.assertEquals(register.AccountMade.getText(),"ACCOUNT CREATED!");
	        register.UserCanContinueAccount();
	    }
	}


