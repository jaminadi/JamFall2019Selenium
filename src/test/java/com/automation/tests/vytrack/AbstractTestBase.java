package com.automation.tests.vytrack;

import com.automation.utilities.ConfigurationReader;
import com.automation.utilities.Driver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

public abstract class AbstractTestBase { //this class is supposed to act like design/setup, so we should think of its visibility
    protected WebDriverWait wait; //protected because we need it to be visible within the package
    //and within the subclass, regardless of subclass location
    protected Actions actions;

    protected ExtentReports report;
    protected ExtentHtmlReporter htmlReporter;
    protected ExtentTest test;


    //@Optional - to make parameter optional
    //if you don't specify it, testng will require to specify this parameter for every test, in xml runner
    @BeforeTest
    @Parameters("reportName")
    public void setupTest(@Optional String reportName) {
        System.out.println("Report name: " + reportName);
        reportName = reportName == null ? "report.html" : reportName + ".html";

        report = new ExtentReports();

        String reportPath = "";
        //location of report file
        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            reportPath = System.getProperty("user.dir") + "\\test-output\\" + reportName;
        } else {
            reportPath = System.getProperty("user.dir") + "/test-output/" + reportName;
        }
        //is an HTML report itself
        htmlReporter = new ExtentHtmlReporter(reportPath);
        //add it to the reporter
        report.attachReporter(htmlReporter);
        htmlReporter.config().setReportName("VYTRACK Test Automation Results");
    }

    @AfterTest
    public void afterTest() {
        report.flush();//to release a report
    }


    @BeforeMethod
    public void setup() {
        String URL = ConfigurationReader.getProperty("qa1");
        Driver.getDriver().get(URL);
        Driver.getDriver().manage().window().maximize();
        wait = new WebDriverWait(Driver.getDriver(), 15);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void tearDown() {
        Driver.closeDriver();
    }
}
