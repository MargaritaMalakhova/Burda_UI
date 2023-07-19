package pages;

import com.codeborne.selenide.SelenideElement;
import tests.WebTests;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SewingPatternsPage {
    SelenideElement productNameForAddToCartLink = $x(("//a[contains(text(), '"+ WebTests.PRODUCT_NAME_TO_BUY +"')]"));

    public SewingPatternsPage clickOnProduct() {
        productNameForAddToCartLink.click();

        return this;
    }
}
