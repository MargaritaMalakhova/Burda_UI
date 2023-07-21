package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    SelenideElement addToCartButton = $x("//button[@title='Add to Cart']"),
                    successAddToCartMessage = $x("//div[@data-bind='html: message.text']"),
                    toCartLink = $x("//a[text()='cart']");
    @Step("Add Product to Cart")
    public ProductPage addProductToCart() {
        addToCartButton.should(Condition.appear).click();

        return this;
    }
    @Step("Open Cart")
    public ProductPage moveToCart() {
        successAddToCartMessage.should(Condition.appear);
        toCartLink.click();

        return this;
    }

}
