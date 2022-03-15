package com.automation.tests.day13;

import com.automation.utilities.ConfigurationReader;
import org.testng.annotations.Test;

import java.io.ObjectInputFilter;

public class ConfigurationReaderTest {

    @Test
    public void readProperties() {
        String browser = ConfigurationReader.getProperty("browser");
        System.out.println(browser);
    }

}
