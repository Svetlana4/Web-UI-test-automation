package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SearchResultPage {
    private ElementsCollection bookSearchItemsList = $$(By.xpath("//div[@class='wrap-title-book-sengine']"));

    @Step("Выбор книги по году выпуска, автору и названию")
    public BookPage selectFromList(String year, String name_book, String author) {
        SelenideElement book = bookSearchItemsList.filterBy(text(year))
                .filterBy(text(name_book))
                .findBy(text(author));
        book.find(By.xpath(".//h2")).click();

        return page(BookPage.class);
    }
}
// sizeList.stream().filter(s -> s.getText().contains(size)).findFirst().get().click();
//         sizeList.findBy(text(size)).click();