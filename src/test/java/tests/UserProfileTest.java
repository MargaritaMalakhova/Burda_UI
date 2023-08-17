package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MyAccountPage;

import static helpers.RandomUtils.createRandomFirstName;
import static helpers.RandomUtils.createRandomLastName;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User changes profile")
public class UserProfileTest extends TestBase {
    MyAccountPage myAccountPage = new MyAccountPage();
    String randomUserFirstName = createRandomFirstName();
    String randomUserLastName = createRandomLastName();
    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), credsConfig.getPassword());
    }

    @Test
    @DisplayName("Change user profile test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void changeUserProfile() {
        myAccountPage
                .verifyUserInformation(credsConfig.getUserFirstName() + " "
                                        + credsConfig.getUserLastName() + "\n"
                                        + credsConfig.getEmail())
                .changeUserName(randomUserFirstName, randomUserLastName)
                .verifyUserInformation(randomUserFirstName + " "
                                        + randomUserLastName + "\n"
                                        + credsConfig.getEmail())
                .changeBackUserName(credsConfig.getUserFirstName(), credsConfig.getUserLastName());
    }
}
