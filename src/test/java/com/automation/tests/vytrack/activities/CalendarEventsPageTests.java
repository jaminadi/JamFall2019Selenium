package com.automation.tests.vytrack.activities;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;


public class CalendarEventsPageTests {

    private WebDriver driver;
    private Actions actions;
    private By usernameBy = By.id("prependedInput");
    private By passwordBy = By.id("prependedInput2");

    private String storeManagerUserName = "storemanager85";
    private String storeManagerPassword = "UserUser123";

    private By activitiesBy = By.xpath("//span[@class='title title-level-1' and contains (text(), 'Activities')]");
    private By createCalendarEventBtnBy = By.cssSelector("a[title='Create Calendar event']");
    private By currentUserBy = By.cssSelector("#user-menu > a"); // # in cssSelector means id
    private By ownerBy = By.className("select2-chosen");
    private By titleBy = By.cssSelector("[name='oro_calendar_event_form[title]']");
    // * means contains in cssSelector.
    private By startDateBy = By.cssSelector("[class='input-small datepicker-input start hasDatepicker']");
    //for some reason, end-part of id changes when refreshed. That's why we use contains(*) to partially match id.
    //We indicated static part of id and provided into locator
    private By startTimeBy = By.cssSelector("[class='input-small timepicker-input start ui-timepicker-input']");

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
        driver.findElement(By.linkText("Calendar Events")).click();
        BrowserUtils.wait(4);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    //Go to activities ====>> Calendar events
    //Verify that Create calendar event button is displayed
    @Test
    public void verifyCreateCalendarEventBtn() {
        WebElement createCalendarEventBtn = driver.findElement(createCalendarEventBtnBy);
        BrowserUtils.wait(4);
        Assert.assertTrue(createCalendarEventBtn.isDisplayed());
    }


    /*this is in the @BeforeMethod
    Test case: Default options
    Login as sales manager
    Go to Activities---> Calendar Events


    Click on Create Calendar Event
    Default owner name should be current user
    Default title should be blank
    Default start date should be current date
    Default start time should be current time
     */
    @Test(description = "Default options")
    public void verifyDefaultValues() {
        //click on Create Calendar event button
        driver.findElement(createCalendarEventBtnBy).click();
        BrowserUtils.wait(4);
        //Default owner name should be current user
        String currentUserName = driver.findElement(currentUserBy).getText().trim();
        String defaultOwnerName = driver.findElement(ownerBy).getText().trim();
        Assert.assertEquals(currentUserName, defaultOwnerName);

        //Default title should be blank
        WebElement titleElement = driver.findElement(titleBy);
        BrowserUtils.wait(4);
        Assert.assertTrue(titleElement.getAttribute("value").isEmpty());

        //date time syntax=https://www.journaldev.com/17899/java-simpledateformat-java-date-format
        //Default start date should be current date
        String expectedDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMM d, yyyy"));
        BrowserUtils.wait(4);
        String actualDate = driver.findElement(startDateBy).getAttribute("value");
        BrowserUtils.wait(3);

        Assert.assertEquals(actualDate, expectedDate);

        String expectedTime = LocalTime.now(ZoneId.of("GMT-7")).format(DateTimeFormatter.ofPattern("h:m a"));
        String actualTime = driver.findElement(startTimeBy).getAttribute("value");

        Assert.assertEquals(actualTime, expectedTime);


        //Default start time should be current time


    }


}
