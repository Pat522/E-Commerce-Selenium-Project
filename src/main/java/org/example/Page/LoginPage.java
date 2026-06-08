package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPage {

    WebDriver driver;

    // Constructor to Pass the WebDriver from the Test class to the Page Class
    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By username = By.id("user-name");
    By password = By.id("password");
    By loginBtn = By.id("login-button");
    By errorMsg = By.cssSelector("h3[data-test='error']");

    // Common Login Method
    public void login(String user, String pass) {
       // driver.findElement(username).clear();
        driver.findElement(username).sendKeys(user);

       // driver.findElement(password).clear();
        driver.findElement(password).sendKeys(pass);

        driver.findElement(loginBtn).click();
    }

    // Valid Login
    public void ValidLogin() {
        login("standard_user", "secret_sauce");

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
    }

    // Invalid Username
    public void InvalidUsername() {
        login("wrong_user", "secret_sauce");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username and password do not match"));
    }

    // Invalid Password
    public void InvalidPassword() {
        login("standard_user", "wrong_password");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username and password do not match"));
    }

    // Invalid Username & Password
    public void InvalidUsernameAndPassword() {
        login("wrong_user", "wrong_password");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username and password do not match"));
    }

    // Empty Username
    public void EmptyUsername() {
        login("", "secret_sauce");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username is required"));
    }

    // Empty Password
    public void EmptyPassword() {
        login("standard_user", "");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Password is required"));
    }

    // Empty Username & Password
    public void EmptyUsernameAndPassword() {
        login("", "");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username is required"));
    }

    // Locked User
    public void LockedUser() {
        login("locked_out_user", "secret_sauce");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("locked out"));
    }

    // Random Username & Password
    public void RandomUserNameAndPassword() {
        login("abc", "xyz");

        Assert.assertTrue(
                driver.findElement(errorMsg).getText()
                        .contains("Username and password do not match"));
    }

    // URL Validation After Login
    public void UrlAfterLogin() {
        login("standard_user", "secret_sauce");

        Assert.assertEquals(
                driver.getCurrentUrl(),
                "https://www.saucedemo.com/inventory.html");
    }
}

