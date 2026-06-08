package org.example.Tests;

import org.example.Page.BrowserLaunch;
import org.example.Page.LoginPage;
import org.example.Page.ProductPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ProductTest extends BrowserLaunch {

    LoginPage login;
    ProductPage product;

    @BeforeMethod
    public void loginToApplication() {

        login = new LoginPage(driver);
        login.login("standard_user", "secret_sauce");

        product = new ProductPage(driver);
    }

    @Test
    public void verifyProductListTest() {
        product.verifyProductList();
    }

    @Test
    public void verifySortAZTest() throws InterruptedException {
        product.verifySortAZ();
    }

    @Test
    public void verifySortZATest()  {
        product.verifySortZA();
    }

    @Test
    public void verifyPriceLowToHighTest() {
        product.verifyPriceLowToHigh();
    }

    @Test
    public void verifyPriceHighToLowTest()  {
        product.verifyPriceHighToLow();
    }

    @Test
    public void verifyProductDetailsTest() {
        product.verifyProductDetails();
    }



}