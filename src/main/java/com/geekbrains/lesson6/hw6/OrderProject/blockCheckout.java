package com.geekbrains.lesson6.hw6.OrderProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class blockCheckout extends BasePage {
    public blockCheckout(WebDriver driver) {
        super(driver);
    }
    @FindBy(xpath = "//input[@name='Имя']")
    public WebElement nameField;

    @FindBy(xpath= "//input[@name='Email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@type='tel']")
    public WebElement phoneField;

    @FindBy(xpath = "//input[@name='Адрес']")
    public WebElement addressFiled;

    @FindBy(xpath = "//button[text()='Оформить заказ']")
    public WebElement clickCheckoutButton;

    public YourOrderBlock fillData(String name, String email, String phone, String addr) {
        nameField.sendKeys(name);
        emailField.sendKeys(email);
        phoneField.sendKeys(phone);
        addressFiled.sendKeys(addr);
        clickCheckoutButton.click();

        return new YourOrderBlock(driver);
    }


}
