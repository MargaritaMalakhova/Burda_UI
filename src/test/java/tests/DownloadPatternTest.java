package tests;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.DataBase.*;
import static pages.LoginPage.openLoginPage;

public class DownloadPatternTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
    }

    @Test
    @DisplayName("DownLoad PDF test")
    void positiveDownloadFile() throws Exception {
        downloadableProductsPage
                .openDownloadableProductsPage()
                .downloadPattern()
                .checkPDF(textForCheckInPDF);
    }
}
