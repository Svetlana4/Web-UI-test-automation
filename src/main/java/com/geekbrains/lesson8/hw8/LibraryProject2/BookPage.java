package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BookPage {
    private SelenideElement buttonReadOnline = $(By.xpath("//a[@id='a-to_first_chapter']"));

    @Step("Клик на кнопку Читать онлайн")
    public PageAttention clickButtonReadOnline() {
        buttonReadOnline.click();
        return page(PageAttention.class);
    }
}

