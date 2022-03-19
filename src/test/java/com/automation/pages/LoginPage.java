package com.automation.pages;

import com.automation.utilities.BrowserUtils;
import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id = "prependedInput") //we put annotation FindBy on top of instance var and specify locator type
    private WebElement username; //this is reference for username WebElement
    //or  public WebElement username2 = Driver.getDriver().findElement(By.id("perpendedInput"));

    @FindBy(id = "prependedInput2")
    private WebElement password;

    @FindBy(id = "_submit")
    private WebElement login;

    @FindBy(linkText = "Forgot your password?")
    private WebElement forgotPassword;

    @FindBy(css = "[class='alert alert-error']")
    private WebElement warningMessage;

    public LoginPage() { //constructor
        //to connect our WebDriver, page class and page factory
        //PageFactory - used for using @FindBy annotations
        //PageFactory - makes the process of finding elements much easier
        //or LoginPage.class instead of this
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String getWarningMessageText() {
        return warningMessage.getText();
    }

    /**
     * Method to login, version 1
     * Login as a specific user
     *
     * @param usernameValue
     * @param passwordValue
     */
    public void login(String usernameValue, String passwordValue) { //this method is overloaded
        username.sendKeys(usernameValue);
        password.sendKeys(passwordValue, Keys.ENTER);
        BrowserUtils.wait(3);
    }

    /**
     * Method to login, version 2
     * Login as a default user
     * Credentials will be retrieved from the configuration.properties file
     */
    public void login() {
        username.sendKeys(ConfigurationReader.getProperty("store_manager"));
        password.sendKeys(ConfigurationReader.getProperty("password"), Keys.ENTER);
        BrowserUtils.wait(3);
    }
}
