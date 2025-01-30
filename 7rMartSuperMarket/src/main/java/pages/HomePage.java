package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//li[@class='nav-item dropdown']")
	WebElement profile_Admin;

	@FindBy(xpath = "//a[@class='dropdown-item'][2]")
	WebElement logout_text;

	// AdminUsers-click
	@FindBy(xpath = "(//a[@class='small-box-footer'])[1]")
	WebElement admin_user_text;

	// Manage-News
	@FindBy(xpath = "(//a[@class='small-box-footer'])[9]")
	WebElement manage_news_text;

	// Sub-Category
	@FindBy(xpath = "(//a[@class='small-box-footer'])[4]")
	WebElement sub_category_txt;
	
	//Category
	@FindBy(xpath="(//a[@class='small-box-footer'])[3]")
	WebElement category_txt;

	public AdminUsersPage adminUsersClick() {
		admin_user_text.click();
		return new AdminUsersPage(driver);
	}

	public ManageNewsPage manageNewsClick() {
		manage_news_text.click();
		return new ManageNewsPage(driver);
	}

	public SubCategoryPage subCategoryClick() {
		sub_category_txt.click();
		return new SubCategoryPage(driver);
	}
	
	public CategoryPage categoryClick() {
		category_txt.click();
		return new CategoryPage(driver);
	}

	public HomePage clickLogout() {
		profile_Admin.click();
		logout_text.click();
		return this;
	}

}
