package applicationPages;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class LoginPage extends PageObject {

	public void launchTheApplicationURL() {
		getDriver().get("http://automationpractice.com/index.php?controller=authentication&back=my-account");
	}

	public void enterIntoUsernameField(String username) {
		WebElementFacade usernameField = $("//*[@id=\"email\"]");
		typeInto(usernameField, username);
	}

	public void enterIntoPasswordField(String password) {
		WebElementFacade passwordField = $("//*[@id=\"passwd\"]");
		typeInto(passwordField, password);
	}

	public void clickLoginButton() {
		WebElementFacade signInBtn = $("//*[@id=\"SubmitLogin\"]");
		clickOn(signInBtn);
	}

	public void enterIntoRegisterEmailField(String email) {
		WebElementFacade createAccntEmailId = $("//*[@id = \"email_create\"]");
		typeInto(createAccntEmailId, email);
	}

	public CreateAccountPage clickOnRegisterButton() {
		WebElementFacade createAcctnBtn = $("//*[@id = \"SubmitCreate\"]");
		clickOn(createAcctnBtn);
		return new CreateAccountPage();
	}

}
