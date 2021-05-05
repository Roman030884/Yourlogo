package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthenticationTest extends BaseTest{

    @Test(dataProvider = "CreateAccountDataProvider",dataProviderClass = EmailData.class,retryAnalyzer = Retry.class,
            description ="Checking the login to the CREATE AN ACCOUNT page using different domains")
    public void checkingLoginCreateAnAccountPage(String emailData){
        loginPage.openHomePage();
        loginPage.clickSignInElement();
        authenticationPage.getEmailForAccount(emailData);
        Assert.assertEquals(authenticationPage.stringCreateAnAccount(),"CREATE AN ACCOUNT",
                "you are not logged in to the CREATE AN ACCOUNT page");
    }
}