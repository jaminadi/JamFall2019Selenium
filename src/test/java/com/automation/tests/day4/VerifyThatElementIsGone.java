package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyThatElementIsGone {

    public static void main(String[] args) throws Exception {

        /**
         * Interview question:
         *
         * how to check if element does not exist anymore in the DOM (Document Object Model(that HTML code)) (element is gone)
         *
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        driver.findElement(By.id("disappearing_button")).click();
        Thread.sleep(2000);

        // List<WebElement> list = driver.findElements(By.id("disappearing_button"));
        //  if(list.size() == 0){
        //or

        if (driver.findElements(By.id("disappearing_button")).size() == 0) {//here we are checking how many elements are left under this id after click
            System.out.println("Test passed"); //if size is 0, that means no elements were found, the list is empty,which means the button has disappeared
        } else {
            System.out.println("Test failed");
        }

        Thread.sleep(2000);
        //lets find all other buttons
        //make sure you use findElements
        List<WebElement> buttons = driver.findElements(By.tagName("button"));
        //click on every button
        for (WebElement button : buttons) {
            button.click();
            Thread.sleep(2000);
        }

        driver.quit();
    }
}
