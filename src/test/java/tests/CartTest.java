package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.BaseTest;
import utils.Retry;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Product add to cart with HomePage and " +
            "checks the availability of this product in cart")
    public void checkingAddProductToCartTest() {
        loginPage.openHomePage();
        loginPage.clickSignInButton();
        loginPage.inputEmailAndPasswordAndClickSingIn("gost@tut.com", "789qwe456asd");
        cartPage.goToHomePage();
        cartPage.addProductToCart();
        Assert.assertEquals(cartPage.getProductName(), "Faded Short Sleeve T-shirts", "Product was not added in cart or " +
                "was added another product");
        accountFormPage.logout();
    }

    @Test(retryAnalyzer = Retry.class, description = "Checking payment for the product byBank Wire")
    public void checkingPaymentForProductByBankWireTest() {
        loginPage.openHomePage();
        loginPage.clickSignInButton();
        loginPage.inputEmailAndPasswordAndClickSingIn("shier@gmail.com", "2R8bYmdQPz3J!!J");
        driver.findElement(By.className("icon-home")).click();
        cartPage.addProductToCart();
        cartPage.clickProceedToCheckout();
        cartPage.chooseTypeOfPaymentBankWireAndConfirmOrder();
        Assert.assertEquals(cartPage.getOrderIsCompleteOnPage(), "Your order on My Store is complete.",
                "payment for the product by Bank Wire is not complete");
    }
}