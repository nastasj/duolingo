package ui.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:ui:${env}.properties"
})
public interface WebDriverConfig extends Config {

    @DefaultValue("chrome")
    String browser();

    @DefaultValue("126.0")
    String browserVersion();

    @DefaultValue("1920x1080")
    String browserSize();

    @DefaultValue("https://www.duolingo.com")
    String baseUrl();

    @DefaultValue("false")
    boolean isRemote();

    String remoteUrl();
}
