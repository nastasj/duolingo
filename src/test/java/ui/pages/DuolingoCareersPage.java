package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selectors.byTagAndText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoCareersPage {

    private final SelenideElement
            careersTitle = $(byTagAndText("h1", "work at duolingo")),
            typeSelect = $(byTagAndText("option", "All types")),
            departmentSelect = $(byTagAndText("option", "All departments")),
            locationSelect = $(byTagAndText("option", "All locations"));

    @Step("Open careers page")
    public DuolingoCareersPage openCareersPage() {
        open("https://careers.duolingo.com/");
        return this;
    }

    @Step("Check careers page has correct url")
    public DuolingoCareersPage checkCareersPageHasCorrectUrl() {
        String careersPageUrl = "https://careers.duolingo.com/";
        webdriver().shouldHave(currentFrameUrl(careersPageUrl));
        return this;
    }

    @Step("Check title exists on the careers page")
    public DuolingoCareersPage checkCareersTitleExists() {
        careersTitle.should(exist);
        return this;
    }

    @Step("Check drop-down lists are clickable")
    public DuolingoCareersPage checkDropdownListsAreClickable() {
        typeSelect.shouldBe(clickable);
        departmentSelect.shouldBe(clickable);
        locationSelect.shouldBe(clickable);
        return this;
    }

}
