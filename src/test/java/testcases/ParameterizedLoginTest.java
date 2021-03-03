package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.TestData;
import stepdefination.LoginPageSteps;

@RunWith(SerenityParameterizedRunner.class)
public class ParameterizedLoginTest {

	/**
	 * In order to use the parameterization concept in JUnit we need to first create
	 * variables to store the values
	 * 
	 * i.e. in case if we have data columns as username and password as shown in the
	 * below example then we need to use two variables to store the data
	 */
	private String username;
	private String password;

	/**
	 * Create a constructor of the class and intialize the global variables
	 *
	 */

	public ParameterizedLoginTest(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * In order to get the data we need to user @TestData annotation to define the
	 * getData() method and the method should be static in nature
	 * 
	 * @return : Return a Collection of Object array
	 */
	@TestData
	public static Collection<Object[]> getData() {
		Object[][] data = new Object[2][2];

		data[0][0] = "testuser@gmail.com";
		data[0][1] = "password001";

		data[1][0] = "etluser@gmail.com";
		data[1][1] = "testpass";

		return Arrays.asList(data);
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
