package org.example.testng.testngexamples;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestNG013 {

    // Data Driven testing
    // test- with multiple inputs
    // logintest > 100 users
    // Registration DDT

    // Data provider - Test Data?

    @DataProvider
    public Object[][] getData(){
        return new Object[][]{
                new Object[]{"admin", "password"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password45"},
                new Object[]{"admin", "password55"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password1"},
                new Object[]{"admin", "password123"},
        };
    }


    @Test(dataProvider = "getData")
    public void loginTest(String username, String password){
        System.out.println(username);
        System.out.println(password);

    }




}
