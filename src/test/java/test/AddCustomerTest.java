package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import page.AddCustomerPage;
import page.DashboardPage;
import page.ListCustomersPage;
import page.LoginPage;
import util.BrowserFactory;

public class AddCustomerTest {
	WebDriver driver;
	
	@Test(priority=2)
	public void validUserShouldBeAbleToCreateCustomer() throws InterruptedException {
		driver = BrowserFactory.init();
		
		LoginPage objlogin = new LoginPage(driver);
		objlogin.insertUserName("demo@techfios.com");
		objlogin.insertPassword("abc123");
		objlogin.clickSigninButton();
		
		DashboardPage objdashboardPage = new DashboardPage(driver);
		objdashboardPage.verifyDashboardPage();
		objdashboardPage.clickCustomerMenuButton();
		objdashboardPage.clickAddCustomerMenuButton();
		
		AddCustomerPage addCustomerPage = PageFactory.initElements(driver, AddCustomerPage.class);
		addCustomerPage.verifyAddContactPage();
		String name = addCustomerPage.insertFullName("Jack Hill");
		addCustomerPage.selectCompanyDropdown("Techfios");
		addCustomerPage.insertEmail("kk@yahoo.com");
		addCustomerPage.insertphone("12");
		addCustomerPage.insertaddress("sada");
		addCustomerPage.insertcity("Dallas");
		addCustomerPage.selectCountryDropdown("United States");
		addCustomerPage.selectTagsDropdown("adad");
		addCustomerPage.selectCurrencyDropdown("USD");
		addCustomerPage.selectGroupDropdown("wdwd");
		addCustomerPage.saveButton();
		
		addCustomerPage.verifynewlyAddContactPage();
		addCustomerPage.listcustomers();
		
		
		ListCustomersPage listCustomerPage = new  ListCustomersPage(driver);
		listCustomerPage.verifyListCustomersPage();
		
		listCustomerPage.searchName(name);
		listCustomerPage.searchIcon();
		
		
	}

}
