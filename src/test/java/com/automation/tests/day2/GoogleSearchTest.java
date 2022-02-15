package com.automation.tests.day2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

    public static void main(String[] args) throws Exception {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(2000);
        //By.name("cr20") ---> name="cr20"
        //name - is one of the selenium locators
        //there are 8 of them
        //we use locators to find elements
        //to choose locator, just use By.locator
        //first, we need to find locator on a page manually
        WebElement search = driver.findElement(By.name("q"));
        //once we found an element like above, how to enter text?
        //to enter text, use sendKeys() method
        //how to press Enter after entering the text?
        //use Key.ENTER
        //Keys.ENTER - performs keyboard click, simulates Enter button
        search.sendKeys("Java", Keys.ENTER); //here we're trying enter the text into the element
        Thread.sleep(2000);
        //if see <a> element, it calls link
        //visible text of this link can be used by selenium to find this element
        WebElement news = driver.findElement(By.linkText("News"));
        Thread.sleep(4000);

        driver.quit();
    }
}
