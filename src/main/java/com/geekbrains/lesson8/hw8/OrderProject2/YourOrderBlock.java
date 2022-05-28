package com.geekbrains.lesson8.hw8.OrderProject2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class YourOrderBlock {
    private SelenideElement successOrder = $(By.xpath("//div[text()='Спасибо! Данные успешно отправлены.']"));

    public void successfulOrdering() {
        successOrder.shouldBe(visible);
    }
}
