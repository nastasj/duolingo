package ui.config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class ProjectConfiguration {

    public final WebDriverConfig webDriverConfig =
            ConfigFactory.create(WebDriverConfig.class, System.getProperties());

    public void webDriverConfig() {
        Configuration.baseUrl = webDriverConfig.baseUrl();
        Configuration.browser = webDriverConfig.browser();
        Configuration.browserSize = webDriverConfig.browserSize();
        Configuration.pageLoadStrategy = "eager";

        if (webDriverConfig.isRemote()) {
            Configuration.browserVersion = webDriverConfig.browserVersion();
            Configuration.remote = webDriverConfig.remoteUrl();
        }
    }
}
