package org.example.Tests;

import org.example.Page.AddToCartPage;
import org.example.Page.BrowserLaunch;
import org.example.Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends BrowserLaunch {

    LoginPage login;
    AddToCartPage cart;

    @BeforeMethod
    public void setupPage() {

      login = new LoginPage(driver);
      login.login("standard_user", "secret_sauce");
      cart = new AddToCartPage(driver);

    }

    @Test
    public void addProductToCartTest() {

        cart.addProductToCart();
    }

    @Test
    public void openCartTest() throws InterruptedException {

        cart.addProductToCart();
        cart.openCart();
    }

    @Test
    public void continueShoppingTest() throws InterruptedException {

        cart.addProductToCart();
        cart.continueShopping();
    }
}