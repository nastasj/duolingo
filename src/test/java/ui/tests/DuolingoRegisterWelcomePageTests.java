package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.DuolingoMainPage;
import ui.pages.DuolingoRegisterPage;
import ui.pages.DuolingoWelcomePage;

@Tag("duolingo")
@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoRegisterWelcomePageTests extends TestBase {

    DuolingoMainPage duolingoMainPage = new DuolingoMainPage();
    DuolingoRegisterPage duolingoRegisterPage = new DuolingoRegisterPage();
    DuolingoWelcomePage duolingoWelcomePage = new DuolingoWelcomePage();

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check register page has correct url")
    public void checkRegisterPageHasCorrectUrlTest() {
        duolingoMainPage
                .openMainPage()
                .goToRegisterPage();
        duolingoRegisterPage
                .checkRegisterPageHasCorrectUrl();
    }

    @Test
    @Tag("smoke")
    @Tag("regress")
    @DisplayName("Check register feature")
    public void checkRegisterFeatureTest() {
        duolingoRegisterPage
                .openRegisterPage()
                .selectLanguage();
        duolingoWelcomePage
                .selectSourceOfKnowledge()
                .selectPurposeOfLearning()
                .selectLanguageLevel()
                .selectDailyLearningGoal()
                .clickOnNotificationsButton()
                .selectPathToStartLearning()
                .checkLessonPageHasCorrectUrl();
    }
}
