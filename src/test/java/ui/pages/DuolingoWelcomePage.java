package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoWelcomePage {

    private final SelenideElement
            continueButton = $("[data-test=funboarding-continue-button]"),
            radioChoice = $("[role=radio]"),
            purposeChoice = $("[data-test=work]"),
            levelChoice = $("[data-test=prior-proficiency-card]"),
            allowButton = $("[data-test=daily-reminder] button");
    int timeOutLimit = 10;

    @Step("Check lesson page has correct url")
    public DuolingoWelcomePage checkLessonPageHasCorrectUrl() {
        String lessonPageUrl = baseUrl + "/lesson";
        webdriver().shouldHave(currentFrameUrl(lessonPageUrl));
        return this;
    }

    @Step("Select source of knowledge")
    public DuolingoWelcomePage selectSourceOfKnowledge() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select purpose of learning")
    public DuolingoWelcomePage selectPurposeOfLearning() {
        purposeChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select language level")
    public DuolingoWelcomePage selectLanguageLevel() {
        levelChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select daily learning goal")
    public DuolingoWelcomePage selectDailyLearningGoal() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Click on notifications button")
    public DuolingoWelcomePage clickOnNotificationsButton() {
        allowButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }

    @Step("Select path to start learning")
    public DuolingoWelcomePage selectPathToStartLearning() {
        radioChoice.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        continueButton.shouldBe(clickable, Duration.ofSeconds(timeOutLimit)).click();
        return this;
    }
}