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

//- setup before/after methods
//        - in before method - instantiate webdriver and navigate to: http://practice.cybertekschool.com/
//        - in after method - just close webdriver.
//
// - create a test called loginTest
//        - go to "Form Authentication" page
//        - enter valid credentials
//              username: tomsmith
//              password: SuperSecretPassword
//
// - verify that following sub-header message is displayed: "Welcome to
// the Secure Area. When you are done click logout below."

public class PracticeTests {
    private WebDriver driver;

    @Test
    public void loginTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("username")).sendKeys("tomsmith");
        driver.findElement(By.name("password")).sendKeys("SuperSecretPassword", Keys.ENTER);

        BrowserUtils.wait(2);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String actual = driver.findElement(By.className("subheader")).getText();
        //If assertion fails - it will throw exception and message will be printed
        //3 param(expected, actual, message in case of error
        Assert.assertEquals(actual, expected, "Sub-header message is not matching!");


    }

    /**
     * Given user is on practice landing page
     * When user navigates to "Forgot Password" page
     * Then user enters his email
     * And clicks "Retrieve password" button
     * Then user verifies that message "Your e-mail's been sent!" is displayed
     */
    @Test
    public void forgotPasswordTest() {
        driver.findElement(By.linkText("Forgot Password")).click();
        BrowserUtils.wait(2);

        driver.findElement(By.name("email")).sendKeys("abcdefg@gmail.com", Keys.ENTER);

        String expected = "Your e-mail's been sent!";
        String actual = driver.findElement(By.name("confirmation_message")).getText();
        Assert.assertEquals(actual, expected);
    }

    /**
     * Given user is on practice landing page
     * When user navigates to "Checkboxes" page
     * And clicks on checkbox#1
     * Then user verifies that checkbox #1 is selected
     */
    @Test
    public void checkboxTest() {
        driver.findElement(By.linkText("Checkboxes")).click();
        BrowserUtils.wait(2);

        //locator for specific checkbox, xpath: //input[1], cssSelector: input:nth-of-type(1)
        //   //input[@type="checkbox"][1]
        //collect all checkboxes
        List<WebElement> checkboxes = driver.findElements(By.tagName("input"));
        checkboxes.get(0).click();

        Assert.assertTrue(checkboxes.get(0).isSelected(), "Checkbox #1 is not selected");

    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }
}
