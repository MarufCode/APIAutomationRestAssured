package org.example.testng.testngexamples;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNG004 {

    @BeforeTest
    public void getToken(){
        System.out.println("1");
    }

    @BeforeTest
    public void getbookingID(){
        System.out.println("2");
    }


    @Test
    public void t3(){
        //tokenand BookingID
        System.out.println("3");
    }
}