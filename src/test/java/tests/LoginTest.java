package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.LoginPage;
import pages.MyAccountPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User authentication")
public class LoginTest extends TestBase {
    LoginPage loginPage = new LoginPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    String messageUnsuccessfulLogin = "The account sign-in was incorrect or your account is disabled " +
                                                     "temporarily. Please wait and try again later.";
    String signOutPageTitle = "You are signed out";


    @Test
    @DisplayName("Positive Login test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void positiveLoggin() {

        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), credsConfig.getPassword());
        myAccountPage
                .verifyUserInformation(credsConfig.getUserFirstName() + " "
                        + credsConfig.getUserLastName() + "\n"
                        + credsConfig.getEmail());
        loginPage.logOut(signOutPageTitle);
    }

    @Test
    @DisplayName("Negative Login test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void negativeLoggin() {

        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), "1234");
        loginPage
                .checkMessageUnsuccessfulLogin(messageUnsuccessfulLogin);
    }
}
