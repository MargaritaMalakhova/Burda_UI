package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.CartPage;
import pages.CheckOutPage;
import pages.ProductPage;
import pages.SewingPatternsPage;

import static com.codeborne.selenide.Selenide.$;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User adds products to cart and buys them")
public class CartTest extends TestBase {
    CartPage cartPage = new CartPage();
    SewingPatternsPage sewingPatternsPage = new SewingPatternsPage();
    ProductPage productPage = new ProductPage();
    CheckOutPage checkOutPage = new CheckOutPage();
    String PRODUCT_NAME_FOR_ADD_TO_CART = "Cotton Hair Wrap 134 | Burda Style 07/23";


    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), credsConfig.getPassword());
    }

    @BeforeEach
    public void checkCart() {
        cartPage.openCart();
        while ($("a.action-delete").isDisplayed()) {

            cartPage.removeProductInCart();
        }
    }

    @Test
    @DisplayName("Add pattern to cart test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void addToCartTest() {
        sewingPatternsPage
                .openFreePatternsPage();
        sewingPatternsPage
                .openProductPage(PRODUCT_NAME_FOR_ADD_TO_CART);
        productPage
                .addProductToCart();
        cartPage
                .openCart()
                .checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART)
                .removeProductInCart();
    }

    @Test
    @DisplayName("Buy pattern test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void buyPatternTest() {
        sewingPatternsPage
                .openFreePatternsPage();
        sewingPatternsPage
                .openProductPage(PRODUCT_NAME_FOR_ADD_TO_CART);
        productPage
                .addProductToCart();
        cartPage
                .openCart()
                .checkProductInCart(PRODUCT_NAME_FOR_ADD_TO_CART)
                .clickOnCheckout();
        checkOutPage
                .chooseAgreement()
                .clickOnPlaceOrder();
    }
}
