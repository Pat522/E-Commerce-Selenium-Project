package org.example.Page;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProductPage {

    WebDriver driver;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
    }

    By productTitle = By.className("title");


    By sortDropdown = By.className("product_sort_container");
    By productNames = By.id("item_4_title_link");
    By productPrices = By.className("inventory_item_price");

    By backpackProduct = By.id("item_4_title_link");
    By productDetailName = By.className("inventory_details_name");
    By productDetailDesc = By.className("inventory_details_desc");
    By productDetailPrice = By.className("inventory_details_price");

    public void verifyProductList() {

        String actualTitle = driver.findElement(productTitle).getText();

        Assert.assertEquals(actualTitle, "Products",
                "Product page title is not matching");

    }

    public void verifySortAZ() throws InterruptedException {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (A to Z)");

        List<String> actualList = new ArrayList<>();

        for (WebElement product : driver.findElements(productNames)) {
            actualList.add(product.getText());
        }

        List<String> expectedList = new ArrayList<>(actualList);
        Collections.sort(expectedList);

        Assert.assertEquals(actualList, expectedList);
        Thread.sleep(1000);
    }

    public void verifySortZA() {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Name (Z to A)");

        List<String> actuallist = new ArrayList<>();
        for (WebElement product : driver.findElements(productNames)) {
            actuallist.add(product.getText());
        }

        List<String> expectedList = new ArrayList<>(actuallist);
        expectedList.sort(Collections.reverseOrder());

        Assert.assertEquals(actuallist, expectedList);

    }

    public void verifyPriceLowToHigh()  {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Price (low to high)");

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : driver.findElements(productPrices)) {
            //"First I get the price text from the UI, remove the dollar sign, convert it to Double, and then store it in a list for sorting validation."
            actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        Collections.sort(expectedPrices);

        Assert.assertEquals(actualPrices, expectedPrices);


    }

    public void verifyPriceHighToLow()  {

        Select select = new Select(driver.findElement(sortDropdown));
        select.selectByVisibleText("Price (high to low)");

        List<Double> actualPrices = new ArrayList<>();

        for (WebElement price : driver.findElements(productPrices)) {
            //"First I get the price text from the UI, remove the dollar sign, convert it to Double, and then store it in a list for sorting validation."
            actualPrices.add(Double.parseDouble(price.getText().replace("$", "")));
        }

        List<Double> expectedPrices = new ArrayList<>(actualPrices);
        expectedPrices.sort(Collections.reverseOrder());

        Assert.assertEquals(actualPrices, expectedPrices);

    }

    public void verifyProductDetails() {

        // Open Product
        driver.findElement(backpackProduct).click();

        // Verify Product Details Page
        Assert.assertEquals(
                driver.findElement(productDetailName).getText(),
                "Sauce Labs Backpack");

        Assert.assertTrue(
                driver.findElement(productDetailDesc).isDisplayed(),
                "Product description is not displayed");

        Assert.assertEquals(
                driver.findElement(productDetailPrice).getText(),
                "$29.99");


    }


}