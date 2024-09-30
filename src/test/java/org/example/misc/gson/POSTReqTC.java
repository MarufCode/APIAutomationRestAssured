package org.example.misc.gson;
import com.google.gson.Gson;
import com.github.javafaker.Faker;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.example.misc.gson.example.Booking;
import org.example.misc.gson.example.BookingResponse;
import org.example.misc.gson.example.Bookingdates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.*;

import java.util.Collections;

public class POSTReqTC {

    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    @Test
    public void testpositive(){

        // Step1 - POST
        // URL -> Base URI + base Path
        // HEADER
        // BODY
        // Auth - NO


        // Step 2
        // prepare the Payload ( Object -> JSON String)
        // send the request

        //Step 3
        // Validate Response ( JSON String -> Object)
        // FirstName,
        // Status Code
        // Time Response


        // prepare your payload
        Faker faker = new Faker();
        Booking booking = new Booking();
        String expectFirstName = faker.name().firstName();


        booking.setFirstname(expectFirstName);
        booking.setLastname("Sherikar");
        booking.setTotalprice(999);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2018-01-01");
        bookingdates.setCheckout("2018-01-01");;
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds(Collections.singletonList("Breakfast"));

        System.out.println(booking);
        // object -> JSOn String (GSON)

        Gson gson = new Gson();
        String jsonStringBooking = gson.toJson(booking);
        System.out.println(jsonStringBooking);








        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(jsonStringBooking).log().all();

        Response response = requestSpecification.when().post();
        String jsonResponseString = response.asString();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        // Validate Response ( JSON String -> Object)


        BookingResponse bookingResponseObject = gson.fromJson(jsonResponseString, BookingResponse.class);

       assertThat(bookingResponseObject.getBookingid()).isNotNull();
       assertThat(bookingResponseObject.getBooking().getFirstname()).isEqualTo(expectFirstName);





        // Request Payload - Response - - 3 Class
        // 1. Booking -> Bookingdates
        // 2 Response - BookingResponse  - Booking







    }
}
