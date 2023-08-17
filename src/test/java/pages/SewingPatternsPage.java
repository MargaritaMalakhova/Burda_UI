package pages;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class SewingPatternsPage {

    @Step("Open Page with Free Patterns")
    public void openFreePatternsPage() {
        open("/sewing-patterns/free-sewing-patterns.html");
    }

    @Step("Open Page with Skirts Patterns")
    public void openSkirtsPatternsPage() {
        open("/sewing-patterns/women/skirts.html");
    }

    @Step("Open Product Page")
    public void openProductPage(String nameOfProduct) {
        $(byText(nameOfProduct)).should(appear).click();
    }
}
