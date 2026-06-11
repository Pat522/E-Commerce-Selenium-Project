package org.example.Tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import org.example.ExtentManager;
import org.example.Page.AddToCartPage;
import org.example.Page.BrowserLaunch;
import org.example.Page.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BrowserLaunch {

    LoginPage login;
    AddToCartPage cart;
    ExtentReports extent;
    ExtentTest test;

    @BeforeMethod
    public void setupPage() {

        login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        cart = new AddToCartPage(driver);
        extent = ExtentManager.getReports();
    }

    @Test
    public void addProductToCartTest() {

        test = extent.createTest("Add Product To Cart Test");

        cart.addProductToCart();

        test.pass("Product added to cart successfully");
    }

    @Test
    public void openCartTest() throws InterruptedException {

        test = extent.createTest("Open Cart Test");

        cart.addProductToCart();
        cart.openCart();

        test.pass("Cart opened successfully");
    }

    @Test
    public void continueShoppingTest() throws InterruptedException {

        test = extent.createTest("Continue Shopping Test");

        cart.addProductToCart();
        cart.continueShopping();

        test.pass("Continue Shopping button verified");
    }

    @AfterMethod
    public void tearDownReport() {

        extent.flush();
    }
}