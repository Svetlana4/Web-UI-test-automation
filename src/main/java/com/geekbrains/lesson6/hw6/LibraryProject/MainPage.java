package com.geekbrains.lesson6.hw6.LibraryProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BaseView {
    public MainPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[@class='wrap-main-blocks']//span[text()='Каталог']")
    public WebElement katalogButton;

    public SectionSelection addKatalog() {
        katalogButton.click();
        return new SectionSelection(driver);
    }


}
