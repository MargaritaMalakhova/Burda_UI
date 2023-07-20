package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BurdaConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
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
    public static BurdaConfig config;

    @BeforeAll
    public static void setUP() {
        config = ConfigFactory.create(BurdaConfig.class, System.getProperties());
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
//        Configuration.pageLoadTimeout = config.getPageLoadTimeout();
//        Configuration.timeout = config.getTimeout();
        Configuration.pageLoadStrategy = config.getPageLoadStrategy();

        if (config.isRemote()) {
            Configuration.remote = config.getRemoteUrl() + "/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }

    }
    @BeforeEach
     void addListener() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    public void addAttachmentsAndClose() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();

        if(config.isRemote()) {
            Attach.addVideo();
        }

        closeWebDriver();
    }


}
