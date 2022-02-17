package com.automation.tests.day5;

import com.automation.utilities.BrowserUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestForiFrame {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com/iframe");
        BrowserUtils.wait(3);

        //before looking for that element, we need to jump inside that iframe content
        //you can specify: name, id, index or webelement of the frame
        //it's like we are accessing inside another layer
        driver.switchTo().frame("mce_0_ifr");// our element is inside this element

        //now, this content will be accessible
        WebElement textInput = driver.findElement(By.id("tinymce"));
        System.out.println(textInput.getText());

        //exit from the frame after we're done
        driver.switchTo().defaultContent();


        driver.quit();
    }
}
