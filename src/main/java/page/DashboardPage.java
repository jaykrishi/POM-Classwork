package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class DashboardPage {
	WebDriver driver;
	
	// Find all the webelements
	
	@FindBy(how = How.XPATH, using = "//*[@id=\"page-wrapper\"]/div[2]/div/h2") WebElement DASHBOARD_HEADER_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/a/span[1]") WebElement CUSTOMER_MENU_ELEMENT;
	@FindBy(how = How.XPATH, using = "//*[@id=\"side-menu\"]/li[3]/ul/li[1]/a") WebElement ADD_CUSTOMER_MENU_ELEMENT;
	
	// Constructor
	
	public DashboardPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public void verifyDashboardPage() {
		Assert.assertEquals(DASHBOARD_HEADER_ELEMENT.getText(), "Dashboard", "Dashboar page not found.");
	}
	
	public void clickCustomerMenuButton() {
		CUSTOMER_MENU_ELEMENT.click();
	}

	public void clickAddCustomerMenuButton() {
		ADD_CUSTOMER_MENU_ELEMENT.click();
	}

}
