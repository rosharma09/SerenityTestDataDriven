package applicationPages;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class CreateAccountPage extends PageObject {

	public void fillTheRegisterationForm(String title, String fname, String lname, String password, String DOB,
			String company, String address1, String address2, String city, String state, String pincode,
			String additionalInfo, String homePhone, String mobilePhn) {

		WebElementFacade titleHeader = $("//div[@class = 'radio-inline']");
		WebElementFacade firstName = $("//input[@id = 'customer_firstname']");
		WebElementFacade lastName = $("//input[@id = 'customer_lastname']");
		WebElementFacade passwordField = $("//input[@id = 'passwd']");

		WebElementFacade company1 = $("//input[@id = 'company']");
		WebElementFacade address = $("//input[@id = 'address1']");
		WebElementFacade addressLine2 = $("//input[@id = 'address2']");
		WebElementFacade city1 = $("//input[@id = 'city']");
		WebElementFacade state1 = $("//select[@id = 'id_state']");
		WebElementFacade pinCode = $("//input[@id = 'postcode']");
		WebElementFacade addInfoField = $("//textarea[@id = 'other']");
		WebElementFacade homePhnField = $("//input[@id = 'phone']");
		WebElementFacade PhnField = $("//input[@id = 'phone_mobile']");

		/*
		 * List<WebElementFacade> titleLabeles =
		 * titleHeader.thenFindAll(By.tagName("label")); for (WebElementFacade
		 * titleLabel : titleLabeles) { if (title.equals(titleLabel.getText())) {
		 * clickOn(titleLabel); } }
		 */

		typeInto(firstName, fname);
		typeInto(lastName, lname);
		typeInto(passwordField, password);
		selectDates(DOB);
		typeInto(company1, company);
		typeInto(address, address1);
		typeInto(addressLine2, address2);
		typeInto(addressLine2, address2);
		typeInto(city1, city);
		state1.selectByVisibleText(state);
		typeInto(pinCode, pincode);
		typeInto(addInfoField, additionalInfo);
		typeInto(homePhnField, homePhone);
		typeInto(PhnField, mobilePhn);

	}

	public void selectDates(String dateFormat) {

		WebElementFacade dayPicker = $("//select[@id = 'days']");
		WebElementFacade monthPicker = $("//select[@id = 'months']");
		WebElementFacade yearPicker = $("//select[@id = 'years']");

		String[] dateSplit = dateFormat.replaceAll("\"", "").split("-");
		System.out.println("Selecting the date as: " + dateSplit[0]);
		dayPicker.selectByValue(dateSplit[0]);
		System.out.println("Selecting the month as: " + dateSplit[1]);
		monthPicker.selectByValue(String.valueOf(getValueForMonth(dateSplit[1])));
		System.out.println("Selecting the year as: " + dateSplit[2]);
		yearPicker.selectByValue(dateSplit[2]);
	}

	public int getValueForMonth(String month) {
		switch (month) {
		case "January":
			return 1;
		case "Feburary":
			return 2;
		case "March":
			return 3;
		case "April":
			return 4;
		case "May":
			return 5;
		case "June":
			return 6;
		case "July":
			return 7;
		case "August":
			return 8;
		case "September":
			return 9;
		case "October":
			return 10;
		case "November":
			return 11;
		case "December":
			return 12;
			
		default: 
			System.out.println("Not a valid month selected");
			return 0;
		}
	}
}
