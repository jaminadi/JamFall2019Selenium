package com.automation.tests.day11;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

public class WebTables {

    private WebDriver driver;

    @BeforeMethod
    public void setup() {
        //use this to open automated chrome browser without seeing it
        //will run the automated browser in the back, without visibly opening it
//        WebDriverManager.chromedriver().version("79").setup();
//        ChromeOptions chromeOptions = new ChromeOptions();
//        chromeOptions.setHeadless(true); // to run browser without GUI
//        driver = new ChromeDriver(chromeOptions);

        driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/tables");
        driver.manage().window().maximize();
    }

    @Test
    public void getColumnNames() {
        // th - represents table header cells
        List<String> expected = Arrays.asList("Last Name", "First Name", "Email", "Due", "Web Site", "Action");
        List<WebElement> columnNames = driver.findElements(By.xpath("//table[1]//th"));

        //this is done for printing out the elements
        for (WebElement columnName : columnNames) {
            System.out.println(columnName.getText());
        }
        Assert.assertEquals(BrowserUtils.getTextFromWebElements(columnNames), expected);
    }

    @Test
    public void verifyRowCount() { // collecting all rows from the web table
        // //tbody//tr - to get all rows from table body, excluding table header
        List<WebElement> rows = driver.findElements(By.xpath("//table[1]//tbody//tr"));
        //if we will get the size of this collection, it automatically equals to number of elements
        //expected - 4 rows in the table
        Assert.assertEquals(rows.size(), 4);
    }

    //to get specific column, skip row index, and just provide td index
    @Test
    public void getSpecificColumn() {
        //td[5] - column with links
        List<WebElement> links = driver.findElements(By.xpath("//table[1]//tbody//tr//td[5]"));
        System.out.println(BrowserUtils.getTextFromWebElements(links));
    }

    // Go to tables example page
    //delete record with jsmith@gmail.com email
    //verify that number of rows equals to 3
    //verify that jsmith@gmail.com does not exist anymore in the table

    @Test
    public void deleteRowTest() {

        String xpath = "//table[1]//td[text()='jsmith@gmail.com']/..//a[text()='delete']";
        driver.findElement(By.xpath(xpath)).click();

        //get count of rows
        int rowCount = driver.findElements(By.xpath("//table[1]//tbody/tr")).size();

        Assert.assertEquals(rowCount, 3);

        Assert.assertTrue(driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']")).isEmpty());
        //  or
        //List<WebElement> emails = driver.findElements(By.xpath("//table[1]//td[text()='jsmith@gmail.com']"));
        //Assert.assertTrue(emails.isEmpty());
    }

    //Let's write a function that will return column index based on column name
    @Test
    public void getColumnIndexByName() {
        String columnName = "Email";

        List<WebElement> columnNames = driver.findElements(By.xpath("//table[2]//th")); //6 columnNames
        int index = 0; // column index
        //we need to go through each column until we find the one we need
        for (int i = 0; i < columnNames.size(); i++) {

            String actualColumnName = columnNames.get(i).getText();

            System.out.println(String.format("Column name: %s, position %s", actualColumnName, i));

            if (actualColumnName.equals(columnName)) {
                index = i + 1; // in xpath indexes start with 1
                break;
            }
        }
        Assert.assertEquals(index, 3);
    }

    @Test
    public void getSpecificCell() {

        String expected = "http://www.jdoe.com";
        int row = 3;
        int column = 5;

        String xpath = "//table[1]//tbody//tr[" + row + "]//td[" + column + "]";
        WebElement cell = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(cell.getText(), expected);


    }


    @AfterMethod
    public void tearDown() {
        BrowserUtils.wait(2);
        driver.quit();
    }


}
