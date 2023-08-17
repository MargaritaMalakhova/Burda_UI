package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CartPage {

    private final SelenideElement deleteItemInCartButton = $("a.action-delete"),
            cartContainer = $("form#form-validate"),
            checkoutButton = $("button.checkout");

    @Step("Open Cart")
    public CartPage openCart() {
        open("/checkout/cart/");
        return this;
    }

    @Step("Check added Product in Cart")
    public CartPage checkProductInCart(String productForAddingToCart) {
        cartContainer.shouldHave(Condition.text(productForAddingToCart));
        return this;
    }

    @Step("Delete Product in Cart")
    public void removeProductInCart() {

        deleteItemInCartButton.click();
    }

    @Step("Click on Check Out")
    public CartPage clickOnCheckout() {
        checkoutButton.click();

        return this;
    }
}
