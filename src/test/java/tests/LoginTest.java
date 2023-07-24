package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.DataBase.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User authentication")
public class LoginTest extends TestBase {

    @Test
    @DisplayName("Positive Login test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void positiveLoggin() {

        openLoginPage().acceptCookies().successfulLogin(email, password);
        profilePage.verifyUserInformation(userProfileInformation);
        loginPage.logOut(signOutPageTitle);
    }

    @Test
    @DisplayName("Negative Login test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void negativeLoggin() {

        openLoginPage().acceptCookies().unsuccessfulLogin(email, wrongPassword).checkMessageUnsuccessfulLogin(messageUnsuccessfulLogin);
    }
}
