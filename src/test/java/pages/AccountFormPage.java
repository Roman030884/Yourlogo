package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import static utils.TestUtil.randomEmail;


public class AccountFormPage extends BasePage {

    private static final By BUTTON_REGISTER = By.xpath("//span[text()='Register']");
    private static final By CUSTOMER_FIRST_NAME_FIELD = By.id("customer_firstname");
    private static final By CUSTOMER_LAST_NAME_FIELD = By.id("customer_lastname");
    private static final By PASSWORD_FIELD = By.id("passwd");
    private static final By ADDRESS1_FIELD = By.id("address1");
    private static final By CITY_FIELD = By.id("city");
    private static final By ZIP_CODE_FIELD = By.id("postcode");
    private static final By MOBILE_PHONE_FIELD = By.id("phone_mobile");
    private static final By ASSIGN_ADDRESS_FIELD = By.id("alias");
    private static final By STATE = By.id("id_state");
    private static final By LOGOUT = By.className("logout");
    private static final By EMAIL_FIELD = By.id("email_create");
    private static final By CONTACT_US = By.xpath("//a[contains(text(),'Contact us')]");
    private static final By BUTTON_CREATE = By.xpath("//*[@id='SubmitCreate']/span");
    private static final String PAIRWISE_CREATE_ACCOUNT_FORM = "https://pairwise.teremokgames.com/19bek/ ";

    public AccountFormPage(WebDriver driver) {
        super(driver);
    }

    @Step("Filling out the registration form")
    public void fillOutRegistrationForm(String customerFirstName, String customerLastName, String password,
                                        String address, String city, String zipCode, String mobilePhone,
                                        String assignAddress) {
        driver.findElement(CUSTOMER_FIRST_NAME_FIELD).sendKeys(customerFirstName);
        driver.findElement(CUSTOMER_LAST_NAME_FIELD).sendKeys(customerLastName);
        driver.findElement(PASSWORD_FIELD).sendKeys(password);
        driver.findElement(ADDRESS1_FIELD).sendKeys(address);
        driver.findElement(CITY_FIELD).sendKeys(city);
        driver.findElement(ZIP_CODE_FIELD).sendKeys(zipCode);
        driver.findElement(MOBILE_PHONE_FIELD).sendKeys(mobilePhone);
        driver.findElement(ASSIGN_ADDRESS_FIELD).sendKeys(assignAddress);
    }

    public void submitRegistrationForm() {
        driver.findElement(BUTTON_REGISTER).click();
    }

    @Step("Filling out the field State")
    public void chooseStateFromDropDown(String state) {
        driver.findElement(STATE).click();
        Select dropdown = new Select(driver.findElement(STATE));
        dropdown.selectByVisibleText(state);
    }

    @Step("Generation random mail and go to authentication page")
    public void inputEmailAndGoToAuthenticationPage() {
        driver.findElement(EMAIL_FIELD).sendKeys(randomEmail(32));
        driver.findElement(BUTTON_CREATE).click();
    }

    @Step("Search for an element (Contact us) to compare")
    public String getContactUsButtonName() {
        return driver.findElement(CONTACT_US).getText();
    }

    @Step("Mandatory cleaning the field before filling out the field Assign address")
    public void cleanAddressField() {
        driver.findElement(ASSIGN_ADDRESS_FIELD).clear();
    }

    @Step("Log out of the subscriber's personal account")
    public void logout() {
        driver.findElement(LOGOUT).click();
    }
}