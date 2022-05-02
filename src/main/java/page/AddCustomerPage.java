package page;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class AddCustomerPage extends BasePage{
	WebDriver driver;

	// Find all the webelements
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[3]/div[1]/div/div/div/div[1]/h5") WebElement ADD_CONTACT_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"account\"]") WebElement FULL_NAME_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"cid\"]") WebElement COMPANY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='email']") WebElement EMAIL_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='phone']") WebElement PHONE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='address']") WebElement ADDRESS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='city']") WebElement CITY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='state']") WebElement STATE_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='zip']") WebElement ZIP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='country']") WebElement COUNTRY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='tags']") WebElement TAGS_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='currency']") WebElement CURRENCY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//select[@id='group']") WebElement GROUP_ELEMENT;
	@FindBy(how = How.XPATH, using = "//button[@id='submit']") WebElement BUTTON_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Summary')]") WebElement SUMMARY_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'List Customers')]") WebElement LIST_CUSTOMERS_ELEMENT;
	// Create a Constructor 
	// This constructor is invoked when object of this page is created in AddCustomerTest.java
	public AddCustomerPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Initializes WebElements declared in this class using driver instance
	}
	
	
	// Methods/Actions on your webelements
	
	public void verifyAddContactPage(){
		waitForElement(driver, 5, ADD_CONTACT_HEADER_ELEMENT);
		Assert.assertEquals(ADD_CONTACT_HEADER_ELEMENT.getText(), "Add Contact", "Wrong page!!!");
	}
	
	

	public String insertFullName(String fullName) {
		String insertedName = fullName + generateRandom(999);
		FULL_NAME_ELEMENT.sendKeys(insertedName);
		String name = (FULL_NAME_ELEMENT.getAttribute("value"));
		System.out.println(name);
		return name;
	}

	public void selectCompanyDropdown(String company) {
		selectFromDropdown(COMPANY_ELEMENT, company);
	}
	
	public void insertEmail(String email) {
		String insertedemail =  generateRandom(9999)+ email;
		EMAIL_ELEMENT.sendKeys(insertedemail);
	}

	public void insertphone(String phone) {
		String insertedphone = phone + generateRandom(999);
		PHONE_ELEMENT.sendKeys(insertedphone);
	}
	
	public void insertaddress(String address) {
		String insertedaddress = address;
		ADDRESS_ELEMENT.sendKeys(insertedaddress);
	}
	public void insertcity(String city) {
		String insertedcity = city ;
		CITY_ELEMENT.sendKeys(insertedcity);
	}
	public void insertzip(String zip) {
		String insertedzip = zip + generateRandom(9);
		ZIP_ELEMENT.sendKeys(insertedzip);
	}
	public void selectCountryDropdown(String country) {
		selectFromDropdown(COUNTRY_ELEMENT, country);
	}
	public void selectTagsDropdown(String tags) {
		selectFromDropdown(TAGS_ELEMENT, tags);
	}
	public void selectCurrencyDropdown(String currency) {
		selectFromDropdown(CURRENCY_ELEMENT, currency);
	}
	public void selectGroupDropdown(String group) {
		selectFromDropdown(GROUP_ELEMENT, group);
	}
	public void saveButton() {
		BUTTON_ELEMENT.click();
	}
	
	public void verifynewlyAddContactPage() throws InterruptedException{
		waitForElement(driver, 5, SUMMARY_ELEMENT);
		Assert.assertEquals(SUMMARY_ELEMENT.getText(), "Summary", "Wrong page!!!");
		//Thread.sleep(3000);
	}
	
	public void listcustomers() {
		LIST_CUSTOMERS_ELEMENT.click();
	}
	
}
