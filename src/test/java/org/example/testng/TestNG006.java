package org.example.testng;

import org.testng.annotations.Test;

public class TestNG006 {

    @Test(priority = 1)
    public void TC1(){
        System.out.println("1");
    }
    @Test(priority = 4)
    public void TC2(){
        System.out.println("2");
    }
    @Test(priority = 3)
    public void TC3(){
        System.out.println("3");
    }
    @Test(priority = -1)
    public void TC4(){
        System.out.println("4");
    }
}
