package com.geekbrains.lesson6.hw6.LibraryProject;

import com.geekbrains.lesson7.hw7.CustomLogger;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Allure;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.events.EventFiringDecorator;

@Epic("Студенческая интернет библиотека")
public class StudentLibraryAutomationTest {
    WebDriver driver;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new EventFiringDecorator(new CustomLogger()).decorate(new ChromeDriver());
    }

    @Test
    @Feature("Библиотека")
    @Story("Поиск и чтение книги онлайн")
    void bookOpeningWork() {
        driver.get("https://www.studentlibrary.ru/");
        FinalPage finalPage = new MainPage(driver)
                .addCatalog()
                .kitSelection("Медицина (ВО) ГЭОТАР-Медиа. Базовый комплект")
                .bookSearch("фармакология 2018 Харкевич")
                .selectFromList("2018", "Фармакология", "Харкевич Д.А.")
                .clickButtonReadOnline()
                .successFulBookReading();

        Assertions.assertTrue(finalPage.canBeRead.isDisplayed());
    }

    @AfterEach
    void tearDown() {
        LogEntries logEntries = driver.manage().logs().get(LogType.BROWSER);

        for (LogEntry logEntry : logEntries) {
            Allure.addAttachment("Элемент лога браузера", logEntry.getMessage());
        }
        driver.quit();
    }
}
