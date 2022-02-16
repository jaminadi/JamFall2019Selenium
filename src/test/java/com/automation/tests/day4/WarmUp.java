package com.automation.tests.day4;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Under tests, create a package "warmup"

 */
public class WarmUp {

    static WebDriver driver;

    public static void main(String[] args) throws Exception {

        // ebayTest();
        //amazonTest();
        wikiTest();


    }
//    Go to ebay ---> driver.get("http://ebay.com");
//    enter search term input.sendKeys("java book");
//    click on search button searchButton.click();
//    print number of results System.out.println(numOfResults.getText()); By,tagName("h1")

    public static void ebayTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("java book");
        driver.findElement(By.id("gh-btn")).click();
        WebElement searchResults = driver.findElement(By.tagName("h1"));
        System.out.println(searchResults.getText().split(" ")[0]);
        driver.quit();
    }

//    go to amazon
//    enter search term
//    click on search button
//    verify title contains search term

    public static void amazonTest() {
        driver = DriverFactory.createDriver("chrome");
        driver.get("http://amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("dyson hair dryer");
        driver.findElement(By.id("nav-search-submit-button")).click();

        String title = driver.getTitle();
        if (title.contains("dyson hair dryer")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }
        driver.quit();
    }

//    Go to wikipedia.org
//    enter search term `selenium webdriver`
//    click on search button
//    click on search `Selenium (software)`
//    verify url ends with `Selenium_(software)`

    public static void wikiTest() throws InterruptedException {
        driver = DriverFactory.createDriver("chrome");
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        driver.findElement(By.id("searchInput")).sendKeys("selenium webdriver", Keys.ENTER);
        driver.findElement(By.partialLinkText("Selenium (software)")).click();

        Thread.sleep(2000);

        String link = driver.getCurrentUrl(); //to get link as String
        if (link.contains("Selenium_(software)")) {
            System.out.println("Test passed");
        } else {
            System.out.println("Test failed");
        }

        driver.quit();
    }

}
