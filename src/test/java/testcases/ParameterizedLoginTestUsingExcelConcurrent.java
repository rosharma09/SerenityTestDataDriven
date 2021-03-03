package testcases;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.Concurrent;
import net.thucydides.junit.annotations.TestData;
import stepdefination.LoginPageSteps;
import utilities.ExcelReader;

@RunWith(SerenityParameterizedRunner.class)
@Concurrent(threads = "6")
public class ParameterizedLoginTestUsingExcelConcurrent {

	private String username;
	private String password;

	public ParameterizedLoginTestUsingExcelConcurrent(String username, String password) {

		this.username = username;
		this.password = password;
	}

	@TestData
	public static Collection<Object[]> getTestData() {

		ExcelReader readerObj = new ExcelReader("src/test/java/testdata/LoginTestData.xlsx");
		String sheetName = "LoginTestDataSheet";

		int totalRows = readerObj.getRowCount(sheetName);
		int totalCols = readerObj.getColumnCount(sheetName);

		System.out.println("Total rows fetched from the excel: " + totalRows);
		System.out.println("Total columns fetched from the excel: " + totalCols);

		Object[][] testdata = new Object[totalRows - 1][totalCols];

		for (int rowNum = 2; rowNum <= totalRows; rowNum++) {
			for (int colNum = 0; colNum < totalCols; colNum++) {
				testdata[rowNum-2][colNum] = readerObj.getCellData(sheetName, colNum, rowNum);
			}
		}
		
		return Arrays.asList(testdata);
	}

	@Managed
	WebDriver driverObj;

	@Steps
	LoginPageSteps user;

	@Test
	public void concurrentLoginTest() {
		// given
		user.NavigateTo();

		// When
		user.enterUsername(username);

		// And
		user.enterPassword(password);

		// And
		user.clickOnSubmitButton();

	}
}
