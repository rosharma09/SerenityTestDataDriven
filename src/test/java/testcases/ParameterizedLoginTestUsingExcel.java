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
import utilities.ExcelReader;

@RunWith(SerenityParameterizedRunner.class)
public class ParameterizedLoginTestUsingExcel {

	/**
	 * Create the instance variable as per the login excel data
	 */

	private String username;
	private String password;

	/**
	 * Create the constructor of the class
	 */

	public ParameterizedLoginTestUsingExcel(String username, String password) {
		this.username = username;
		this.password = password;
	}

	/**
	 * Write the data provider method using @TestData annotation
	 */

	@TestData
	public static Collection<Object[]> getTestData() {
		String sheetName = "LoginTestDataSheet";
		ExcelReader readerObj = new ExcelReader("src/test/java/testdata/LoginTestData.xlsx");

		System.out.println("Rows fetched :" + readerObj.getRowCount(sheetName));
		System.out.println("Columns fetched :" + readerObj.getColumnCount(sheetName));

		int totalRows = readerObj.getRowCount(sheetName);
		int totalCols = readerObj.getColumnCount(sheetName);

		Object[][] data = new Object[totalRows-1][totalCols];

		/*
		 * data[0][0] = readerObj.getCellData(sheetName, 0, 2); data[0][1] =
		 * readerObj.getCellData(sheetName, 1, 2);
		 */

		for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
			for (int colNum = 0; colNum < totalCols; colNum++) {
				data[rowNum - 2][colNum] = readerObj.getCellData(sheetName, colNum, rowNum);
				System.out.println(data[rowNum - 2][colNum]);
			}
		}

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
