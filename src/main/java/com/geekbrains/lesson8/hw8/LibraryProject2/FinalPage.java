package com.geekbrains.lesson8.hw8.LibraryProject2;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FinalPage {

    private SelenideElement canBeRead = $(By.xpath("//div[@id='mm4-doc-content-pgs']"));

    public void successBookOpening() {
        canBeRead.shouldBe(visible);
    }

}
