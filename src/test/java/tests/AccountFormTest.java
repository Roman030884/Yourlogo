package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.Retry;

public class AccountFormTest extends BaseTest {

    @Test(dataProvider = "FormAccountDataProvider", dataProviderClass =FormData.class, retryAnalyzer = Retry.class,
            description ="Checking the registration form fields upper " +
                    "and lower case, minimum password length, correct zipcode).")
    public void checkingCreationAccountForm(String customerFirstName, String customerLastName, String password,
                                            String address, String city, String zipCode, String mobilePhone,
                                            String assignAddress, String state){
        loginPage.openHomePage();
        loginPage.clickSignInElement();
        accountFormPage.setEmailForAccount();
        accountFormPage.getCleanField();
        accountFormPage.fillOutRegistrationForm(customerFirstName, customerLastName, password, address,
                city, zipCode, mobilePhone, assignAddress);
        accountFormPage.setState(state);
        accountFormPage.getRegister();
        accountFormPage.logout();
            Assert.assertEquals(accountFormPage.getContactUs(), "Contact us", "You did not into HomePage or " +
                    " element of comparisons was not found in HomePage ");
    }
}