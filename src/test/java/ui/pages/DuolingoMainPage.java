package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class DuolingoMainPage {

    private final SelenideElement
            greetingTitle = $(".L93Ok"),
            careersButton = $("a[href='https://careers.duolingo.com']"),
            contactsButton = $("a[href='/contact']"),
            storeButton = $("a[href='https://store.duolingo.com/']"),
            startButton = $("[data-test=get-started-top]");

    @Step("Open main page")
    public DuolingoMainPage openMainPage() {
        open("https://duolingo.com/");
        return this;
    }

    @Step("Check greeting is displayed correctly in appropriate language")
    public DuolingoMainPage checkGreeting(String greeting) {
        greetingTitle.shouldHave(text(greeting));
        return this;
    }

    @Step("Go to careers page")
    public DuolingoMainPage goToCareersPage() {
        careersButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Go to contact page")
    public DuolingoMainPage goToContactPage() {
        contactsButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Go to store page")
    public DuolingoMainPage goToStorePage() {
        storeButton.scrollIntoView(true).click();
        return this;
    }

    @Step("Go to register page")
    public DuolingoMainPage goToRegisterPage() {
        startButton.click();
        return this;
    }
}

