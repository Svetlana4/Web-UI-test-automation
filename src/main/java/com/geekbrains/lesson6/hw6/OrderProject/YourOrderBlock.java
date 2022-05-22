package com.geekbrains.lesson6.hw6.OrderProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourOrderBlock extends BasePage {
    public YourOrderBlock(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//div[text()='Спасибо! Данные успешно отправлены.']")
    public WebElement successOrder;
}
