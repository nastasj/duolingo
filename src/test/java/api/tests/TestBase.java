package api.tests;

import api.config.ApiConfig;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {
    @BeforeAll
    public static void beforeAll() {
        ApiConfig apiConfig = ConfigFactory.create(ApiConfig.class, System.getProperties());
        RestAssured.baseURI = apiConfig.baseURI();
    }
}
