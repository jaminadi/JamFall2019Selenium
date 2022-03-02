package com.automation.tests.day9;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        WebElement img3 = driver.findElement(By.xpath("(//img)[3]"));

        //build() is needed when you want to combine a couple actions
        //always end with perform()
        //pause(1000). - just like Thread.sleep(1000)
        actions.moveToElement(img1).pause(1000).
                moveToElement(img2).pause(1000).
                moveToElement(img3).build().perform();


        //hover on the first image
        //verify that "name: user1" message is displayed when you hover over the image1
        //hover over image to make text visible
        actions.moveToElement(img1).perform();
        WebElement imgText1 = driver.findElement(By.xpath("//h5[text()='name: user1']"));
        //verify that webelement that contains the text is visible
        Assert.assertTrue(imgText1.isDisplayed());

        //move to the second image
        actions.moveToElement(img2).perform();
        WebElement imgText2 = driver.findElement(By.xpath("//h5[text()='name: user2']"));
        Assert.assertTrue(imgText2.isDisplayed());
    }

    @Test
    public void jqueryMenuTest() {
        driver.get("http://practice.cybertekschool.com/jqueryui/menu");
        //hover on "enabled"
        //hover on "downloads"
        //click on PDF

        WebElement enabledBtn = driver.findElement(By.id("ui-id-3"));
        WebElement downloadsBtn = driver.findElement(By.id("ui-id-4"));
        WebElement pdfBtn = driver.findElement(By.id("ui-id-5"));
        actions.moveToElement(enabledBtn).pause(1000).
                moveToElement(downloadsBtn).pause(1000).
                moveToElement(pdfBtn).click().build().perform();

    }

    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(3);
        driver.quit();
    }


}
