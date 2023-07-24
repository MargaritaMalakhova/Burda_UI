package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.DataBase.*;
import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User changes profile")
public class UserProfileTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
    }

    @Test
    @DisplayName("Change user profile test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void changeUserProfile() {
        profilePage
                .verifyUserInformation(userProfileInformation)
                .changeUserName(randomUserFirstName, randomUserLastName)
                .verifyUserInformation(randomUserFirstName + " " + randomUserLastName + "\n" + email)
                .changeBackUserName(userFirstName, userLastName);
    }
}
