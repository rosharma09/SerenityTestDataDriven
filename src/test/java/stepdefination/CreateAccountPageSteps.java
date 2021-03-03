package stepdefination;

import applicationPages.CreateAccountPage;
import net.thucydides.core.annotations.Step;

public class CreateAccountPageSteps {

	CreateAccountPage createAccountPageObj;

	@Step("Fills The form with the details")
	public void fillTheFormWithTheFollowingDetails(String title, String firstName, String lastName, String email,
			String password, String DOB, String company, String address, String addressLine2, String city, String state,
			String pinCode, String addInfo, String homePhn, String mobilePhn) {
		createAccountPageObj.fillTheRegisterationForm(title, firstName, lastName, password, DOB, company, address,
				addressLine2, city, state, pinCode, addInfo, homePhn, mobilePhn);
	}

}
