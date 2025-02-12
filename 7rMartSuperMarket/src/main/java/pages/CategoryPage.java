package pages;

import java.awt.AWTException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import constant.Constant;
import utility.FileUploadUtility;
import utility.PageUtility;
import utility.WaitUtility;

public class CategoryPage {

	public WebDriver driver;
	WaitUtility wait = new WaitUtility();
	FileUploadUtility fileupload = new FileUploadUtility();
	PageUtility page = new PageUtility();

	public CategoryPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//a[@class='btn btn-rounded btn-danger']")
	WebElement btn_category_new;

	@FindBy(xpath = "//input[@id='category']")
	WebElement txt_category_input;

	@FindBy(xpath = "//li[@id='134-selectable']")
	WebElement box_select_groups;

	@FindBy(xpath = "//input[@type='file']")
	WebElement btn_choose_file;

	@FindBy(xpath = "//button[@class='btn btn-danger']")
	WebElement btn_save;

//alert	
	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_locator;

	// delete
	@FindBy(xpath = "(//a[@class='btn btn-sm btn btn-danger btncss'])[1]")
	WebElement btn_delete;

	@FindBy(xpath = "//div[@class='alert alert-success alert-dismissible']")
	WebElement alert_locator_delete;

	public CategoryPage btnCategoryNewClick() {
		btn_category_new.click();
		return this;
	}

	public CategoryPage nameCategory(String category_name) {
		txt_category_input.sendKeys(category_name);
		return this;
	}

	public CategoryPage btnDiscountClick() {
		box_select_groups.click();
		return this;
	}

	public CategoryPage btnFileClick() {
		btn_choose_file.click();
		return this;
	}

	public CategoryPage fileUploadSendKeys() throws AWTException, InterruptedException {
		wait.waitForVisibilityOfElement(driver, btn_choose_file);
		fileupload.sendKeysForFileUpload(btn_choose_file, Constant.IMAGE);
		return this;
	}

	public CategoryPage btnCategorySaveClick() {

		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Scroll to the bottom of the page
		js.executeScript("window.scrollTo(0, document.body.scrollHeight);");

		// Wait for the element to be visible
		wait.waitForVisibilityOfElement(driver, btn_save);

		// Click using JavaScript if regular click doesn't work
		js.executeScript("arguments[0].click();", btn_save);

		return this;
	}

	public boolean isCategoryCreatedSucessDisplayed() {
		return alert_locator.isDisplayed();
	}

	public CategoryPage btnCategoryDeleteClick() {
		btn_delete.click();
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return this;
	}

	public boolean isCategoryDeleted() {
		return alert_locator_delete.isDisplayed();
	}

}
