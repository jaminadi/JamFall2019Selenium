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

        //browser cannot close itself
        driver.close(); //to close browser
    }
}
