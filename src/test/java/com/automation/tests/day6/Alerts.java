package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Alerts {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
        BrowserUtils.wait(3);

        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        buttons.get(0).click(); //to click on the first button

        BrowserUtils.wait(2);
        //to get the text from the popup message
        String popupText = driver.switchTo().alert().getText();
        System.out.println(popupText);

        driver.switchTo().alert().accept();//to click OK in the Pop Up message

        String expected = "You successfully clicked an alert";
        String actual = driver.findElement(By.id("result")).getText();

        if (expected.equals(actual)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
        }

        buttons.get(1).click();// to click on the second button
        BrowserUtils.wait(2);

        driver.switchTo().alert().dismiss(); // to select cancel in the pop up window

        String expected1 = "You clicked: Cancel";
        String actual1 = driver.findElement(By.id("result")).getText();

        if (expected1.equals(actual1)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        buttons.get(2).click(); // click on 3rd button
        BrowserUtils.wait(2);

        Alert alert = driver.switchTo().alert();
        alert.sendKeys("Hello, World!"); // enter text
        alert.accept(); //click OK

        String actual2 = driver.findElement(By.id("result")).getText();
        String expected2 = "Hello, World!";

        if (actual2.endsWith(expected2)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
            System.out.println("Expected: " + expected2);
            System.out.println("Actual: " + actual2);
        }

        BrowserUtils.wait(3);
        driver.quit();
    }
}
