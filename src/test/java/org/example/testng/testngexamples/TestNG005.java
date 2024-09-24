package org.example.testng.testngexamples;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TestNG005 {


    RequestSpecification requestSpecification;
    ValidatableResponse validatableResponse;

    String token;
    Integer bookingID;

    @BeforeTest
    public void getToken(){
        System.out.println(" - Get Token - ");
        requestSpecification = RestAssured.given();
        String payload = "{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("auth");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);
        Response response = requestSpecification.post();
        validatableResponse = response.then();

        // Rest Assured -> Matchers (Hamcrest) - 1-2% Times we will be using it
        validatableResponse.body("token", Matchers.notNullValue());

        // TestNG assertion
        token = response.then().log().all().extract().path("token");
        Assert.assertNotNull(token);


    }

    @BeforeTest
    public void getbookingID(){

        System.out.println(" - Get BookingID - ");
        requestSpecification = RestAssured.given();
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



        requestSpecification.baseUri("https://restful-booker.herokuapp.com");
        requestSpecification.basePath("/booking");
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.body(payload);

        // Making Request

        Response response = requestSpecification.when().post();

        // Validation

        ValidatableResponse validatableresponse = response.then();
        String responseString = response.asString();
        System.out.println(responseString);

        validatableresponse.statusCode(200);

        bookingID = response.then().log().all().extract().path("bookingid");
        System.out.println(bookingID);
    }

    @Test
    public void testPUTRequest(){
        //token and BookingID

        System.out.println(" - Test Case PUT Request");

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

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/"+bookingID);
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

    @Test
    public void testPUTRequestNegative(){


        System.out.println(" - Test Case PUT Request");

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

        requestSpecification = RestAssured.given();
        requestSpecification.baseUri("https://restful-booker.herokuapp.com/");
        requestSpecification.basePath("booking/"+bookingID);
        requestSpecification.contentType(ContentType.JSON);
        requestSpecification.cookie("token", token);


        requestSpecification.body(payload).log().all();

        // Calling PUT Method

        Response response = requestSpecification.when().put();



        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        String firstName =  response.then().log().all().extract().path("firstname");

        // AssertJ

        assertThat(firstName).isNotNull().isNotBlank().isNotEmpty();


    }


}
