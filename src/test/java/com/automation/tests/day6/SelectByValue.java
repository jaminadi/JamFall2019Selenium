package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectByValue {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select stateSelect = new Select(driver.findElement(By.id("state")));
        stateSelect.selectByValue("DC");

        String expected = "District Of Columbia";
        String actual = stateSelect.getFirstSelectedOption().getText();
        //we need to use getText(), because it returns a webelement, so that
        //we could compare it with our "expected" String

        if (expected.equals(actual)) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }


        BrowserUtils.wait(3);
        driver.quit();
    }
}
