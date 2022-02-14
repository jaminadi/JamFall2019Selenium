package com.automation.tests.day1;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class MyFirstSeleniumScript {

    public static void main(String[] args) {

        // 1. setup chromedriver
        WebDriverManager.chromedriver().setup();
        // 2. create chromedriver object
        ChromeDriver driver = new ChromeDriver();
        // 3. open some website
        driver.get("http://facebook.com");
    }
}
