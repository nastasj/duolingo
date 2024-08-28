package api.tests;

import api.config.ApiConfig;
import api.config.AuthConfig;
import api.models.SearchUsersResponseModel;
import api.models.SubscribeUserRequestModel;
import api.models.SubscribeUserResponseModel;
import api.models.UserProfileResponseModel;
import api.steps.ProfileSteps;
import com.github.javafaker.Faker;
import io.qameta.allure.Owner;
import io.restassured.response.ValidatableResponse;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static api.specs.DuolingoSpecs.*;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

@Tag("duolingo")
@Tag("api")
@Tag("profile")
@Owner("Antoshkina Anastasia")
public class ProfileTests extends TestBase {

    ProfileSteps profileSteps = new ProfileSteps();
    AuthConfig authConfig = ConfigFactory.create(AuthConfig.class, System.getProperties());
    ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
    Faker faker = new Faker();

    @Test
    @Tag("positive")
    @DisplayName("Search for users")
    void searchForUsersTest() {
        SearchUsersResponseModel response =
                step("Send GET request to search for users", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .queryParam("pageSize", 20)
                                .queryParam("query", faker.name().firstName())
                                .queryParam("searchType", "QUERY")
                                .queryParam("_", "1723549284611")
                                .when()
                                .get("2017-06-30/friends/users")
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(SearchUsersResponseModel.class)
                );
        step("Check response", () -> {
            assertThat(response.getTotalResults()).isGreaterThanOrEqualTo(0);
            assertThat(response.getUsers()).hasSizeGreaterThanOrEqualTo(0);
        });
    }

    @Test
    @Tag("negative")
    @DisplayName("Search for users with no required query parameter")
    void searchForUsersWithNoRequiredParameterTest() {
        ValidatableResponse response =
                step("Send GET request to search for users with no required query parameter", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .queryParam("pageSize", 20)
                                .queryParam("searchType", "QUERY")
                                .queryParam("_", "1723549284611")
                                .when()
                                .get("2017-06-30/friends/users")
                                .then()
                                .spec(statusCode422Spec)
                );
    }

    @Test
    @Tag("positive")
    @DisplayName("Get user profile")
    void getUserProfileTest() {
        UserProfileResponseModel response =
                step("Send GET request to get user profile", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .queryParam("pageSize", 5)
                                .queryParam("_", "1723554223005")
                                .when()
                                .get("2017-06-30/friends/users/"
                                        + apiConfig.otherTestUserId() + "/profile")
                                .then()
                                .spec(statusCode200Spec)
                                .extract().as(UserProfileResponseModel.class)
                );
        step("Check response", () -> {
            assertThat(response.getCanFollow()).isIn(true, false);
            assertThat(response.getIsFollowedBy()).isIn(true, false);
            assertThat(response.getIsFollowing()).isIn(true, false);
            assertThat(response.getIsVerified()).isIn(true, false);
            assertThat(response.getFollowers().getCursor()).isNull();
            assertThat(response.getFollowers().getTotalUsers()).isGreaterThanOrEqualTo(0);
            assertThat(response.getFollowers().getUsers()).hasSizeGreaterThanOrEqualTo(0);
            assertThat(response.getFollowing().getCursor()).isNull();
            assertThat(response.getFollowing().getTotalUsers()).isGreaterThanOrEqualTo(0);
            assertThat(response.getFollowing().getUsers()).hasSizeGreaterThanOrEqualTo(0);
            assertThat(response.getFriendsInCommon().getCursor()).isNull();
            assertThat(response.getFriendsInCommon().getTotalUsers()).isGreaterThanOrEqualTo(0);
            assertThat(response.getFriendsInCommon().getUsers()).hasSizeGreaterThanOrEqualTo(0);
        });
    }

    @Test
    @Tag("negative")
    @DisplayName("Get user profile with invalid userId")
    void getUserProfileWithInvalidUserIdTest() {
        ValidatableResponse response =
                step("Send GET request to view user profile with invalid userId", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .queryParam("pageSize", 5)
                                .queryParam("_", "1723554223005")
                                .when()
                                .get("2017-06-30/friends/users/"
                                        + faker.cat().name() + "/profile")
                                .then()
                                .spec(statusCode404Spec)
                );
    }

    @Test
    @Tag("positive")
    @DisplayName("Subscribe to user")
    void subscribeToUserTest() {
        SubscribeUserRequestModel request = new SubscribeUserRequestModel();
        request.setComponent("profile_header_button");
        request.setFollowReason("search");
        SubscribeUserResponseModel response =
                step("Send POST request to subscribe to user", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .body(request)
                                .when()
                                .post("2017-06-30/friends/users/"
                                        + apiConfig.testUserId() + "/follow/" + apiConfig.otherTestUserId())
                                .then()
                                .spec(statusCode201Spec)
                                .extract().as(SubscribeUserResponseModel.class)
                );
        step("Check response is successful", () ->
                assertThat(response.getSuccessful()).isEqualTo(true)
        );
        step("Delete subscription", () ->
                profileSteps.deleteSubscription()
        );
    }

    @Test
    @Tag("negative")
    @DisplayName("Subscribe to user with invalid userId")
    void subscribeToUserWithInvalidUserIdTest() {
        SubscribeUserRequestModel request = new SubscribeUserRequestModel();
        request.setComponent("profile_header_button");
        request.setFollowReason("search");
        ValidatableResponse response =
                step("Send POST request to subscribe to user", () ->
                        given(requestSpec)
                                .header("Authorization", authConfig.token())
                                .body(request)
                                .when()
                                .post("2017-06-30/friends/users/"
                                        + faker.cat().name() + "/follow/" + faker.cat().name())
                                .then()
                                .spec(statusCode404Spec)
                );
    }
}
