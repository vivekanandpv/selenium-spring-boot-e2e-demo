package com.example.e2edemo.e2e;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage {
    WebDriver driver;
    By searchBox = By.name("q");
    By searchButton = By.name("btnK");
    By titleText = By.tagName("title");

    public GoogleHomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void setContent(String content) {
        driver.findElement(searchBox).sendKeys(content);
    }

    public void search() {
        driver.findElement(searchBox).sendKeys(Keys.ENTER);
    }

    public String getTitle() {
        return driver.findElement(titleText).getText();
    }
}
