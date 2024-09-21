package org.example.tests.CRUD.DELETE;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStyleDelete {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    String token = "c83ff45ece1dc03";

    @Test
    public void testDeleteRequest() {


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/1623");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);


        // Calling PUT Method

        Response response = requestSpecification.when().put();


        validatableResponse = response.then().log().all();



        validatableResponse.statusCode(201);
//        validatableResponse.body("firstname", Matchers.equalTo("Maruf"));
//        validatableResponse.body("lastname", Matchers.equalTo("Brown"));

    }

}
