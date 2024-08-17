package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.DuolingoMainPage;
import ui.pages.DuolingoStorePage;

@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoStorePageTests extends TestBase {

    DuolingoMainPage duolingoMainPage = new DuolingoMainPage();
    DuolingoStorePage duolingoStorePage = new DuolingoStorePage();

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check store page has correct url")
    public void checkStorePageHasCorrectUrlTest() {
        duolingoMainPage
                .openMainPage()
                .goToStorePage();
        duolingoStorePage
                .checkStorePageHasCorrectUrl();
    }

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check search button is clickable on store page")
    public void checkSearchButtonIsClickableTest() {
        duolingoStorePage
                .openStorePage()
                .checkSearchButtonIsClickable();
    }

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check cart button is clickable on store page")
    public void checkCartButtonIsClickableTest() {
        duolingoStorePage
                .openStorePage()
                .checkCartButtonIsClickable();
    }
}
