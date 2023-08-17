package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.ProductPage;
import pages.SewingPatternsPage;
import pages.WishListPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User adds products to wish list")
public class WishListTest extends TestBase {
    SewingPatternsPage sewingPatternsPage = new SewingPatternsPage();
    ProductPage productPage = new ProductPage();
    WishListPage wishListPage = new WishListPage();
    String PRODUCT_NAME_FOR_ADD_TO_WISH_LIST = "Jacquard Skirt 102 | Burda Style 08/23";
    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), credsConfig.getPassword());
    }

    @Test
    @DisplayName("Add pattern to wish list test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void addToWishListTest() {
        sewingPatternsPage
                .openSkirtsPatternsPage();
        sewingPatternsPage
                .openProductPage(PRODUCT_NAME_FOR_ADD_TO_WISH_LIST);
        productPage
                .addProductToWishList()
                .moveToWishList();
        wishListPage
                .checkProductInWithList(PRODUCT_NAME_FOR_ADD_TO_WISH_LIST)
                .removeProductInWishList();
    }
}
