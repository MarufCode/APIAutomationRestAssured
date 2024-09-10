package org.example.tests.CRUD.POST;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

public class BDDStylePOST {

    @Test
    public void BDDStylePOsitiveTest(){

        // POST
        //URL
        //BODY - payload
        //Headers - Content Type


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

        RestAssured
                .given()
                .baseUri("https://restful-booker.herokuapp.com")
                .basePath("/booking").contentType(ContentType.JSON).log().all()
                .body(payload).when().post().then().log().all().statusCode(200);
    }

}
