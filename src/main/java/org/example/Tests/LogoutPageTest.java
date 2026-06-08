package org.example.Tests;

import org.example.Page.LogoutPage;
import org.example.Page.BrowserLaunch;
import org.example.Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogoutPageTest extends BrowserLaunch {

    LoginPage login;
    LogoutPage logout;

    @BeforeMethod
    public void setupPage() {

        login = new LoginPage(driver);
        logout = new LogoutPage(driver);

        login.login("standard_user", "secret_sauce");
    }

    @Test
    public void logoutTest() throws InterruptedException {
        logout.logout();
    }
}
