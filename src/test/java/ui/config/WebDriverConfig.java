package ui.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ui:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("126.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("baseUrl")
    @DefaultValue("https://www.duolingo.com/")
    String baseUrl();

    @Key("isRemote")
    @DefaultValue("true")
    boolean isRemote();

    @Key("remoteUrl")
    @DefaultValue("https://user1:1234@selenoid.autotests.cloud/wd/hub")
    String remoteUrl();
}
