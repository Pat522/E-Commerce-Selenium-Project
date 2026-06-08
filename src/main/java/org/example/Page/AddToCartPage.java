package org.example.Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AddToCartPage {

    WebDriver driver;

    public AddToCartPage(WebDriver driver) {
        this.driver = driver;
    }

    By addToCartBtn = By.id("add-to-cart-sauce-labs-backpack");
    By cartBadge = By.className("shopping_cart_badge");
    By cartIcon = By.className("shopping_cart_link");
    By  continueShoppingBtn = By.id("continue-shopping");

    public void addProductToCart() {

        driver.findElement(addToCartBtn).click();

        Assert.assertEquals(
                driver.findElement(cartBadge).getText(),
                "1");
    }

    public void openCart() throws InterruptedException {

        Thread.sleep(10000);

        driver.findElement(cartIcon).click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("cart.html"));

    }

    public void continueShopping() throws InterruptedException {

        driver.findElement(cartIcon).click();

        Thread.sleep(10000);

        driver.findElement(continueShoppingBtn).click();

        Assert.assertTrue(
                driver.getCurrentUrl().contains("inventory.html"));
    }
}