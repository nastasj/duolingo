package api.steps;

import api.config.ApiConfig;
import api.config.AuthConfig;
import io.qameta.allure.Step;
import org.aeonbits.owner.ConfigFactory;

import static api.specs.DuolingoSpecs.requestSpec;
import static api.specs.DuolingoSpecs.statusCode200Spec;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

public class ProfileSteps {

    @Step("Delete subscription")
    public void deleteSubscription() {
        AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        step("Send DELETE request to delete subscription", () ->
                given(requestSpec)
                        .header("Authorization", authConfig.token())
                        .when()
                        .delete("2017-06-30/friends/users/"
                                + apiConfig.testUserId() + "/follow/" + apiConfig.otherTestUserId())
                        .then()
                        .spec(statusCode200Spec)
                        .body("successful", is(true))
        );
    }
}

