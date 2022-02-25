package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.*;

public class BasicTestNGTests {


    @BeforeSuite
    public void beforeSuite() {
        System.out.println("BeforeSuite");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("AfterSuite");
    }

    //runs only once before @BeforeClass and @BeforeMethod
    @BeforeTest
    public void beforeTest() {
        System.out.println("BeforeTest");
    }

    //runs only once after @AfterClass and @AfterMethod
    @AfterTest
    public void afterTest() {
        System.out.println("AfterTest");
    }

    //runs only once in the class before @beforemethod and before any test
    //regardless on number of tests, it runs only once
    @BeforeClass
    public void beforeClass() {
        //something that should be done only once in one class before all tests
        System.out.println("BeforeClass");
    }

    @AfterClass
    public void afterClass() {
        //something that should be done only once in one class after all tests
        System.out.println("AfterClass");
    }

    //BeforeMethod runs before every test automatically
    //works as a pre-condition or a setup
    @BeforeMethod
    public void setup() {
        System.out.println("BeforeMethod");
    }

    //@AfterMethod runs automatically after every test
    @AfterMethod
    public void teardown() {
        System.out.println("AfterMethod");
    }

    @Test
    public void test1() {
        System.out.println("TEST 1");
        String expected = "apple";
        String actual = "apple";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void test2() {
        System.out.println("TEST 2");
        int num1 = 5;
        int num2 = 10;
        //it is called hard assertion
        //if assertion fails-it stops the execution(due to exception)
        Assert.assertTrue(num2 > num1);
    }

}
