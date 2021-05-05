package tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Product add to cart with HomePage and " +
            "checks the availability of this product in cart")
    public void CheckingAddProductToCartTest() {
        loginPage.openHomePage();
        loginPage.clickSignInElement();
        loginPage.login("gost@tut.com", "789qwe456asd");
        driver.findElement(By.className("icon-home")).click();
        cartPage.addProductToCard();
        Assert.assertEquals(cartPage.product(), "Faded Short Sleeve T-shirts", "Product was not added in cart or " +
                "was added another product");
        accountFormPage.setLogout();
    }

    @Test(retryAnalyzer = Retry.class, description = "Checking payment for the product byBank Wire")
    public void CheckingPaymentForProductByBankWireTest() {
        loginPage.openHomePage();
        loginPage.clickSignInElement();
        loginPage.login("shier@gmail.com", "2R8bYmdQPz3J!!J");
        driver.findElement(By.className("icon-home")).click();
        cartPage.addProductToCard();
        cartPage.clickProceedToCheckout();
        cartPage.typeOfPaymentBankWire();
        Assert.assertEquals(cartPage.orderIsComplete(), "Your order on My Store is complete.",
                "payment for the product by Bank Wire is not complete");
    }
}