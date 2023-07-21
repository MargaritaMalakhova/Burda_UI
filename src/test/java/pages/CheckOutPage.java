package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class CheckOutPage {

    SelenideElement agreementCheckbox = $x("//*[@id=\"agreement_free_5\"]"),
                    PlaceOrderButton = $x("//button[@title='Place Order']");

    @Step("Choose agreement")
    public CheckOutPage chooseAgreement() {
        agreementCheckbox.click();
        return this;
    }
    @Step("Make Place Order")
    public void clickOnPlaceOrder() {

        PlaceOrderButton.click();
    }

}
