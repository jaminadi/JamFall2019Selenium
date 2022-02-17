package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class RadioButtons {

    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com/radio_buttons");
        driver.manage().window().maximize();

        BrowserUtils.wait(2);
        //<input type="radio>
        List<WebElement> radioButtons = driver.findElements(By.tagName("input"));

        for (WebElement radioButton : radioButtons) { // we take each radiobutton


            //<input type="radio" id="red" name="color">
            String id = radioButton.getAttribute("id");

            //returns true if button was already clicked
            boolean isSelected = radioButton.isSelected();
            System.out.println(id + " is selected?" + isSelected);


            //isEnabled is to check if disabled button can be clicked (returns boolean)
            if (radioButton.isEnabled()) {
                radioButton.click(); // and click on each of them
                System.out.println("Clicked on :: " + id);
                BrowserUtils.wait(1);
            } else {
                System.out.println("Button is disabled, not clicked :: " + id);
            }
            System.out.println();
        }

        driver.quit();


    }
}
