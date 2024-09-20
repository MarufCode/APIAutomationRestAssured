package org.example.testng;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Test001 {


    @BeforeMethod
    void demo2(){
        System.out.println("BeforeMethod");
    }

    @Test
    void demo1(){
        System.out.println("Test");
    }

    @Test
    void demo5(){
        System.out.println("Test");
    }

    @AfterMethod
    void demo3(){
        System.out.println("AfterMethod");
    }
}
