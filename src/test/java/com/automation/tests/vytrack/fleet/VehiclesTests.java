package com.automation.tests.vytrack.fleet;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/*
create @BeforeMethod with setup
       @AfterMethod with teardown part
Use LoginPageTests class as reference

create a test called verifyPageSubtitle
-in this test, you will need to navigate to Fleet --> Vehicles and
verify that page subtitle is equals to "All Cars"

use assertions for validation
 */
public class VehiclesTests {
    private WebDriver driver;
    private String URL = "https://qa2.vytrack.com/user/login";

    //these are correct credentials for store manager
    private String username = "storemanager85";
    private String password = "UserUser123";

    private By usernameBy = By.id("prependedInput"); // By is a class
    private By passwordBy = By.id("prependedInput2");

    private By fleetBy = By.xpath("//span[@class='title title-level-1' and contains(text(),'Fleet')]");
    private By subtitleBy = By.className("oro-subtitle");

    private By pageNumberBy = By.cssSelector("input[type='number']");


    @Test(description = "Login as store manager, click on Fleet and select Vehicles, verify that subtitle is equals to All Cars")
    public void verifyPageSubTitle() {

        //the code from here was cut to the @BeforeMethod,
        // so that we don't have to copy paste the whole code in our second test
        //////////////////////////////////////////////////////////////

        WebElement subTitleElement = driver.findElement(subtitleBy);
        BrowserUtils.wait(3);

        String expected = "All Cars";
        String actual = subTitleElement.getText();
        assertEquals(actual, expected, "The text does not match");
    }


    //    Given user is on the vytrack landing page
//    When user logs on as a store manager
//    Then user navigates to Fleet --> Vehicles
//    And user verifies that page number is equals to "1"
    @Test
    public void verifyPageNumber() {

        String expected = "1";
        String actual = driver.findElement(pageNumberBy).getAttribute("value");
        assertEquals(expected, actual, "The value is not correct");
    }

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(URL);
        driver.manage().window().maximize();

        driver.findElement(usernameBy).sendKeys(username);
        driver.findElement(passwordBy).sendKeys(password, Keys.ENTER);
        BrowserUtils.wait(3);

        //  driver.findElement(fleetBy).click(); //click on fleet selection
        //Actions class is used for more advanced browser interactions
        Actions actions = new Actions(driver);
        //move to element instead of click
        actions.moveToElement(driver.findElement(fleetBy)).perform(); //we are not clicking on selection, but hovering over the button
        //perform() - to execute command
        //every action should end with perform()

        BrowserUtils.wait(2);

        driver.findElement(By.linkText("Vehicles")).click();
        BrowserUtils.wait(3);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
