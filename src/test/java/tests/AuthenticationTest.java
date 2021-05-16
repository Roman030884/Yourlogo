package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Retry;

public class AuthenticationTest extends BaseTest {

    @Test(dataProvider = "CreateAccountDataProvider", dataProviderClass = EmailData.class, retryAnalyzer = Retry.class,
            description ="Checking the login to the CREATE AN ACCOUNT page using different domains")
    public void checkingLoginCreateAnAccountPage(String emailData){
        loginPage.openHomePage();
        loginPage.clickSignInButton();
        authenticationPage.inputEmailForAccount(emailData);
        Assert.assertEquals(authenticationPage.findCreateAnAccountTitleOnPage(),"CREATE AN ACCOUNT",
                "you are not logged in to the CREATE AN ACCOUNT page");
    }
}