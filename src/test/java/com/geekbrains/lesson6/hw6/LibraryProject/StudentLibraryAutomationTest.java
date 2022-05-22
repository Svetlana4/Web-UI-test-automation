package com.geekbrains.lesson6.hw6.LibraryProject;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StudentLibraryAutomationTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }

    @Test
    void bookOpeningWork() {
        driver.get("https://www.studentlibrary.ru/");
        FinalPage finalPage = new MainPage(driver)
                .addKatalog()
                .kitSelection("Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект")
                .bookSearch("фармакология 2018 Харкевич")
                .selectFromList("2018", "Фармакология", "Харкевич Д.А.")
                .clickButtonReadOnline()
                .successFulBookReading();

        Assertions.assertTrue(finalPage.canBeRead.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
