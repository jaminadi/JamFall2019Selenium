package com.automation.tests.day4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindElementsTest {
    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://practice.cybertekschool.com");

        Thread.sleep(3000);

        //how to collect all links from the page?
        //every link has a tag <a
        List<WebElement> links = driver.findElements(By.tagName("a"));
        //get all links under tag <a>
        for (WebElement link : links) {//iterate through all links
            System.out.println(link.getText());// print out all links text
            System.out.println(link.getAttribute("href"));
            System.out.println();
            // link.click();// click on link
            // Thread.sleep(2000);
            // driver.navigate().back();//go back
        }

        for (int i = 1; i < links.size(); i++) {
            links.get(i).click();
            //Thread.sleep(2000);
            driver.navigate().back();
            //Thread.sleep(2000);
            //refresh list and collection (links)
            links = driver.findElements(By.tagName("a"));

            //or
            //for (int i = 1; i < links.size(); i++) {
            // driver.findElements(By.tagName("a")).get(i).click();
            // driver.navigate().back();}
        }
        driver.quit();
    }
}
