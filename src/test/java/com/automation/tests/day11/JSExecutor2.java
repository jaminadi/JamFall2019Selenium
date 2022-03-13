package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void verifyTitle() {
        String expected = "Practice";
        //we create javascriptexecutor object by casting casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;//it's like you're switching from webdriver to jse
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title - javascript code
        //document - represents HTML page
        String actual = js.executeScript("return document.title").toString();
        //String actual = (String) js.executeScript("return document.title");
        //.toString() - to avoid additional casting from Object to String
        Assert.assertEquals(actual, expected);

    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
