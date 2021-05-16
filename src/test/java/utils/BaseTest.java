package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;
import pages.AccountFormPage;
import pages.AuthenticationPage;
import pages.CartPage;
import pages.LoginPage;

import java.util.concurrent.TimeUnit;

@Listeners(TestListener.class)

public class BaseTest {
    public WebDriver driver;
    public LoginPage loginPage;
    public CartPage cartPage;
    public AuthenticationPage authenticationPage;
    public AccountFormPage accountFormPage;

    @BeforeTest
    public void setup(ITestContext context) {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(chromeOptions);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        context.setAttribute("driver", driver);
        loginPage = new LoginPage(driver);
        cartPage = new CartPage(driver);
        accountFormPage = new AccountFormPage(driver);
        authenticationPage = new AuthenticationPage(driver);
    }

    @AfterTest(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}