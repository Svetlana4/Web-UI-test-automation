package com.geekbrains.lesson5.hw5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.not;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.hasText;
import static ru.yandex.qatools.htmlelements.matchers.WebElementMatchers.isDisplayed;

public class StudentLibraryTest {
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
        driver.get("https://www.studentlibrary.ru/");
    }

    @Test
    void bookOpeningWork() throws InterruptedException {

        driver.findElement(By.xpath("//div[@class='main-block wrap-catalogue-block']/descendant::span[text()='Каталог']")).click();

        driver.findElement(By.xpath("//span[@class='item-head']")).click();
//        driver.findElement(By.xpath("//span[text()='Медицинские науки']")).click();
        driver.findElement(By.xpath("//a[@name='btn-med-on']")).click();

        driver.findElement(By.xpath("//a[text()='Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("RDS_BODY")));
        assertThat(driver.findElement(By.id("RDS_BODY")), is(isDisplayed()));

        driver.findElement(By.xpath("//input[@autocomplete='off']")).sendKeys("фармакология");
        driver.findElement(By.xpath("//span[@class='input-group-btn']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Результат поиска по «фармакология»']")));
        assertThat(driver.findElement(By.xpath("//h1[text()='Результат поиска по «фармакология»']")), is(isDisplayed()));

        driver.findElement(By.xpath("//a[@href='https://www.studentlibrary.ru/ru/book/06-COS-2401.html']")).click();
        Assertions.assertTrue(driver.getCurrentUrl().contains("06-COS-2401"));


        driver.findElement(By.xpath("//a[@id='a-to_first_chapter']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//h1[text()='Инструкция к электронному руководству к лабораторным занятиям по фармакологии']")));
        assertThat(driver.findElement(By.xpath("//h1[text()='Инструкция к электронному руководству к лабораторным занятиям по фармакологии']")), is(isDisplayed()));

        driver.findElement(By.xpath("//span[@class='substr-img']")).click();

        Cookie cookie = new Cookie("rdsulg", "kmm_2002");
        driver.manage().addCookie(cookie);
        driver.navigate().refresh();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@ontouchmove='font_by_fingers(event)']")));
        assertThat(driver.findElement(By.xpath("//div[@ontouchmove='font_by_fingers(event)']")), is(isDisplayed()));
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
