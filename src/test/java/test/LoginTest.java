package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.DashboardPage;
import page.LoginPage;
import util.BrowserFactory;

public class LoginTest {
	WebDriver driver;
	
	@Test(priority=1)
	public void validUserShouldBeAbleToLogin() {
		
		driver = BrowserFactory.init();
		
		// Creating object of LoginPage and passing the driver instance as parameter to 
		//constructor of Loginpage.Java
		
		LoginPage objloginPage = new LoginPage(driver);
		objloginPage.insertUserName("demo@techfios.com");
		objloginPage.insertPassword("abc123");
		objloginPage.clickSigninButton();
		
		DashboardPage objdashboardPage = new DashboardPage(driver);
		objdashboardPage.verifyDashboardPage();
		
		BrowserFactory.tearDown();
		
	}

}
