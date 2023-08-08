package pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class LoginPage {

    private final SelenideElement cookiesModal = $("header.modal-header"),
            allowCookiesButton = $("button#btn-cookie-allow"),
            choiceCheckbox = $("div.choice"),
            emailInput = $("input#email"),
            passwordInput = $("input#pass"),
            loginButton = $("button.login"),
            errorMessage = $x("//div[@data-bind='html: message.text']"),
            userIcon = $("i.custom-icon-user"),
            disconnectLink = $x("//a[text()='Disconnect']"),
            signOutPageTitleH1 = $("h1.page-title");


    @Step("Open Login page")
    public static LoginPage openLoginPage() {
        open("/customer/account/login");
        return new LoginPage();
    }

    @Step("Accept cookies")
    public LoginPage acceptCookies() {
        cookiesModal.should(appear);
        allowCookiesButton.click();

        return this;
    }

    @Step("Enter login and password")
    public LoginPage successfulLogin(String email, String password) {
        choiceCheckbox.should(appear, Duration.ofSeconds(5));
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
        return this;
    }

    @Step("Log out")
    public void logOut(String signOutPageTitle) {
        userIcon.hover();
        disconnectLink.click();
        signOutPageTitleH1.should(appear)
                          .shouldHave(text(signOutPageTitle));
    }

    @Step("Check message about unsuccessful login")
    public void checkMessageUnsuccessfulLogin(String messageUnsuccessfulLogin) {
        errorMessage.shouldHave(text(messageUnsuccessfulLogin));
    }
}
