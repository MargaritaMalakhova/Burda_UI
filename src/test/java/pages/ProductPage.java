package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public class ProductPage {
    SelenideElement addToCartButton = $x("//button[@title='Add to Cart']"),
                    succesAddToCartMessage = $x("//div[@data-bind='html: message.text']"),
                    toCartLink = $x("//a[text()='cart']");

    public ProductPage addProductToCart() {
        addToCartButton.should(Condition.appear).click();

        return this;
    }
    public ProductPage moveToCart() {
        succesAddToCartMessage.should(Condition.appear);
        toCartLink.click();

        return this;
    }

}
