package test_cases;

import org.testng.Assert;
import org.testng.annotations.Test;

import page_objects.PilrHomePage;
import page_objects.PilrLogin;
import page_objects.Pilr_ForgotPwd;
import page_objects.Pilr_Navbar;
import page_objects.Pilr_RegisterPage;

public class TestNewUserRegistration extends AbstractTestCase {
	 
    PilrLogin objLogin;
    PilrHomePage objHomePage;
    Pilr_Navbar navbar;
    Pilr_RegisterPage objRegPage;
    Pilr_ForgotPwd pwdResetPage;
 
    // New User Registration
    @Test
    public void test_New_User_Registration(){
    	
    	//Create Login Page object
    	objLogin = new PilrLogin(driver);
    
    	//Verify login page title
    	Assert.assertTrue(objLogin.getPageSource().toLowerCase().contains("sign in"));
    	System.out.println("[Test Case]Login Page Verified");
 
    	// select Register option
    	objLogin.registerAsNewUser();
    	
    	// go the Registration page and verify that it is open
    	objRegPage = new Pilr_RegisterPage(driver);
    	Assert.assertTrue(objRegPage.getRegisterPageWelcome().toLowerCase().contains("new "
    			+ "user registration"));
    	System.out.println("[Test Case]Registration Page Verified");
    	
    	//complete registration form
    	String newUsername = "AutoTest" + Long.toHexString(System.currentTimeMillis());
    	objRegPage.registerNewuser("eaglemanjjs@hotmail.com", newUsername, "Auto", 
    			"Test", "MEI Ltd", "$Testtest1", "$Testtest1");
    	
    	Assert.assertTrue(objRegPage.getRegisterSubmit().toLowerCase().contains(
    			"you are registered! go ahead and login"));
    	System.out.println("[Test Case]Registration Success Verified");
    
    }
}
