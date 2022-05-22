package com.geekbrains.lesson6.hw6.OrderProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CatalogPage extends BasePage {
    public CatalogPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//td[text()='В каталог']")
    public WebElement addToKatalog;

    @FindBy(xpath = "//div[text()='Акции и скидки']")
    public WebElement addToDiscountsField;

    public SelectionDiscountProductsPage katalog() {
        addToKatalog.click();
        addToDiscountsField.click();
        return new SelectionDiscountProductsPage(driver);
    }

}
