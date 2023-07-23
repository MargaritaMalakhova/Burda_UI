package pages;

import com.codeborne.selenide.Selenide;
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
                    errorMessage = $x("//div[@data-bind='html: message.text']"),
                    userIcon = $("i.custom-icon-user"),
                    disconnectLink = $x("//a[text()='Disconnect']"),
                    signOutPageTitleh1 = $("h1.page-title");

    // Actions
    @Step("Open Login page")
    public static LoginPage openLoginPage() {
        open("/customer/account/login");
        $(".page-title ").shouldBe(visible);
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
        Selenide.sleep(5000);
        choiceCheckbox.should(appear);
        emailInput.setValue(email);
        passwordInput.setValue(password);
        loginButton.click();
        return new ProfilePage();
    }
    @Step("Log out")
    public void logOut(String signOutPageTitle) {
        userIcon.hover();
        disconnectLink.click();
        signOutPageTitleh1.should(appear).shouldHave(text(signOutPageTitle));
    }
    @Step("Enter login and incorrect password")
    public LoginPage unsuccessfulLogin(String email, String wrongPassword) {
        choiceCheckbox.should(appear);
        emailInput.setValue(email);
        passwordInput.setValue(wrongPassword);
        loginButton.click();
        return this;
    }

    @Step("Check message about unsuccessful login")
    public LoginPage checkMessageUnsuccessfulLogin(String messageUnsuccessfulLogin) {
        errorMessage.shouldHave(text(messageUnsuccessfulLogin));
        return this;
    }
}
