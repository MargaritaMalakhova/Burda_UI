package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.DataBase.*;
import static pages.LoginPage.openLoginPage;

public class CartTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
    }

    @Test
    @DisplayName("Add pattern to cart test")
    void addToCartTest() {
        sewingPatternsPage
                .openFreeSewingPatternsPage()
                .openProductPage();
        productPage
                .addProductToCart()
                .moveToCart();
        cartPage
                .checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART)
                .removeProductInCart();
    }

    @Test
    @DisplayName("Buy pattern test")
    void buyPatternTest() {
        sewingPatternsPage
                .openFreeSewingPatternsPage()
                .openProductPage();
        productPage
                .addProductToCart()
                .moveToCart();
        cartPage
                .checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART)
                .clickOnCheckout();
        checkOutPage
                .chooseAgreement()
                .clickOnPlaceOrder();
    }
}
