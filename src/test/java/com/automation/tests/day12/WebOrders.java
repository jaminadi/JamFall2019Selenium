package com.automation.tests.day12;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class WebOrders {
    private WebDriver driver;
    private WebDriverWait wait;


    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        wait = new WebDriverWait(driver, 15);
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/weborders/");
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test", Keys.ENTER);
    }

    /*
    Go to web orders page
    Click on "Check All" button
    Verify that all records are selected
     */
    @Test
    public void checkBoxTest() {
        driver.findElement(By.linkText("Check All")).click();
        BrowserUtils.wait(2);
        List<WebElement> checkboxes = driver.findElements(By.cssSelector("input[type='checkbox']"));
        for (WebElement checkbox : checkboxes) {
            Assert.assertTrue(checkbox.isSelected());
        }

    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
