package api.tests;

import api.config.ApiConfig;
import api.config.AuthConfig;
import api.models.DarkModeRequestModel;
import api.models.DarkModeResponseModel;
import api.models.EmailReminderRequestResponseModel;
import api.steps.SettingsSteps;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static api.specs.DuolingoSpecs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;


@Tag("api")
@Tag("settings")
@Owner("Antoshkina Anastasia")
public class SettingsTests extends TestBase {

    SettingsSteps settingsSteps = new SettingsSteps();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    ObjectMapper om = new ObjectMapper();
    Faker faker = new Faker();

    @Test
    @Tag("positive")
    @DisplayName("Enable dark mode")
    void enableDarkModeSuccessfulTest() throws IOException {
        DarkModeRequestModel request = om.readValue(
                new File("src/test/resources/api/darkMode.json"),
                DarkModeRequestModel.class
        );
        Gson gson = new Gson();
        String jsonString = gson.toJson(request);
        String jsonString2 = jsonString.replace("-1", settingsSteps.getDarkModeVersion());
        request = gson.fromJson(jsonString2, api.models.DarkModeRequestModel.class);
        DarkModeRequestModel finalRequest = request;
        DarkModeResponseModel response =
                step("Send PATCH request to enable dark mode", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .body(finalRequest)
                                .when()
                                .patch("rocks/1/containers/learning_app_ui_preferences/users/"
                                        + apiConfig.testUserId())
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(DarkModeResponseModel.class)
                );
    }

    @Test
    @Tag("negative")
    @DisplayName("Enable dark mode with invalid version number")
    void enableDarkModeWithInvalidVersionTest() throws IOException {
        DarkModeRequestModel request = om.readValue(
                new File("src/test/resources/api/darkMode.json"),
                DarkModeRequestModel.class
        );
        Gson gson = new Gson();
        String jsonString = gson.toJson(request);
        String jsonString2 = jsonString.replace("-1", faker.number().digit());
        request = gson.fromJson(jsonString2, api.models.DarkModeRequestModel.class);
        DarkModeRequestModel finalRequest = request;
        ValidatableResponse response =
                step("Send PATCH request to enable dark mode with random version number", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .body(finalRequest)
                                .when()
                                .patch("rocks/1/containers/learning_app_ui_preferences/users/"
                                        + apiConfig.testUserId())
                                .then()
                                .spec(statusCode409Spec)
                );
    }

    @Test
    @Tag("positive")
    @DisplayName("Set email reminder")
    void setEmailRemainderTest() throws IOException {
        EmailReminderRequestResponseModel request = om.readValue(
                new File("src/test/resources/api/emailReminder.json"),
                EmailReminderRequestResponseModel.class
        );
        EmailReminderRequestResponseModel response =
                step("Send PATCH request to set email reminder", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .body(request)
                                .when()
                                .patch("2017-06-30/users/" + apiConfig.testUserId()
                                       + "?fields=practiceReminderSettings")
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(EmailReminderRequestResponseModel.class)
                );
    }

    @Test
    @Tag("negative")
    @DisplayName("Set email reminder with no body")
    void setEmailRemainderWithNoBodyTest() {
        ValidatableResponse response =
                step("Send PATCH request to set email reminder with no body", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .when()
                                .patch("2017-06-30/users/" + apiConfig.testUserId() +
                                        "?fields=practiceReminderSettings")
                                .then()
                                .spec(statusCode400Spec)
                );
    }
}
