package com.automation.tests.day6;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectByText_MultipleOptions {

    public static void main(String[] args) {

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        BrowserUtils.wait(3);

        Select languagesSelect = new Select(driver.findElement(By.name("Languages")));
        //whether this select element support selecting multiple options at the same time?
        //this is done by checking the value of the "multiple" attribute
        boolean isMultiple = languagesSelect.isMultiple();
        System.out.println(isMultiple);//if returns true, you can select multiple options

        languagesSelect.selectByVisibleText("Java");
        languagesSelect.selectByVisibleText("JavaScript");
        languagesSelect.selectByVisibleText("Python");

        //verify that above selections were selected
        List<WebElement> selectedLanguages = languagesSelect.getAllSelectedOptions();

        for (WebElement selectedLanguage : selectedLanguages) {
            System.out.println(selectedLanguage.getText());
        }

        //deselect some of the selected options
        languagesSelect.deselectByVisibleText("Java");
        BrowserUtils.wait(2);

        languagesSelect.deselectAll();

        BrowserUtils.wait(2);
        driver.quit();

    }
}
