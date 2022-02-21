package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

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
        //select Option 1
        selectSimpleDropDown.selectByVisibleText("Option 1");

        //selecting date of birth from drop-down
        Select selectYear = new Select(driver.findElement(By.id("year")));
        Select selectMonth = new Select(driver.findElement(By.id("month")));
        Select selectDay = new Select(driver.findElement(By.id("day")));

        selectYear.selectByVisibleText("2003");
        selectMonth.selectByVisibleText("February");
        selectDay.selectByVisibleText("25");

        //select all months one by one
        //.getOptions(); - returns all options from dropdown as List<WebElement>
        List<WebElement> months = selectMonth.getOptions();
        for (WebElement eachMonth : months) {
            //get the month name and select based on that
            String monthName = eachMonth.getText();//.getText() returns visible text of options
            selectMonth.selectByVisibleText(monthName);
            BrowserUtils.wait(1);
        }

        BrowserUtils.wait(2);
        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByVisibleText("Texas");
        //option that is currently selected
        //getFirstSelectedOption()-returns a webElement, that's why we need to call getText()
        //getText() retrieves visible text from the webelement
        String selected = stateSelect.getFirstSelectedOption().getText();
        if (selected.equals("Texas")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }


        BrowserUtils.wait(3);
        driver.quit();
    }
}
