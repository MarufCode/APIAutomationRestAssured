package org.example.misc.gson;

import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.misc.gson.example.Booking;
import org.example.misc.gson.example.Bookingdates;
import org.testng.annotations.Test;

import java.util.Collections;

public class Demo {

    // Payload
    // String -> Not
    // Hashmap -> Not
    // Class - Which class?

    // POJO
    // ?
    // 1 - diffcult
    // 2. easy!

    //{
    //            "firstname" : "Jim",
    //                "lastname" : "Brown",
    //                "totalprice" : 111,
    //                "depositpaid" : true,
    //                "bookingdates" : {
    //            "checking" : "2018-01-01",
    //                    "checkout" : "2019-01-01"
    //        },
    //            "additionalneeds" : "Breakfast"
    //        }



    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;
@Test

    public void testPost(){

    Booking booking = new Booking();
    booking.setFirstname("Maruf");
    booking.setFirstname("Sherikar");
    booking.setTotalprice(999);
    booking.setDepositpaid(true);

    Bookingdates bookingdates = new Bookingdates();
    bookingdates.setCheckin("2018-01-01");
    bookingdates.setCheckout("2018-01-01");;
    booking.setBookingdates(bookingdates);
    booking.setAdditionalneeds(Collections.singletonList("Breakfast"));

    System.out.println(booking);


//    requestSpecification = RestAssured.given();
//    requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
//    requestSpecification.basePath("booking");
//    requestSpecification.contentType(ContentType.JSON);
//    requestSpecification.body(jsonBodyUsingMap).log().all();
//
//    Response response = requestSpecification.when().post();
//
//    Integer bookingId = response.then().extract().path("bookingid");
//
//    // Get Validatable response to perform validation
//    validatableResponse = response.then().log().all();
//    validatableResponse.statusCode(200);
//    System.out.println("Your Booking Id is -> " +  bookingId);



}









}
