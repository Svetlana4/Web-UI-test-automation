package com.geekbrains.lesson6.hw6.LibraryProject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookSearchPage extends BaseView {
    public BookSearchPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@autocomplete='off']")
    public WebElement writeNameBookField;

    @FindBy(xpath = "//span[@class='input-group-btn']")
    public WebElement pressSearch;

    @Step("Печатаем название книги в поле поиска ")
    public SearchResultPage bookSearch(String name_book) {
        writeNameBookField.sendKeys(name_book);
        pressSearch.click();
        return new SearchResultPage(driver);

    }


}
