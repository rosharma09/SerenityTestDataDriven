package stepdefination;

import applicationPages.CreateAccountPage;
import applicationPages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginPageSteps {

	private String actor;

	private LoginPage loginPageObj;
	private CreateAccountPage createAccountPageObj;

	@Step("#actor navigates to the application URL using the browser")
	public void NavigateTo() {
		loginPageObj.launchTheApplicationURL();
	}

	@Step("#actor enter the username as {0}")
	public void enterUsername(String username) {
		System.out.println("Username Entered:" + username);
		loginPageObj.enterIntoUsernameField(username);
	}

	@Step("#actor enter the password as {0}")
	public void enterPassword(String password) {
		System.out.println("Password Entered:" + password);

		loginPageObj.enterIntoPasswordField(password);
	}

	@Step("#actor click on the submit button")
	public void clickOnSubmitButton() {
		loginPageObj.clickLoginButton();
	}

	public void enterTheEmailIdToRegisterWith(String email) {
		loginPageObj.enterIntoRegisterEmailField(email);
	}

	public void clickOnTheCreateAccntBtn() {
		createAccountPageObj = loginPageObj.clickOnRegisterButton();
	}

}
