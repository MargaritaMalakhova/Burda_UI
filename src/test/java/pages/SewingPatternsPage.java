package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataBase;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$x;

public class SewingPatternsPage {
    SelenideElement sewingPatternsLink = $x("//a[@title='Sewing patterns']"),
            freeSewingPatternsLink = $x("//a[@title='Free sewing patterns']"),
            productNameForAddToCartLink = $x(("//a[contains(text(), '"+ DataBase.PRODUCT_NAME_FOR_ADD_TO_CART +"')]"));
    @Step("Open Page with Free Patterns")
    public SewingPatternsPage openFreeSewingPatternsPage() {
        sewingPatternsLink.hover();
        freeSewingPatternsLink.should(Condition.appear).click();
        return this;
    }
    @Step("Open Product Page")
    public SewingPatternsPage openProductPage() {
        productNameForAddToCartLink.click();

        return this;
    }
}
