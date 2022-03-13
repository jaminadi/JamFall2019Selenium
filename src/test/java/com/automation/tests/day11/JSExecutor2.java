package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class JSExecutor2 {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/");
        driver.manage().window().maximize();

    }

    @Test
    public void verifyTitle() {
        String expected = "Practice";
        //we create javascriptexecutor object by casting casting webdriver object
        JavascriptExecutor js = (JavascriptExecutor) driver;//it's like you're switching from webdriver to jse
        //executeScript - this method executes javascript code
        //we provide js code as a string
        //return document.title - javascript code
        //document - represents HTML page
        String actual = js.executeScript("return document.title").toString();
        //String actual = (String) js.executeScript("return document.title");
        //.toString() - to avoid additional casting from Object to String
        Assert.assertEquals(actual, expected);

    }

    @Test
    public void clickTest() {
        //driver.findElement(By.linkText("Multiple Buttons")).click();
        //or
        WebElement link = driver.findElement(By.linkText("Multiple Buttons"));
        //link.click(); diasble this click action to perform it with js executor

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //after "" you can list webelements that will be used
        //as part of your javascript code
        //it's varargs, so you can list 0+
        //arguments - listed after , comma
        //use index to get specific webelement
        //Webelement arguments = {element, link, link2} from left to right like an array
        js.executeScript("arguments[0].click()", link);

        WebElement button6 = driver.findElement(By.id("disappearing_button"));

        //0 - because it's a first webelement after comma and there can be more elements after button6
        js.executeScript("arguments[0].click()", button6);
        BrowserUtils.wait(2);

        WebElement result = driver.findElement(By.id("result"));

        Assert.assertEquals(result.getText(), "Now it's gone!");
    }

    @Test
    public void textInputTest() {
        driver.findElement(By.linkText("Form Authentication")).click();
        BrowserUtils.wait(3);

        WebElement username = driver.findElement(By.name("username"));
        WebElement password = driver.findElement(By.name("password"));
        WebElement loginBtn = driver.findElement(By.id("wooden_spoon"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //to get text from input box - read attribute "value"
        //to enter text - set attribute "value"

        js.executeScript("arguments[0].setAttribute('value', 'tomsmith')", username);
        js.executeScript("arguments[0].setAttribute('value', 'SuperSecretPassword')", password);
        js.executeScript("arguments[0].click()", loginBtn);

        BrowserUtils.wait(4);

        String expected = "Welcome to the Secure Area. When you are done click logout below.";
        String subheader = js.executeScript("return document.getElementsByClassName('subheader')[0].textContent").toString();

        Assert.assertEquals(subheader, expected);
    }

    @Test
    public void scrollToElement() {
        BrowserUtils.wait(4);
        WebElement link = driver.findElement(By.linkText("CYDEO"));

        JavascriptExecutor js = (JavascriptExecutor) driver;
        //this will automatically scroll until the element becomes visible
        js.executeScript("arguments[0].scrollIntoView(true)", link);

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
