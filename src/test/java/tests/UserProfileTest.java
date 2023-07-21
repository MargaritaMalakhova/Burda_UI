package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static data.DataBase.*;
import static pages.LoginPage.openLoginPage;

public class UserProfileTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
    }

    @Test
    @DisplayName("Change user profile test")
    void changeUserProfile() {
        open("https://www.burdastyle.com/customer/account/login");

        profilePage
                .verifyUserInformation(userProfileInformation)
                .changeUserName(randomUserFirstName, randomUserLastName)
                .verifyUserInformation(randomUserFirstName + " " + randomUserLastName+ "\n" + email)
                .changeBackUserName(userFirstName, userLastName);
    }
}
