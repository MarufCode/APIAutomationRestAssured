package org.example.testng;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG007 {


    @Test(groups = {"sanity", "QA"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
    }


    @Test(groups = {"reg", "sanity", "Preprod"})
    public void RegRun(){
        System.out.println("Regression");
        System.out.println("QA");
    }


    @Test(groups = {"reg", "smoke", "dev"})
    public void SmokeRun(){
        System.out.println("Smoke");
        Assert.assertTrue(false);
    }
}
