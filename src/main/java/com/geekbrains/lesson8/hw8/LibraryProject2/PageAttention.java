package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class PageAttention {
    private SelenideElement pagingModeButton = $(By.xpath("//span[@class='substr-img']"));

    @Step("Клик на кнопку для перехода в режим постраничного просмотра")
    public FinalPage successFulBookReading() {
        pagingModeButton.click();
        Cookie cookie = new Cookie("rdsulg", "kmm_2002");

        WebDriver driver = WebDriverRunner.getWebDriver();

        driver.manage().addCookie(cookie);
        driver.navigate().refresh();
        return page(FinalPage.class);
    }
}