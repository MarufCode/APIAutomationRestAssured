package org.example.tests.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matcher;
import org.testng.annotations.Test;

public class NonBDDStylePOST {

    ValidatableResponse validatableresponse;
    Response response;
    @Test
    public void NonBDDStylePositive(){
        RequestSpecification r = RestAssured.given();

        // Pre requisite

        String payload = "{\n" +
                "    \"firstname\" : \"Jim\",\n" +
                "    \"lastname\" : \"Brown\",\n" +
                "    \"totalprice\" : 100,\n" +
                "    \"depositpaid\" : true,\n" +
                "    \"bookingdates\" : {\n" +
                "        \"checkin\" : \"2018-01-01\",\n" +
                "        \"checkout\" : \"2019-01-01\"\n" +
                "    },\n" +
                "    \"additionalneeds\" : [\"Breakfast\", \"Lunch\"]\n" +
                "}";



                  r.baseUri("https://restful-booker.herokuapp.com");
                  r.basePath("/booking");
                  r.contentType(ContentType.JSON);
                  r.body(payload);


                // Making Request

                  response = r.when().post();

                // Validation

                  validatableresponse = response.then();
                  String responseString = response.asString();
                  System.out.println(responseString);

                  validatableresponse.statusCode(200);

    }


}
