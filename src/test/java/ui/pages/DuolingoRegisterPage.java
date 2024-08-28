package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoRegisterPage {

    private final SelenideElement
            languageCard = $("button[data-test]"),
            continueButton = $("[data-test=funboarding-continue-button]");
    int timeOutLimit = 10;

    @Step("Open register page")
    public DuolingoRegisterPage openRegisterPage() {
        open("/register");
        return this;
    }

    @Step("Check register page has correct url")
    public DuolingoRegisterPage checkRegisterPageHasCorrectUrl() {
        String registerPageUrl = "https://www.duolingo.com/register";
        webdriver().shouldHave(currentFrameUrl(registerPageUrl));
        return this;
    }

    @Step("Select language to learn")
    public DuolingoRegisterPage selectLanguage() {
        languageCard.click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }
}
