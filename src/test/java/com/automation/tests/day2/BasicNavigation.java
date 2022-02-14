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
        driver.close(); //to close browser
    }
}
