package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SectionSelection {
    private SelenideElement scienceSelect = $(By.id("btn-med-on"));

    private ElementsCollection kitList = $$(By.xpath("//div[@id='item-med']//a"));

    @Step("Выбор науки и комплекта по направлению")
    public BookSearchPage kitSelection(String nameKit) {
        scienceSelect.click();
        kitList.findBy(text(nameKit)).click();
        return page(BookSearchPage.class);
    }
}


