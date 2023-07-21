package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static data.DataBase.*;
import static pages.LoginPage.openLoginPage;

public class LoginTest extends TestBase {
    @Tag("login")
    @Test
    @DisplayName("Positive Login test")
    void positiveLoggin() {

        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
        profilePage.verifyUserInformation(userProfileInformation);
        loginPage.logOut(signOutPageTitle);
    }

    @Test
    @DisplayName("Negative Login test")
    void negativeLoggin() {

        openLoginPage()
                .acceptCookies()
                .unsuccessfulLogin(email, wrongPassword)
                .checkMessageUnsuccessfulLogin(messageUnsuccessfulLogin);
    }
}
