package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;

public class WishListPage {

    private final SelenideElement deleteItemInWishListButton = $("a.btn-remove"),
            wishListContainer = $("div.wishlist");

    @Step("Check added Product in Wish List")
    public WishListPage checkProductInWithList(String productForAddingToWishList) {
        wishListContainer.shouldHave(Condition.text(productForAddingToWishList));
        return this;
    }

    @Step("Delete Product from Wish List")
    public void removeProductInWishList() {
        deleteItemInWishListButton.click();
    }
}
