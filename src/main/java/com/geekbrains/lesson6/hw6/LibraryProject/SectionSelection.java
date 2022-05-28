package com.geekbrains.lesson6.hw6.LibraryProject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
public class SectionSelection extends BaseView {
    public SectionSelection(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "btn-med-on")
    private WebElement scienceSelect;

    @FindBy(xpath = "//div[@id='item-med']//a")
    private List<WebElement> kitList;

    @Step("Выбор науки и комплекта по направлению")
    public BookSearchPage kitSelection(String nameKit) {
        scienceSelect.click();
        kitList.stream().filter(k -> k.getText().contains(nameKit)).findFirst().get().click();
        return new BookSearchPage(driver);
    }
}
