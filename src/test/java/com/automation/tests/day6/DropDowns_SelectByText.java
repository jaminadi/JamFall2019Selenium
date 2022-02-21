package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class DropDowns_SelectByText {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);
        //first, create a webelement object for drop-down
        WebElement simpleDropDrown = driver.findElement(By.id("dropdown"));
        //provide webelement object into constructor
        Select selectSimpleDropDown = new Select(simpleDropDrown);
        //select by visible text
        selectSimpleDropDown.selectByVisibleText("Option 2");


        BrowserUtils.wait(3);
        driver.quit();
    }
}
