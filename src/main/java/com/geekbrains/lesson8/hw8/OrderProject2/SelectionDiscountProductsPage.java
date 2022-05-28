package com.geekbrains.lesson8.hw8.OrderProject2;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class SelectionDiscountProductsPage {
    private ElementsCollection productList = $$(By.xpath("//div[contains(@class,'t-store__valign-buttons')]//div[contains(@class,'t-store__card__title')]"));

    public SelectionDiscountProductsPage selectProduct(String product) {
        productList.findBy(text(product)).click();
        return this;
    }

    private SelenideElement clickShoppingCartIcon = $(By.xpath("//div[@class='t706__carticon-wrapper']"));

    public BlockCheckout addDiscountProductsToCart() {
        clickShoppingCartIcon.click();
        return page(BlockCheckout.class);
    }

}