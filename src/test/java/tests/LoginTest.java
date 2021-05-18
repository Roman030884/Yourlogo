package tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Retry;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "log in to your personal account")
    public void CheckingEnteringInAccountTest() {
        loginPage.openHomePage();
        loginPage.clickSignInButton();
        loginPage.inputEmailAndPasswordAndClickSingIn("paladin03.84@mail.ru", "74185");
        Assert.assertEquals(loginPage.getMyAccountTitle(), "MY ACCOUNT", "Login to your personal account failed or" +
                    " the element was not found");
    }

    @Test(retryAnalyzer = Retry.class, description = "After clicking the  icon Home " +
            "you should be a transition to the home page")
    public void CheckingTransitionInHomePageTest() {
        loginPage.openMyAccountPage();
        Assert.assertEquals(loginPage.backHomePageAndFindContactUsElement(), "Contact us", "You did not into HomePage or " +
                " element of comparisons was not found in HomePage ");
    }
}