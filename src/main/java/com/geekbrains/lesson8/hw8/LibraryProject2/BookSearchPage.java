package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BookSearchPage {
    private SelenideElement writeNameBookField = $(By.xpath("//input[@autocomplete='off']"));

    private SelenideElement pressSearch = $(By.xpath("//span[@class='input-group-btn']"));

    @Step("Печатаем название книги в поле поиска ")
    public SearchResultPage bookSearch(String nameBook) {
        writeNameBookField.sendKeys(nameBook);
        pressSearch.click();
        return page(SearchResultPage.class);

    }


}
