package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.*;
import utils.RandomUtils;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    LoginPage loginPage = new LoginPage();
    ProfilePage profilePage = new ProfilePage();
    DownloadableProductsPage downloadableProductsPage = new DownloadableProductsPage();
    RandomUtils randomUtils = new RandomUtils();
    CartPage cartPage = new CartPage();
    SewingPatternsPage sewingPatternsPage = new SewingPatternsPage();
    ProductPage productPage = new ProductPage();

    @BeforeAll
    static void beforeAll() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = "https://www.burdastyle.com/customer/account/login";
        Configuration.browserSize = "1920x1080";
    }
    @BeforeEach
     void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
    }

    void closeDriver() {
        closeWebDriver();
    }
}
