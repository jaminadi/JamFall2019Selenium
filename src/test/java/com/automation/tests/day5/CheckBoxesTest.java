package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckBoxesTest {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/checkboxes");
        BrowserUtils.wait(2);

        List<WebElement> checkBoxes = driver.findElements(By.tagName("input"));
        //verify that 1st checkbox is not selected and 2nd is selected

        if (!checkBoxes.get(0).isSelected() && checkBoxes.get(1).isSelected()) {
            System.out.println("Test passed");
        } else {
            System.out.println("Both tests failed");
        }
        BrowserUtils.wait(2);

        //let's click on the first checkbox and verify it's clicked4
        checkBoxes.get(0).click(); //to click on first checkbox
        //or WebElement checkbox1 = checkBoxes.get(0);
        //checkbox1.click();

        if (checkBoxes.get(0).isSelected()) {
            System.out.println("Test passed");
            System.out.println("checkbox 1 was selected");
        } else {
            System.out.println("Test failed");
        }


        driver.quit();


    }

}
