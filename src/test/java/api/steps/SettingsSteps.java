package api.steps;

import api.config.ApiConfig;
import api.config.AuthConfig;
import api.models.DarkModeResponseModel;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;

import static api.specs.DuolingoSpecs.statusCode200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class SettingsSteps {

    @Step("Get dark mode settings")
    public String getDarkModeVersion() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        DarkModeResponseModel response =
                step("Send GET request to get dark mode version", () ->
                        given()
                                .header("Authorization", authConfig.token())
                                .queryParam("_", "1723407033500")
                                .contentType("application/json")
                                .when()
                                .get("rocks/1/containers/learning_app_ui_preferences/users/" + apiConfig.testUserId())
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(DarkModeResponseModel.class)
                );
        String s = (Arrays.toString(response.getEntries()));
        String versionNumber = s.split("=")[3].split("]")[0];
        return versionNumber.substring(0, versionNumber.length() - 1);
    }
}
