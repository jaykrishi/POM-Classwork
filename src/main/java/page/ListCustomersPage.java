package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ListCustomersPage extends BasePage{
	WebDriver driver;
	//findElement
	@FindBy(how = How.XPATH, using = "//div[@class='panel-body']/a[contains(text(),'Add Customer')]")
	WebElement LIST_CUSTOMER_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//input[@id='foo_filter']")
	WebElement SEARCH_ELEMENT;
	@FindBy(how = How.XPATH, using = "//a[@class='btn btn-primary btn-xs']")
	WebElement SEARCH_ICON_ELEMENT;
	
	public ListCustomersPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		// Initializes WebElements declared in this class using driver instance
	}
	
	// Methods/Actions on your webelements
	
		public void verifyListCustomersPage(){
			waitForElement(driver, 5, LIST_CUSTOMER_HEADER_ELEMENT);
			Assert.assertEquals(LIST_CUSTOMER_HEADER_ELEMENT.getText(), "Add Customer", "Wrong page!!!");
		}
		
		public void searchName(String name) {
			
			SEARCH_ELEMENT.sendKeys(name);
		}
		
		public void searchIcon() {
			waitForElement(driver,5,SEARCH_ICON_ELEMENT);
			SEARCH_ICON_ELEMENT.click();
		}

}
