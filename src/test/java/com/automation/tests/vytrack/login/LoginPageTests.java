package com.automation.tests.vytrack.login;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


//static import of all Assertions
import static org.testng.Assert.*;
//static import allows you to use static methods without specifying class name


public class LoginPageTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";

    //these are correct credentials for store manager
    private String username = "storemanager85";
    private String password = "UserUser123";


    private By usernameBy = By.id("prependedInput"); // By is a class
    private By passwordBy = By.id("prependedInput2");
    // > in css selector means same thing as / in xpath - direct child
    private By warningMessageBy = By.cssSelector("[class='alert alert-error'] > div");


    @Test(description = "verify that warning message displays when user enters invalid username")
    public void invalidUsername() {
        driver.findElement(usernameBy).sendKeys("invalidusername");
        driver.findElement(passwordBy).sendKeys("UserUser123", Keys.ENTER);
        BrowserUtils.wait(3);
        WebElement warningElement = driver.findElement(warningMessageBy);
        assertTrue(warningElement.isDisplayed()); // if warning message is not visible, test will fail

        String expected = "Invalid user name or password.";
        String actual = warningElement.getText();
        assertEquals(actual, expected);
    }


    @Test(description = "Login as store manager and verify that title is equals to Dashboard")
    public void loginAsStoreManager() {
        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        //how can we verify title
        String expected = "Dashboard";
        String actual = driver.getTitle();//returns text under tag <title> and the text on tab
        assertEquals(actual, expected, "Page title is not correct!");
    }


    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        if (driver != null) { // if driver object exists
            driver.quit();//then close the browser
            driver = null; //close the session
            //destroy browser for sure

        }
    }
}
