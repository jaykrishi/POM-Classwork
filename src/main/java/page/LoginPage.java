package page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	
	// First find all the webelements
		@FindBy(how = How.XPATH, using = "//*[@id=\"username\"]")
		WebElement USERNAME_ELEMENT;
		@FindBy(how = How.XPATH, using = "//*[@id=\"password\"]")
		WebElement PASSWORD_ELEMENT;
		@FindBy(how = How.XPATH, using = "/html/body/div/div/div/form/div[3]/button")
		WebElement SIGNIN_BUTTON_ELEMENT;		
	
	
	// constructor	
	// This constructor is invoked when object of this page is created in LoginTest.java
		public LoginPage(WebDriver driver) {
 		 this.driver = driver;
		 PageFactory.initElements(driver,this);
		 // Initializes WebElements declared in this class using driver instance.
	
	}
	
		
	//Write all methods/actions
	public void insertUserName(String userName) {
		USERNAME_ELEMENT.sendKeys(userName);
	}
	
	public void insertPassword(String password) {
		PASSWORD_ELEMENT.sendKeys(password);
	}
	
	public void clickSigninButton() {
		SIGNIN_BUTTON_ELEMENT.click();
	}
	
	public void loginIn(String userName, String password) {
		USERNAME_ELEMENT.sendKeys(userName);
		PASSWORD_ELEMENT.sendKeys(password);
		SIGNIN_BUTTON_ELEMENT.click();
	}

}
