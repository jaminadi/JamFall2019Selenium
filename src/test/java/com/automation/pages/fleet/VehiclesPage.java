package com.automation.pages.fleet;

import com.automation.pages.AbstractPageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class VehiclesPage extends AbstractPageBase {

    @FindBy(partialLinkText = "Create Car")
    private WebElement createCar;

    public void clickToCreateCar() { // we created the method, so that we could insert waits
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(createCar)).click();

    }
}
