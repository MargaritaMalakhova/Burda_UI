package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {
    // SelenideElements

    SelenideElement cookiesModal = $("header.modal-header"),
                    allowCookiesButton = $("button#btn-cookie-allow"),
                    choiceCheckbox = $("div.choice"),
                    emailInput = $("input#email"),
                    passwordInput = $("input#pass"),
                    loginButton = $("button.login"),
                    errorMessage = $x("//div[@data-bind='html: message.text']");

//    public LoginPage() {
//        $(".page-title").shouldBe(visible);
//    }

    // Actions
    @Step("Open Login page")
    public static LoginPage openLoginPage() {
        open("/customer/account/login");
        $(".page-title").shouldBe(visible);
        return new LoginPage();
    }
    @Step("Accept cookies")
    public LoginPage acceptCookies() {
        cookiesModal.should(appear);
        allowCookiesButton.click();

        return this;
    }
    @Step("Enter login and password")
    public ProfilePage successfulLogin(String email, String password) {
        choiceCheckbox.should(appear);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
        return new ProfilePage();
    }

    @Step("Enter login and incorrect password")
    public LoginPage unsuccessfulLogin(String email) {
        choiceCheckbox.should(appear);
        emailInput.setValue(email);
        passwordInput.setValue("password");
        loginButton.click();
        errorMessage.shouldHave(text("The account sign-in was incorrect or your account is disabled temporarily. " +
                        "Please wait and try again later."));
        return this;
    }

    @Step("Check message about unsuccessful login")
    public LoginPage checkMessageUnsuccessfulLogin() {
        errorMessage.shouldHave(text("The account sign-in was incorrect or your account is disabled temporarily. " +
                "Please wait and try again later."));
        return this;
    }
}
