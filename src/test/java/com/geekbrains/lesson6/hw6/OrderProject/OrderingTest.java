package com.geekbrains.lesson6.hw6.OrderProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

@Ignore
public class OrderingTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofMinutes(5));
    }

    @Test
    void orderingTest() {
        driver.get("https://daitesobakammaso.ru/");
        new CatalogPage(driver)
                .сatalog()
                .selectProduct("Филе индейки")
                .selectProduct("Потрошки северного оленя")
                .addDiscountProductsToCart()
                .fillData("Иван", "sdf@mail.ru", "+79897658765", "Москва, Советская, 32,2");

        webDriverWait.until(ExpectedConditions.visibilityOf(new YourOrderBlock(driver).successOrder));
        Assertions.assertTrue(new YourOrderBlock(driver).successOrder.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
