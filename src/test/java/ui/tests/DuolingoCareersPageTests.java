package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.DuolingoCareersPage;
import ui.pages.DuolingoMainPage;

@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoCareersPageTests extends TestBase {

    DuolingoMainPage duolingoMainPage = new DuolingoMainPage();
    DuolingoCareersPage duolingoCareersPage = new DuolingoCareersPage();

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check careers page has correct url")
    public void checkCareersPageHasCorrectUrlTest() {
        duolingoMainPage
                .openMainPage()
                .goToCareersPage();
        duolingoCareersPage
                .checkCareersPageHasCorrectUrl();
    }

    @Test
    @Tag("regress")
    @DisplayName("Check title exists on the careers page")
    public void checkCareersTitleExistsTest() {
        duolingoCareersPage
                .openCareersPage()
                .checkCareersTitleExists();
    }

    @Test
    @Tag("regress")
    @DisplayName("Check drop-down lists are clickable")
    public void checkDropdownListsAreClickableTest() {
        duolingoCareersPage
                .openCareersPage()
                .checkDropdownListsAreClickable();
    }
}
