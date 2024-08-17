package api.steps;

import api.config.ApiConfig;
import api.config.AuthConfig;
import api.models.UserProfileResponseModel;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import java.util.Arrays;

import static api.specs.DuolingoSpecs.requestSpec;
import static api.specs.DuolingoSpecs.statusCode200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProfileSteps {

    @Step("Delete subscription if user has it")
    public void deleteSubscription() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        UserProfileResponseModel response =
                step("Send GET request to view user profile", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .when()
                                .get("/2017-06-30/friends/users/"
                                        + apiConfig.otherTestUserId() + "/profile?pageSize=5&_=1723554223005")
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(UserProfileResponseModel.class)
                );
        if (response.getFollowers().getTotalUsers() > 0) {
            String s = (Arrays.toString(response.getFollowers().getUsers()));
            String userId = s.split("=")[6].split(",")[0];
            if (apiConfig.testUserId().equals(userId)) {
                step("Send DELETE request to delete subscription", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .when()
                                .delete("/2017-06-30/friends/users/"
                                        + apiConfig.testUserId() + "/follow/" + apiConfig.otherTestUserId())
                                .then()
                                .spec(statusCode200Spec)
                                .body("successful", is(true))
                );
            }
        }
    }
}

