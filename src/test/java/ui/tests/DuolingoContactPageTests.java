package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.DuolingoContactPage;
import ui.pages.DuolingoMainPage;

@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoContactPageTests extends TestBase {

    DuolingoMainPage duolingoMainPage = new DuolingoMainPage();
    DuolingoContactPage duolingoContactPage = new DuolingoContactPage();

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check contact page has correct url")
    public void checkContactPageHasCorrectUrlTest() {
        duolingoMainPage
                .openMainPage()
                .goToContactPage();
        duolingoContactPage
                .checkContactPageHasCorrectUrl();
    }

    @Test
    @Tag("regress")
    @DisplayName("Check help button is clickable")
    public void checkHelpButtonIsClickableTest() {
        duolingoContactPage
                .openContactPage()
                .checkHelpButtonIsClickable();
    }

    @Test
    @Tag("regress")
    @DisplayName("Check contact emails are correct")
    public void checkContactEmailsAreCorrectTest() {
        duolingoContactPage
                .openContactPage()
                .checkContactEmailsAreCorrect();
    }
}
