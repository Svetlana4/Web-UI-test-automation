package com.geekbrains.lesson6.hw6.LibraryProject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BookPage extends BaseView {
    public BookPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//a[@id='a-to_first_chapter']")
    public WebElement buttonReadOnline;

    @Step("Клик на кнопку Читать онлайн")
    public PageAttention clickButtonReadOnline() {
        buttonReadOnline.click();
        return new PageAttention(driver);
    }
}
