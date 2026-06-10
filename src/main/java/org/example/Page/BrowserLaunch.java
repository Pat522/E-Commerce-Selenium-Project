package org.example.Page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BrowserLaunch {

    public WebDriver driver;

    @BeforeMethod
    public void setup() {

        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com/");

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/");

    }

    @AfterMethod
    public void tearDown() {

        if (driver != null) {
            driver.quit();
        }
    }

}