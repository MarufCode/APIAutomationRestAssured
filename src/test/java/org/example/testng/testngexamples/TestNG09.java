package org.example.testng.testngexamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG09 {
    @Test
    void testCase01(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }


    @Test
    void testCase02(){
        Assert.assertEquals(true,false,"Failed");
        System.out.println("This will not print");
    }
}
