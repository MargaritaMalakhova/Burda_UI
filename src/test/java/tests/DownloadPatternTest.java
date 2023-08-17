package tests;

import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.DownloadableProductsPage;

import static io.qameta.allure.SeverityLevel.BLOCKER;
import static pages.LoginPage.openLoginPage;

@Story("User downloads pattern file")
public class DownloadPatternTest extends TestBase {
    DownloadableProductsPage downloadableProductsPage = new DownloadableProductsPage();
    String textForCheckInPDF = "instructions";
    @BeforeEach
    public void login() {
        openLoginPage()
                .acceptCookies()
                .login(credsConfig.getEmail(), credsConfig.getPassword());
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
