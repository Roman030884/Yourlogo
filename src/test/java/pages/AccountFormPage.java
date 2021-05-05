package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

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
    private static final String PAIRWISE_CREATE_ACCOUNT_FORM = "https://pairwise.teremokgames.com/19bek/ ";

    public AccountFormPage(WebDriver driver) {
        super(driver);
    }

    public void getRegistrationForm(String customerFirstName, String customerLastName, String password,
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

    public void getRegister() {
        driver.findElement(BUTTON_REGISTER).click();
    }

    public void getState(String state) {
        driver.findElement(STATE).click();
        Select dropdown = new Select(driver.findElement(STATE));
        dropdown.selectByVisibleText("Alabama");
    }

    public void emailForAccount() {
        driver.findElement(EMAIL_FIELD).sendKeys(randomEmail(32));
        driver.findElement(By.xpath("//*[@id='SubmitCreate']/span")).click();
    }

    public void setLogout() {
        driver.findElement(LOGOUT).click();
    }

    public static String randomEmail(int length) {
        Faker faker = new Faker();
        return faker.internet().emailAddress();
    }

    public String getContactUs() {
        return driver.findElement(CONTACT_US).getText();
    }
    public void getCleanField (){
        driver.findElement(ASSIGN_ADDRESS_FIELD).clear();
    }
}