package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.BurdaConfig;
import config.CredentialsConfig;
import io.qameta.allure.selenide.AllureSelenide;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static helpers.Attach.*;

public class TestBase {
    CredentialsConfig credsConfig = ConfigFactory.create(CredentialsConfig.class, System.getProperties());

    @BeforeAll
    public static void setUp() {
        BurdaConfig config = ConfigFactory.create(BurdaConfig.class, System.getProperties());
        SelenideLogger.addListener("allure", new AllureSelenide());
        Configuration.baseUrl = config.getBaseUrl();
        Configuration.browser = config.getBrowserName();
        Configuration.browserVersion = config.getBrowserVersion();
        Configuration.browserSize = config.getBrowserSize();
        Configuration.pageLoadTimeout = config.getPageLoadTimeout();
        Configuration.timeout = config.getTimeout();
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
        screenshotAs("Last screenshot");
        pageSource();
        browserConsoleLogs();
        addVideo();

        closeWebDriver();
    }


}
