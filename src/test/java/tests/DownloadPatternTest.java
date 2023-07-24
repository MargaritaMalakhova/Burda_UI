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

@Story("User downloads pattern file")
public class DownloadPatternTest extends TestBase {

    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .successfulLogin(email, password);
    }

    @Test
    @DisplayName("DownLoad PDF test")
    @Owner("m.malakhova")
    @Severity(BLOCKER)
    void positiveDownloadFile() throws Exception {
        downloadableProductsPage
                .openDownloadableProductsPage()
                .downloadPattern()
                .checkPDF(textForCheckInPDF);
    }
}
