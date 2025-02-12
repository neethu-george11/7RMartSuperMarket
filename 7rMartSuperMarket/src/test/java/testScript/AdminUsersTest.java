package testScript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import constant.Constant;
import pages.AdminUsersPage;
import pages.HomePage;
import pages.LoginPage;
import utility.ExcelUtility;
import utility.FakerUtility;

public class AdminUsersTest extends Base {
	public HomePage home;
	public AdminUsersPage admin_users;
	public String usernamefaker;
	public String passwordfaker;
	public FakerUtility faker;

	@Test(priority = 1, retryAnalyzer = retry.Retry.class)
	@Parameters({ "username", "password" })

	public void verifyCreationOfNewAdminUsers(String username, String password) throws IOException {

		// String username_valid = ExcelUtility.getStringData(1, 0,"AdminUserTestData");
		// String password_valid = ExcelUtility.getStringData(1, 1,"AdminUserTestData");

		// String username_new = ExcelUtility.getStringData(2, 0, "AdminUserTestData");
		// String password_new = ExcelUtility.getStringData(2, 1, "AdminUserTestData");

		FakerUtility faker = new FakerUtility();

		usernamefaker = faker.getFakeFirstName();

		passwordfaker = ExcelUtility.getStringData(1, 1, "AdminUserTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username, password);

		home = login.clickSignInButton();

		admin_users = home.adminUsersClick();

		admin_users.clickBtnNew();
		admin_users.enterUsermame(usernamefaker);
		admin_users.enterPassword(passwordfaker);
		admin_users.selectUserType();
		admin_users.clickSave();

		// Assertion
		boolean isSucessfullyNewAdminCreated = admin_users.isAlertSucessDisplayed();
		Assert.assertTrue(isSucessfullyNewAdminCreated, Constant.ERROR_MSG_CreationOfNewAdminUsers);

	}

	@Test(priority = 2)
	public void verifyAdminUserSearch() throws IOException {
		String username_valid = ExcelUtility.getStringData(1, 0, "AdminUserTestData");
		String password_valid = ExcelUtility.getStringData(1, 1, "AdminUserTestData");

		String username_search = ExcelUtility.getStringData(3, 0, "AdminUserTestData");

		LoginPage login = new LoginPage(driver);
		login.setUserNamePassword(username_valid, password_valid);
		home = login.clickSignInButton();
		admin_users = home.adminUsersClick();
		admin_users.clickBtnSearch();
		admin_users.enterSearchUsermame(username_search);
		admin_users.selectUserTypeSearch();
		admin_users.clickBtnSearchInsideSearch();

		// Assertion
		boolean isSucessfullySearchResultFound = admin_users.isSearchResultDisplayed();
		Assert.assertTrue(isSucessfullySearchResultFound, Constant.ERROR_MSG_AdminUserSearch);

	}

}
