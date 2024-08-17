package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import ui.pages.DuolingoMainPage;
import ui.pages.DuolingoRegisterPage;

@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoRegisterPageTests extends TestBase {

    DuolingoMainPage duolingoMainPage = new DuolingoMainPage();
    DuolingoRegisterPage duolingoRegisterPage = new DuolingoRegisterPage();

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
                .selectLanguage()
                .selectSourceOfKnowledge()
                .selectPurposeOfLearning()
                .selectLanguageLevel()
                .selectDailyLearningGoal()
                .clickOnNotificationsButton()
                .selectPathToStartLearning()
                .checkLessonPageHasCorrectUrl();
    }
}
