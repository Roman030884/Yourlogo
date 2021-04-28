package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

public class CartPage extends BasePage {
    private static final By IMG_PRODUCT = By.xpath("//img[@alt=\"Faded Short Sleeve T-shirts\"]");
    private static final By BUTTON_ADD_TO_CART = By.xpath("//span[contains(text(),\"Add to cart\")]");
    private static final By BUTTON_PROCEED = By.xpath("//span[contains(text(),\"Proceed to checkout\")]");
    private static final By PRODUCT = By.xpath("//*[text()=\"Faded Short Sleeve T-shirts\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public void addProductToCard() {
            Actions actions = new Actions(driver);
            actions.moveToElement(driver.findElement(IMG_PRODUCT)).build().perform();
            driver.findElement(BUTTON_ADD_TO_CART).click();
            driver.findElement(BUTTON_PROCEED).click();
    }

    public String product (){
        return driver.findElement(PRODUCT).getText();
    }
}