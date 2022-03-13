package com.automation.tests.day10;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor {
    private RemoteWebDriver driver; //reference type decides what is accessible


    @Test
    public void scrollTest() {
        driver.get("http://practice.cybertekschool.com/infinite_scroll");
        driver.manage().window().maximize();
        //you need to cast if reference type is a WebDriver, if the reference type is parent class, no need to cast
        // JavascriptExecutor js = (JavascriptExecutor) driver;
        //scroll down 250 pixels
        //  x, y coordinates
        for (int i = 0; i < 10; i++) {
            driver.executeScript("window.scrollBy(0, 250)");
            BrowserUtils.wait(3);
        }
    }

    //there is a method that allows you to scroll until certain point
    @Test
    public void scrollToElementTest() {
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
        BrowserUtils.wait(3);
        WebElement link = driver.findElement(By.linkText("Cybertek School"));
        driver.executeScript("arguments[0].scrollIntoView(true)", link);
        //scroll untill <link> becomes visible

    }


    @BeforeMethod
    public void setup() {
        //  driver = DriverFactory.createDriver("chrome");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();
    }
}
