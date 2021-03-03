package testcases;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.UseTestDataFrom;
import stepdefination.LoginPageSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/java/testdata/LoginTestData.csv")
@Concurrent(threads = "8")
public class ParameterizedLoginTestUsingCSVConcurrent {
	
	private String username;
	private String password;

	public void setUsername(String username) {
		this.username = username;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Managed
	WebDriver browser;

	@Steps
	LoginPageSteps user;

	@Test
	public void loginTest() {
		// Given
		user.NavigateTo();

		// When
		user.enterUsername(username);

		// And
		user.enterPassword(password);

		// And
		user.clickOnSubmitButton();
	}


}
