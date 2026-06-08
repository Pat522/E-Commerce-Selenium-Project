package org.example.Tests;

import org.example.Page.AddToCartPage;
import org.example.Page.BrowserLaunch;
import org.example.Page.CheckoutPage;
import org.example.Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CheckoutPageTest extends BrowserLaunch {

    LoginPage login;
    AddToCartPage cart;
    CheckoutPage checkout;

    @BeforeMethod
    public void setupPage() {

        login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");
        cart = new AddToCartPage(driver);
        checkout = new CheckoutPage(driver);
    }

    @Test
    public void checkoutProductTest() {

        cart.addProductToCart();
        checkout.checkoutProduct();
    }
}