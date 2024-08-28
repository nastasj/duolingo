package ui.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import ui.config.ProjectConfiguration;
import ui.helpers.Attach;

import java.util.Map;

public class TestBase {

    @BeforeAll
    static void beforeAll() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration();
        projectConfiguration.webDriverConfig();

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        Configuration.browserCapabilities = capabilities;
    }

    @BeforeEach
    void beforeEach() {
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @AfterEach
    void afterEach() {
        ProjectConfiguration projectConfiguration = new ProjectConfiguration();
        projectConfiguration.webDriverConfig();

        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        if (!projectConfiguration.webDriverConfig.browser().equals("firefox")) {
            Attach.browserConsoleLogs();
        }
        Attach.browserConsoleLogs();
        if (projectConfiguration.webDriverConfig.isRemote()) {
            Attach.addVideo();
        }
        Selenide.closeWebDriver();
    }
}