package com.geekbrains.lesson8.hw8.OrderProject2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CatalogPage {
    private SelenideElement addToCatalog = $(By.xpath("//td[text()='В каталог']"));

    private SelenideElement addToDiscountsField = $(By.xpath("//div[text()='Акции и скидки']"));

    public SelectionDiscountProductsPage catalog() {
        addToCatalog.click();
        addToDiscountsField.click();
        return page(SelectionDiscountProductsPage.class);
    }

}
