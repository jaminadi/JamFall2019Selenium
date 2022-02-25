package com.automation.tests.day8;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTests {
    private WebDriver driver;

    @Test
    public void googleSearchTest() {
        driver.get("http://google.com");
        driver.findElement(By.name("q")).sendKeys("java", Keys.ENTER);
        BrowserUtils.wait(2);
        //since every search item has a tag name <h3>
        //it is the easiest way to collect all of them at once
        List<WebElement> searchItems = driver.findElements(By.tagName("h3"));
        for (WebElement searchItem : searchItems) {
            String var = searchItem.getText();
            if (!var.isEmpty() && (var.toLowerCase().contains("java"))) {
                System.out.println(var);
                //verify that every search result contains java
                //if some of the search results does not contain java,
                //the test will fail
                Assert.assertTrue(var.toLowerCase().contains("java"));
            }


            //if there is a text - print it
            //this way we eliminated lines with empty text
            //there are elements that don't have any text & our test will fail if we leave them
            //if (!var.isEmpty()) {
            // System.out.println(var);
            //verify that every search result contains java
            // Assert.assertTrue(var.toLowerCase().contains("java"));
        }
    }
    //}


    @BeforeMethod
    public void setup() { //setup
        //setup WebDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }


    @AfterMethod
    public void teardown() { //clean up
        //close browser and destroy WebDriver object
        driver.quit();
    }
}
