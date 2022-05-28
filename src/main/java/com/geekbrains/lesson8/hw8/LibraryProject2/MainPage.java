package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class MainPage {
    private SelenideElement catalogButton = $(By.xpath("//div[@class='wrap-main-blocks']//span[text()='Каталог']"));

    @Step("Клик на кнопку Каталог")
    public SectionSelection addCatalog() {
        catalogButton.click();
        return page(SectionSelection.class);
    }

}


