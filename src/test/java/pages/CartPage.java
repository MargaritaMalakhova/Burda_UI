package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CartPage {

    SelenideElement deleteItemInCartButton = $("a.action-delete"),
                    cartContainer = $x("div.cart-container"),
                    checkoutButton = $("button.checkout");

    public void deleteItemInCart() {
        deleteItemInCartButton.click();
    }

    public CartPage checkProductInCart(String productItemNameToBuy) {
        cartContainer.shouldHave(Condition.text(productItemNameToBuy));

        return this;
    }

    public CartPage clickOnCheckout() {
        checkoutButton.click();

        return this;
    }
}
