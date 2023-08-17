package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class WishListPage {

    private final SelenideElement deleteItemInWishListButton = $("a.btn-remove"),
            wishListContainer = $("div.product-item-inner"),

            okButton = $("button.action-primary");

    @Step("Check added Product in Wish List")
    public WishListPage checkProductInWithList(String productForAddingToWishList) {
        wishListContainer.shouldHave(text(productForAddingToWishList));
        return this;
    }

    @Step("Delete Product from Wish List")
    public void removeProductInWishList() {
        deleteItemInWishListButton.click();
        okButton.should(appear).click();
    }
}
