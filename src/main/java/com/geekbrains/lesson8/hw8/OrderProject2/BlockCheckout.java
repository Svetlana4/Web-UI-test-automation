package com.geekbrains.lesson8.hw8.OrderProject2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class BlockCheckout {
    private SelenideElement nameField = $(By.xpath("//input[@name='Имя']"));

    private SelenideElement emailField = $(By.xpath("//input[@name='Email']"));

    private SelenideElement phoneField = $(By.xpath("//input[@type='tel']"));

    private SelenideElement addressFiled = $(By.xpath("//input[@name='Адрес']"));

    private SelenideElement clickCheckoutButton = $(By.xpath("//button[text()='Оформить заказ']"));

    public YourOrderBlock fillData(String name, String email, String phone, String addr) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        addressFiled.sendKeys(addr);
        clickCheckoutButton.click();
        return page(YourOrderBlock.class);
    }


}
