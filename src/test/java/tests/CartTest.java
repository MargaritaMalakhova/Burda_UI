package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.TestData.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User adds products to cart and buys them")
public class CartTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage().acceptCookies().successfulLogin(email, password);
    }

    @Test
    @DisplayName("Add pattern to cart test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void addToCartTest() {
        sewingPatternsPage.openSewingPatternsPage(FreePatternsPage).openProductPage(PRODUCT_NAME_FOR_ADD_TO_CART);
        productPage.addProductToCart().moveToCart();
        cartPage.checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART).removeProductInCart();
    }

    @Test
    @DisplayName("Buy pattern test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void buyPatternTest() {
        sewingPatternsPage.openSewingPatternsPage(FreePatternsPage).openProductPage(PRODUCT_NAME_FOR_ADD_TO_CART);
        productPage.addProductToCart().moveToCart();
        cartPage.checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART).clickOnCheckout();
        checkOutPage.chooseAgreement().clickOnPlaceOrder();
    }
}
