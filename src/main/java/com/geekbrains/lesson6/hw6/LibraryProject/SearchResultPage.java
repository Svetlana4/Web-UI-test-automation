package com.geekbrains.lesson6.hw6.LibraryProject;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchResultPage extends BaseView {

    public SearchResultPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='wrap-title-book-sengine']")
    public List<WebElement> bookSearchItemsList;

    @Step("Выбор книги по году выпуска, автору и названию")
    public BookPage selectFromList(String year, String name_book, String author) {

        WebElement book = bookSearchItemsList.stream().filter(y -> y.getText().contains(year))
                .filter(n -> n.getText().contains(author))
                .filter(a -> a.getText().contains(name_book)).findFirst().get();
        book.findElement(By.xpath(".//h2")).click();

        return new BookPage(driver);
    }
}
