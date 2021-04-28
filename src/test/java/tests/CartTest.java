package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test(retryAnalyzer = Retry.class, description = "Product add to cart with HomePage and " +
            "checks the availability of this product in cart")
    public void shouldBeAddProductToCart() {
            loginPage.openHomePage();
            cartPage.addProductToCard();
            Assert.assertEquals(cartPage.product(), "Faded Short Sleeve T-shirts", "Product was not added in cart or " +
                    "was added another product");
    }
}
