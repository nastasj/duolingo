package api.specs;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import static api.helpers.CustomAllureListener.withCustomTemplate;
import static io.restassured.RestAssured.with;
import static io.restassured.filter.log.LogDetail.ALL;

public class DuolingoSpecs {
    public static RequestSpecification requestSpec = with()
            .filter(withCustomTemplate())
            .log().all()
            .contentType(ContentType.JSON);

    public static ResponseSpecification statusCode200Spec = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .log(ALL)
            .build();

    public static ResponseSpecification statusCode201Spec = new ResponseSpecBuilder()
            .expectStatusCode(201)
            .log(ALL)
            .build();

    public static ResponseSpecification statusCode400Spec = new ResponseSpecBuilder()
            .expectStatusCode(400)
            .log(ALL)
            .build();

    public static ResponseSpecification statusCode404Spec = new ResponseSpecBuilder()
            .expectStatusCode(404)
            .log(ALL)
            .build();

    public static ResponseSpecification statusCode409Spec = new ResponseSpecBuilder()
            .expectStatusCode(409)
            .log(ALL)
            .build();

    public static ResponseSpecification statusCode422Spec = new ResponseSpecBuilder()
            .expectStatusCode(422)
            .log(ALL)
            .build();

}
