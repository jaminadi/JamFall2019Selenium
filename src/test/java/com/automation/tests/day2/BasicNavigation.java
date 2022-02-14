package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicNavigation {

    public static void main(String[] args) throws Exception {

        //to start selenium script we need:
        //setup webdriver(browser driver) and create webdriver object
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        //in selenium everything starts with WebDriver interface
        //ChromeDriver extends RemoteWebDriver --> implements WebDriver
        driver.get("http://google.com"); // to open website, it is like opening the door
        driver.manage().window().maximize();//to maximize browser size that will be opened by webdrivermanager

        Thread.sleep(3000); // this is for demo, wait 3 seconds and then close

        //method can return the page tittle
        //you can also see it as tab name, in the browser
        String title = driver.getTitle(); //returns <title> some title </title> text
        //or
        String expectedTitle = "Google";

        System.out.println("Title is: " + title); //Google

        if (expectedTitle.equals(title)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }

        //go to another website within the same window
        driver.navigate().to("http://amazon.com");

        if (driver.getTitle().toLowerCase().contains("amazon")) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

        //come back to google
        driver.navigate().back();
        verifyEquals(driver.getTitle(), "Google");

        //browser cannot close itself
        driver.close(); //to close browser
    }

    public static void verifyEquals(String arg1, String arg2) {
        if (arg1.equals(arg2)) {
            System.out.println("Test passed!");
        } else {
            System.out.println("Test failed!");
        }
    }

}
