package com.geekbrains.lesson6.hw6.OrderProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SelectionDiscountProductsPage extends BasePage {
    public SelectionDiscountProductsPage(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[contains(@class,'t-store__valign-buttons')]//div[contains(@class,'t-store__card__title')]")
    private List<WebElement> productList;

    public SelectionDiscountProductsPage selectProduct(String product) {
        productList.stream().filter(p -> p.getText().contains(product)).findFirst().get().click();
        return this;
    }
    @FindBy(xpath = "//div[@class='t706__carticon-wrapper']")
    public WebElement clickShoppingCartIcon;

    public blockCheckout addDiscountProductsToCart() {
        clickShoppingCartIcon.click();
        return new blockCheckout(driver);
    }

}