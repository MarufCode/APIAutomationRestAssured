package org.example.testng.testngexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Test003 {
    //PUT Request

    String token;
    Integer bookingID;



    public String getToken() {
        token = "123";
        return token;
    }

    @BeforeTest
    public void getTokenAndbookingID(){
        token = getToken();

        //post request


        bookingID = 123;
    }


    @Test
    public void testPUTReq(){
        System.out.println(token);
        System.out.println(bookingID);
    }

    @Test
    public void testPUTReq2(){
        System.out.println(token);
        System.out.println(bookingID);
    }


}
