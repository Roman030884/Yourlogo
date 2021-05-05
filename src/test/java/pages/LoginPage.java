package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    private static final By SIGN_IN = By.className("login");
    private static final By EMAIL = By.id("email");
    private static final By PASSWORD = By.id("passwd");
    private static final By BUTTON_SIGN_IN = By.id("SubmitLogin");
    private static final By ICON_HOME_PAGE = By.className("icon-home");
    private static final By CONTACT_US = By.xpath("//a[contains(text(),'Contact us')]");
    private static final String URL_HOME_PAGE = "http://automationpractice.com";
    private static final By MY_ACCOUNT = By.className("page-heading");
    private static final String URL_PAGE_MY_ACCOUNT = "http://automationpractice.com/index.php?controller=my-account";


    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void pageMyAccount() {
        driver.get(URL_PAGE_MY_ACCOUNT);
    }

    public void clickSignInElement() {
        driver.findElement(SIGN_IN).click();
    }

    public void login(String email, String password) {
        driver.findElement(EMAIL).sendKeys(email);
        driver.findElement(PASSWORD).sendKeys(password);
        driver.findElement(BUTTON_SIGN_IN).click();
    }

    public String backHomePageAndFindElement() {
        driver.findElement(ICON_HOME_PAGE).click();
        return driver.findElement(CONTACT_US).getText();
    }

    public String getStringMyAccount() {
        return driver.findElement(MY_ACCOUNT).getText();
    }
    public void openHomePage() {
        driver.get(URL_HOME_PAGE);
    }
}
