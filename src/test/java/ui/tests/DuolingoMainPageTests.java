package ui.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import ui.pages.DuolingoMainPage;

import static com.codeborne.selenide.Selenide.open;

@Tag("duolingo")
@Tag("ui")
@Owner("Anastasia Antoshkina")
public class DuolingoMainPageTests extends TestBase {

    DuolingoMainPage duolingoPage = new DuolingoMainPage();

    @Tag("regress")
    @CsvSource(value = {
            "https://fr.duolingo.com/ | La méthode gratuite, fun et efficace pour apprendre une langue !",
            "https://it.duolingo.com/ | Il metodo gratuito, efficace e divertente per imparare le lingue!",
            "https://en.duolingo.com/ | The free, fun, and effective way to learn a language!",
            "https://de.duolingo.com/ | Effektiv und kostenlos eine Sprache lernen – und dabei Spaß haben!",
    }, delimiter = '|')
    @ParameterizedTest(name = "When opening site {0} welcome message {1} should be displayed")
    void checkDisplayCorrectGreeting(String url, String greeting) {
        open(url);
        duolingoPage.checkGreeting(greeting);
    }


}
