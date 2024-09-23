package com.example.e2edemo.e2e;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.*;


public class GoogleHomePageTests {
    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class...");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class...");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method...");
    }


    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method...");
    }

    @Test
    public void validatePage() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "/Users/vivekanandpv/edgedriver_mac64_m1/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();

        GoogleHomePage pom = new GoogleHomePage(driver);


        pom.setContent("Hello");
        pom.search();

        Thread.sleep(50);

        Assert.assertTrue(driver.getTitle().startsWith("Hello"));

        driver.close();
    }

    @Test
    public void validatePage2() throws InterruptedException {
        System.setProperty("webdriver.edge.driver", "/Users/vivekanandpv/edgedriver_mac64_m1/msedgedriver");
        WebDriver driver = new EdgeDriver();

        driver.get("https://www.google.co.in");
        driver.manage().window().maximize();

        GoogleHomePage pom = new GoogleHomePage(driver);


        pom.setContent("Horse");
        pom.search();

        Thread.sleep(50);

        Assert.assertTrue(driver.getTitle().startsWith("Horse"));

        driver.close();
    }
}