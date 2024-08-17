package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoRegisterPage {

    int timeOutLimit = 10;

    private final SelenideElement
            languageCard = $("button [data-test]"),
            continueButton = $("[data-test=funboarding-continue-button]"),
            radioChoice = $("[role=radio]"),
            purposeChoice = $("[data-test=work]"),
            levelChoice = $("[data-test=prior-proficiency-card]"),
            allowButton = $("[data-test=daily-reminder] button");

    @Step("Open register page")
    public DuolingoRegisterPage openRegisterPage() {
        open("https://www.duolingo.com/register");
        return this;
    }

    @Step("Check register page has correct url")
    public DuolingoRegisterPage checkRegisterPageHasCorrectUrl() {
        String registerPageUrl = "https://www.duolingo.com/register";
        webdriver().shouldHave(currentFrameUrl(registerPageUrl));
        return this;
    }

    @Step("Check lesson page has correct url")
    public DuolingoRegisterPage checkLessonPageHasCorrectUrl() {
        String lessonPageUrl = "https://www.duolingo.com/lesson";
        webdriver().shouldHave(currentFrameUrl(lessonPageUrl));
        return this;
    }

    @Step("Select language to learn")
    public DuolingoRegisterPage selectLanguage() {
        languageCard.click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select source of knowledge")
    public DuolingoRegisterPage selectSourceOfKnowledge() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select purpose of learning")
    public DuolingoRegisterPage selectPurposeOfLearning() {
        purposeChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select language level")
    public DuolingoRegisterPage selectLanguageLevel() {
        levelChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select daily learning goal")
    public DuolingoRegisterPage selectDailyLearningGoal() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Click on notifications button")
    public DuolingoRegisterPage clickOnNotificationsButton() {
        allowButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select path to start learning")
    public DuolingoRegisterPage selectPathToStartLearning() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }
}
