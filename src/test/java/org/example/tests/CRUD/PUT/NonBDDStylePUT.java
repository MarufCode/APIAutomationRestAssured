package org.example.tests.CRUD.PUT;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class NonBDDStylePUT {
    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    String token = "c83ff45ece1dc03";

    @Test
    public void testPutRequest(){

        String payload = "{\n" +
                "    \"firstname\" : \"Maruf\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 111,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : \"Breakfast\"\n" +
                "}";



        String patchpayload = "{\n" +
                "  \"username\": \"admin\",\n" +
                "  \"password\": \"password123\"\n" +
                "}";


        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("booking/641");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);



        requestSpecification.body(payload).log().all();

        // Calling PUT Method

        Response response = requestSpecification.when().put();



        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);
        validatableResponse.body("firstname", Matchers.equalTo("Maruf"));
        validatableResponse.body("lastname", Matchers.equalTo("Brown"));


    }



}
