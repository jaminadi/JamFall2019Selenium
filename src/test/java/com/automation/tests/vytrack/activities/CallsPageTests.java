package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class CallsPageTests {

    private WebDriver driver;
    private Actions actions;

    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains (text(), 'Activities')]");
    private By logCallBtnBy = By.cssSelector("a[title='Log call']");

//Login as story manager to Vytrack
//Go to activities ===> Calls
//Verify that Log Call button is displayed

    @Test
    public void verifyLogButton() {
            WebElement logCallBtnElement = driver.findElement(logCallBtnBy);
            Assert.assertTrue(logCallBtnElement.isDisplayed());
    }


    @BeforeMethod
    public void setup() {
        //without driver we cannot use actions class
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().window().maximize();

        actions = new Actions(driver);

        BrowserUtils.wait(4);
        driver.findElement(usernameBy).sendKeys(storeManagerUserName);
        driver.findElement(passwordBy).sendKeys(storeManagerPassword, Keys.ENTER);
        BrowserUtils.wait(4);

        //hover over Activities
        actions.moveToElement(driver.findElement(activitiesBy)).perform();
        BrowserUtils.wait(4);
        driver.findElement(By.linkText("Calls")).click();
        BrowserUtils.wait(5);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
