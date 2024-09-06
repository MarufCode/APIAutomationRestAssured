package org.example.tests.CRUD.GET;

import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class NonBDDStyleGet {
    // GEt Request
    // BDD Style and Non BDD Style

    public static void main(String[] args) {

        RequestSpecification r = RestAssured.given();
        r.baseUri("https://restful-booker.herokuapp.com/");
        r.basePath("/booking/5423").log().all();
        r.when().get();
        r.then().log().all().statusCode(200);

    }

}
