package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    private final SelenideElement addToCartButton = $x("//button[@title='Add to Cart']"),
            successAddToCartMessage = $x("//div[@data-bind='html: message.text']"),
            toWishListIcon = $("div.product-addto-links"),
            toWishListIconNav = $("i.custom-icon-favorite"),
            toWishListLink = $x("//a[text()='To my wishlist']"),
            wishListCounter = $("span.ept-counter");


    @Step("Add Product to Cart")
    public ProductPage addProductToCart() {
        addToCartButton.should(Condition.appear).click();
        successAddToCartMessage.should(Condition.appear);
        return this;
    }

     @Step("Add to Wish List")
    public ProductPage addProductToWishList() {
        toWishListIcon.click();
        return this;
    }
     @Step("Move To Wish List")
    public ProductPage moveToWishList() {
        wishListCounter.should(Condition.appear);
        toWishListIconNav.click();
        toWishListLink.should(Condition.appear)
                      .click();
        return this;
    }


}
