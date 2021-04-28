package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "log in to your personal account")
    public void shouldBeClientLogging() {
        loginPage.openHomePage();
        loginPage.clickSignInPage();
        loginPage.login("paladin03.84@mail.ru", "74185");
        Assert.assertEquals(loginPage.seekStringMyAccount(), "MY ACCOUNT", "Login to your personal account failed or" +
                    " the element was not found");
    }

    @Test(retryAnalyzer = Retry.class, description = "After clicking the  icon Home " +
            "you should be a transition to the home page")
    public void shouldBeTransitionToTheHomePage() {
        loginPage.pageMyAccount();
        Assert.assertEquals(loginPage.backHomePageAndFindElement(), "Contact us", "You did not into HomePage or " +
                " element of comparisons was not found in HomePage ");
    }
}