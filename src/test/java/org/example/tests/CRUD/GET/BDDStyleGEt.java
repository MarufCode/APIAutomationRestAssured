package org.example.tests.CRUD.GET;

import io.restassured.RestAssured;

public class BDDStyleGEt {
    public static void main(String[] args) {

       //GET Request - https://api.zippopotam.us/IN/400089

//        Given() -->
        // URL
        //HEADRER? - No needed
        //Get Mwthod
        //base url = https://api.zippopotam.us
        //Base Path = /IN/40008
        // Auth - No needed

        // When() -->
        // PAyload - Yes/ No
        // Get Method

        // Then() -->
        // Validation
        // response
        //Status Code
        // Response Body


//        RestAssured.given().when().then() - DSL (domain Specific Language)


        RestAssured.given()
                .baseUri("https://api.zippopotam.us").basePath("/IN/400089")
                .when().log().all()
                .get()
                .then().log().all().statusCode(200);


    }
}
