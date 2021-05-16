package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Retry;

public class AccountFormTest extends BaseTest {

    @Test(dataProvider = "FormAccountDataProvider", dataProviderClass =FormData.class, retryAnalyzer = Retry.class,
            description ="Checking the registration form fields upper " +
                    "and lower case, minimum password length, correct zipcode).")
    public void checkingCreationAccountForm(String customerFirstName, String customerLastName, String password,
                                            String address, String city, String zipCode, String mobilePhone,
                                            String assignAddress, String state){
        loginPage.openHomePage();
        loginPage.clickSignInButton();
        accountFormPage.inputEmailAndGoToAuthenticationPage();
        accountFormPage.cleanAddressField();
        accountFormPage.fillOutRegistrationForm(customerFirstName, customerLastName, password, address,
                city, zipCode, mobilePhone, assignAddress);
        accountFormPage.chooseStateFromDropDown(state);
        accountFormPage.submitRegistrationForm();
        accountFormPage.logout();
            Assert.assertEquals(accountFormPage.getContactUsButtonName(), "Contact us", "You did not into HomePage or " +
                    " element of comparisons was not found in HomePage ");
    }
}