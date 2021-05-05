package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartPage extends BasePage {

    private static final By IMG_PRODUCT = By.xpath("//img[@alt='Faded Short Sleeve T-shirts']");
    private static final By BUTTON_ADD_TO_CART = By.xpath("//span[contains(text(),'Add to cart')]");
    private static final By BUTTON_PROCEED_TO_CHECKOUT = By.xpath("//span[contains(text(),'Proceed to checkout')]");
    private static final By PRODUCT = By.xpath("//*[text()='Faded Short Sleeve T-shirts']");
    private static final By BUTTON_PROCEED_TOTO_CHECKOUT_PAGE_SUMMARY = By.xpath("//a[span[text()='Proceed to checkout']]");
    private static final By BUTTON_PROCEED_TO_CHECKOUT_PAGE_ADDRESSES = By.name("processAddress");
    private static final By CHECKBOX_SHIPPING = By.id("cgv");
    private static final By BUTTON_PROCEED_TO_CHECKOUT_PAGE_SHIPPING = By.name("processCarrier");
    private static final By BANK_WIRE = By.className("bankwire");
    private static final By BUTTON_I_CONFIRM_MY_ORDER = By.xpath("//span[text()='I confirm my order']");
    private static final By ORDER_IS_COMPLETE = By.xpath("//strong[@class='dark'][text()='Your order on My Store is complete.']");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCard() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(IMG_PRODUCT)).build().perform();
        driver.findElement(BUTTON_ADD_TO_CART).click();
        driver.findElement(BUTTON_PROCEED_TO_CHECKOUT).click();
    }

    public String product() {
        return driver.findElement(PRODUCT).getText();
    }

    public void clickProceedToCheckout() {
        driver.findElement(BUTTON_PROCEED_TOTO_CHECKOUT_PAGE_SUMMARY).click();
        driver.findElement(BUTTON_PROCEED_TO_CHECKOUT_PAGE_ADDRESSES).click();
        driver.findElement(CHECKBOX_SHIPPING).click();
        driver.findElement(BUTTON_PROCEED_TO_CHECKOUT_PAGE_SHIPPING).click();
    }

    public void typeOfPaymentBankWire() {
        driver.findElement(BANK_WIRE).click();
        driver.findElement(BUTTON_I_CONFIRM_MY_ORDER).click();
    }

    public String orderIsComplete() {
        return driver.findElement(ORDER_IS_COMPLETE).getText();
    }
}