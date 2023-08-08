package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class SewingPatternsPage {
    private final SelenideElement sewingPatternsLink = $x("//a[@title='Sewing patterns']");

    @Step("Open Page with Free Patterns")
    public SewingPatternsPage openSewingPatternsPage(String nameOfPatternsPage) {
        sewingPatternsLink.hover();
        $(byText(nameOfPatternsPage)).should(appear).click();
        return this;
    }

    @Step("Open Product Page")
    public SewingPatternsPage openProductPage(String nameOfProduct) {
        $(byText(nameOfProduct)).should(appear).click();

        return this;
    }
}
