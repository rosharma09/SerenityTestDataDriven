package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Narrative;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import stepdefination.CreateAccountPageSteps;
import stepdefination.LoginPageSteps;
import utilities.ExcelReader;

@Narrative(text = { "In order to use the application", "The user needs to first register himself to the appilcation",
		"The user is required to provide certain details in order to register",
		"failing to provide the correct details the user is not allowed to register himself" })
@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "4")
public class NarativesExampleUsingSerenity {
	private String title;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String DOB;
	private String company;
	private String address;
	private String addressLine2;
	private String city;
	private String State;
	private String pinCode;
	private String addInfo;
	private String homePhn;
	private String mobilePhn;

	public NarativesExampleUsingSerenity(String title, String firstName, String lastName, String email, String password,
			String DOB, String company, String address, String addressLine2, String city, String State, String pinCode,
			String addInfo, String homePhn, String mobilePhn) {
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.DOB = DOB;
		this.company = company;
		this.address = address;
		this.addressLine2 = addressLine2;
		this.city = city;
		this.State = State;
		this.pinCode = pinCode;
		this.addInfo = addInfo;
		this.homePhn = homePhn;
		this.mobilePhn = mobilePhn;
	}

	@TestData
	public static Collection<Object[]> getTestData() {

		String sheetName = "RegisterUserData";
		ExcelReader readerObj = new ExcelReader("src/test/java/testdata/RegisterUserData.xlsx");

		int totalRows = readerObj.getRowCount(sheetName);
		int totalCols = readerObj.getColumnCount(sheetName);

		Object[][] testdata = new Object[totalRows - 1][totalCols];
		for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
			for (int colNum = 0; colNum < totalCols; colNum++) {
				testdata[rowNum - 2][colNum] = readerObj.getCellData(sheetName, colNum, rowNum);
			}
		}

		return Arrays.asList(testdata);
	}

	@Managed
	WebDriver driverObj;

	@Steps
	LoginPageSteps user;

	@Steps
	CreateAccountPageSteps userAtRegisterationPage;

	@Title(value = "In order to use the application, the user need to register with the application")
	@Test
	public void regiesterUser() {

		// Given
		user.NavigateTo();

		// When
		user.enterTheEmailIdToRegisterWith(email);

		// And
		user.clickOnTheCreateAccntBtn();

		// When
		userAtRegisterationPage.fillTheFormWithTheFollowingDetails(title, firstName, lastName, email, password, DOB,
				company, address, addressLine2, city, State, pinCode, addInfo, homePhn, mobilePhn);

	}
}
