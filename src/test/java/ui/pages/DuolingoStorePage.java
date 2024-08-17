package ui.pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.clickable;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.currentFrameUrl;

public class DuolingoStorePage {

    private final SelenideElement
            searchButton = $(".nav-item [aria-label=Search]"),
            cartButton = $(".nav-item .cart-icon");

    @Step("Open store page")
    public DuolingoStorePage openStorePage() {
        open("https://store.duolingo.com/");
        return this;
    }

    @Step("Check store page has correct url")
    public DuolingoStorePage checkStorePageHasCorrectUrl() {
        String storePageUrl = "https://store.duolingo.com/";
        webdriver().shouldHave(currentFrameUrl(storePageUrl));
        return this;
    }

    @Step("Check search button is clickable on the store page")
    public DuolingoStorePage checkSearchButtonIsClickable() {
        searchButton.shouldBe(clickable);
        return this;
    }

    @Step("Check cart button is clickable on the store page")
    public DuolingoStorePage checkCartButtonIsClickable() {
        cartButton.shouldBe(clickable);
        return this;
    }
}
