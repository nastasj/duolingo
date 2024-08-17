package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoContactPage {

    private final SelenideElement
            helpButton = $("a[href='/help']"),
            pressButton = $("a[href='mailto:press@duolingo.com']"),
            partnershipsButton = $("a[href='mailto:partnerships@duolingo.com']");

    @Step("Open contact page")
    public DuolingoContactPage openContactPage() {
        open("https://www.duolingo.com/contact");
        return this;
    }

    @Step("Check contact page has correct url")
    public DuolingoContactPage checkContactPageHasCorrectUrl() {
        String contactPageUrl = "https://www.duolingo.com/contact";
        webdriver().shouldHave(currentFrameUrl(contactPageUrl));
        return this;
    }

    @Step("Check help button is clickable")
    public DuolingoContactPage checkHelpButtonIsClickable() {
        helpButton.shouldBe(clickable);
        return this;
    }

    @Step("Check contact emails are correct")
    public DuolingoContactPage checkContactEmailsAreCorrect() {
        pressButton.shouldHave(text("press@duolingo.com"));
        partnershipsButton.shouldHave(text("partnerships@duolingo.com"));
        return this;
    }
}
