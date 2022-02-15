package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementById {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/login");

        driver.findElement(By.name("username")).sendKeys("Tom Smith");
        Thread.sleep(2000);

        // or driver.findElement(By.name("password")).sendKeys("supersecretpassword");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("supersecretpassword");

        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(2000);

        driver.quit();


    }
}
