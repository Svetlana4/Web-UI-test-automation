package com.geekbrains.lesson5.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class DaitesobakammasoTest {
    WebDriver driver;
    WebDriverWait webDriverWait;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://daitesobakammaso.ru/");
    }

    @Test
    void checkoutShouldWork() {

        driver.findElement(By.xpath("//td[text()='В каталог']")).click();

        driver.findElement(By.xpath("//div[text()='Акции и скидки']")).click();


        driver.findElement(By.xpath("//div[text()='Филе индейки']")).click();

        driver.findElement(By.xpath("//div[text()='Потрошки северного оленя']")).click();

        driver.findElement(By.xpath("//div[@class='t706__carticon-wrapper']")).click();


        driver.findElement(By.xpath("//input[@data-tilda-rule='name']")).sendKeys("Иван");

        driver.findElement(By.xpath("//input[@data-tilda-rule='email']")).sendKeys("sdf@mail.ru");

        driver.findElement(By.xpath("//input[@type='tel']")).sendKeys("+79897658765");

        driver.findElement(By.xpath("//input[@name='Адрес']")).sendKeys("Москва, Советская, 32,2");

        driver.findElement(By.xpath("//button[text()='Оформить заказ']")).click();


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[text()='Спасибо! Данные успешно отправлены.']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div[text()='Спасибо! Данные успешно отправлены.']")).isDisplayed());
//        assertThat(driver.findElement(By.xpath("//div[text()='Спасибо! Данные успешно отправлены.']")), is(isDisplayed()));
    }
    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
