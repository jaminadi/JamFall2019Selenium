package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsClassTests {
    private WebDriver driver;
    private Actions actions;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        actions = new Actions(driver);

    }


    @Test
    public void hoverOnImage() {
        driver.get("http://practice.cybertekschool.com/hovers");
        BrowserUtils.wait(3);

        //indexes start with 1 in xpath
        WebElement img1 = driver.findElement(By.xpath("(//img)[1]"));
        WebElement img2 = driver.findElement(By.xpath("(//img)[2]"));

        //build() is needed when you want to combine a couple actions
        //always end with perform()
        actions.moveToElement(img1).pause(1000).moveToElement(img2).build().perform();


    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();
    }


}
