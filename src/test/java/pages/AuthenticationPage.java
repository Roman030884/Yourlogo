package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AuthenticationPage extends BasePage {

    private static final By EMAIL_FIELD = By.id("email_create");
    private static final By STRING_CREATE_AN_ACCOUNT = By.xpath("//h1[text()='Create an account']");

    public AuthenticationPage(WebDriver driver) {
        super(driver);
    }

    public void getEmailForAccount(String emailData) {
        driver.findElement(EMAIL_FIELD).sendKeys(emailData);
        driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();
    }

    public String stringCreateAnAccount() {
        return driver.findElement(STRING_CREATE_AN_ACCOUNT).getText();
    }

}