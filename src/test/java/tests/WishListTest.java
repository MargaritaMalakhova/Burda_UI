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

@Story("User adds products to wish list")
public class WishListTest extends TestBase {
    @BeforeEach
    public void login() {
        openLoginPage().acceptCookies().successfulLogin(email, password);
    }

    @Test
    @DisplayName("Add pattern to wish list test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void addToWishListTest() {
        sewingPatternsPage.openSewingPatternsPage(SkirtsPatternsPage).openProductPage(PRODUCT_NAME_FOR_ADD_TO_WISH_LIST);
        productPage.addProductToWishList().moveToWishList();
        wishListPage.checkProductInWithList(PRODUCT_NAME_FOR_ADD_TO_WISH_LIST)
                .removeProductInWishList();
    }
}
