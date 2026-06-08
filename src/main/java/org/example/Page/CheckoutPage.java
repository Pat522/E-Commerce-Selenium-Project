package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CheckoutPage {

    WebDriver driver;

    public CheckoutPage(WebDriver driver) {
        this.driver = driver;
    }

    By cart = By.className("shopping_cart_link");
    By checkout = By.id("checkout");
    By firstName = By.id("first-name");
    By lastName = By.id("last-name");
    By zipCode = By.id("postal-code");
    By continueBtn = By.id("continue");
    By finishBtn = By.id("finish");
    By successMsg = By.className("complete-header");

    public void checkoutProduct() {

        driver.findElement(cart).click();
        driver.findElement(checkout).click();

        driver.findElement(firstName).sendKeys("Aman");
        driver.findElement(lastName).sendKeys("Sharma");
        driver.findElement(zipCode).sendKeys("122001");

        driver.findElement(continueBtn).click();
        driver.findElement(finishBtn).click();

        Assert.assertEquals(
                driver.findElement(successMsg).getText(),
                "Thank you for your order!");
    }
}