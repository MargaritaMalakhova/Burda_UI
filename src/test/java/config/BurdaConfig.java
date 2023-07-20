package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"system:properties", "classpath:test.properties"})
public interface BurdaConfig extends Config {

    @Key("browserName")
    @DefaultValue("chrome")
    String getBrowserName();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String getBrowserVersion();

    @Key("baseUrl")
    @DefaultValue("https://www.burdastyle.com")
    String getBaseUrl();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String getBrowserSize();

    @Key("isRemote")
    @DefaultValue("false")
    Boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud")
    String getRemoteUrl();

    @Key("pageLoadTimeout")
    @DefaultValue("10000")
    Long getPageLoadTimeout();

    @Key("timeout")
    @DefaultValue("10000")
    Long getTimeout();

    @Key("pageLoadStrategy")
    String getPageLoadStrategy();

}