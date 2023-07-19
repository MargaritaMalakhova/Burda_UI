package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.*;
import utils.RandomUtils;

import java.util.Map;

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

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));

        Configuration.browserCapabilities = capabilities;
        Configuration.pageLoadStrategy =  "eager";
        Configuration.remote = System.getProperty("remote");
        Configuration.baseUrl = System.getProperty("baseUrl");
        Configuration.browserSize = System.getProperty("browserSize");
        String[] browser = System.getProperty("browser").split(":");
        Configuration.browser = browser[0];
        Configuration.browserVersion = browser[1];
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
