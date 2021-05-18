package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {

    private static final By EMAIL_FIELD = By.id("email_create");
    private static final By STRING_CREATE_AN_ACCOUNT = By.xpath("//h1[text()='Create an account']");
    private static final By BUTTON_CREATE_AN_ACCOUNT = By.xpath("//*[@id='SubmitCreate']/span");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    @Step ("Filling in the mail field and logging in to the Create Account page")
    public void inputEmailForAccount(String emailData) {
        driver.findElement(EMAIL_FIELD).sendKeys(emailData);
        driver.findElement(BUTTON_CREATE_AN_ACCOUNT).click();
    }

    @Step ("Search for an element 'Create an account' for comparison" )
    public String findCreateAnAccountTitleOnPage() {
        return driver.findElement(STRING_CREATE_AN_ACCOUNT).getText();
    }

}