package org.example.Tests;

import org.example.Page.BrowserLaunch;
import org.example.Page.LoginPage;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends BrowserLaunch {

    LoginPage login;

    @BeforeMethod
    public void setupPage() {
        login = new LoginPage(driver);
    }

    @Test
    public void validLoginTest() {
        login.ValidLogin();
    }

    @Test
    public void invalidUsernameTest() {
        login.InvalidUsername();
    }

    @Test
    public void invalidPasswordTest() {
        login.InvalidPassword();
    }

    @Test
    public void invalidUsernameAndPasswordTest() {
        login.InvalidUsernameAndPassword();
    }

    @Test
    public void emptyUsernameTest() {
        login.EmptyUsername();
    }

    @Test
    public void emptyPasswordTest() {
        login.EmptyPassword();
    }

    @Test
    public void emptyUsernameAndPasswordTest() {
        login.EmptyUsernameAndPassword();
    }

    @Test
    public void lockedUserTest() {
        login.LockedUser();
    }

    @Test
    public void randomUserNameAndPasswordTest() {
        login.RandomUserNameAndPassword();
    }

    @Test
    public void urlAfterLoginTest() {
        login.UrlAfterLogin();
    }
}