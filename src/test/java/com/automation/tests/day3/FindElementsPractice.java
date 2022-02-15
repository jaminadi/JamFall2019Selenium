package com.automation.tests.day3;

import com.automation.utilities.DriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsPractice {

    public static void main(String[] args) throws Exception {

        // WebDriverManager.chromedriver().setup();
        // WebDriver driver = new ChromeDriver();

        WebDriver driver = DriverFactory.createDriver("chrome");
        driver.get("http://practice.cybertekschool.com/sign_up");
        WebElement fullName = driver.findElement(By.name("full_name"));
        fullName.sendKeys("Mister Twister");

        Thread.sleep(2000);

        WebElement email = driver.findElement(By.name("email"));
        email.sendKeys("sdet@cybertek.com"); // to enter email in the email section

        Thread.sleep(2000);

        WebElement signUp = driver.findElement(By.name("wooden_spoon"));
        //when you see type="submit", you can use submit() instead of click()
        //it makes sense to use it when click() method does not work
        signUp.submit(); // to simmulate clicking on Signup button

        Thread.sleep(2000);

        String expected = "Thank you for signing up. Click the button below to return to the home page.";
        WebElement message = driver.findElement(By.className("subheader")); // you can also find it by tagName, etc..has to be unique
        String actual = message.getText(); //returns visible text (anything in between opening and closing tags is a visible text)
        // above is done to get the text <h3> Text </h3>

        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }


        driver.quit();//to close everything

    }

}
